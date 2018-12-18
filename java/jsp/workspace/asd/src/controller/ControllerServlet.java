package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/*
 *  urlPatterns={"*.me"} : xxx.me 요청시 ControllerServlet 서블릿 호출
 *  /model2/hello.me 요청
 */
@WebServlet(urlPatterns= {"*.me"}, initParams= {@WebInitParam (name="properties", value="action.properties")})

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String,Action> commandMap = new HashMap<String,Action>();    
    public ControllerServlet() {
        super();
    }
    /*
     *  init : 서블릿이 처음 호출시 한번 실행되는 메서드 -> action.properties에 들어있는 객체가 등록.
     *  config : properties = action.properties config 객체 전단
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
    	// props :  "action.properties" 저장
    	String props = config.getInitParameter("properties");
    	Properties pr = new Properties();
    	//  pr : Map 객체 (key, value) 쌍 
    	// Hashtable 클래스 > Properties 클래스.
    	FileInputStream f = null;
    	try {
    		// f : /WEB-INF/action.properties 파일을 지정.
    		f = new FileInputStream(config.getServletContext().getRealPath("/")+"WEB-INF/"+props);
    		pr.load(f);
    		/*
    		 *  /model2/hello.me=action.HelloAction
    		 *  pr.put("/model2/hello.me" , "action.HelloAction")
    		 */
    	}catch(IOException e) {
    		throw new ServletException(e);
    	}finally {
    		try {
    			if(f != null) f.close();
    		}catch(IOException e) {}
     	}
    	for(Object k : pr.keySet()) {
    		String command = (String) k; // "/model2/hello.me"
    		String className= pr.getProperty(command); // "action.HelloAction"
    		try {
    			// commandClass : action.HelloAction 클래스를 로드
    			Class commandClass = Class.forName(className); 
    			// newInstance : 객체화 시킴.
    			// commandinstance : action.HelloAction 클래스의 객체 저장
    			Object commandInstance = commandClass.newInstance(); //객체화(인스턴스화)
    			commandMap.put(command, (Action)commandInstance); // /model2/hello.me, action.HelloAction 객체 저장
    		}catch(Exception e) {
    			throw new ServletException(e);
    		}
    	}
    }
    
    //url요청 들어왔을 때 -> do get() 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); // 파라미터 인코딩. 
		Action action = null;
		ActionForward forward = null;
		String command = null;
		try {
			//  request.getRequestURI() : /jspStudy2/model2/hello.me
			// request.getContextPath() : /jspStudy2/
			// command : /model2/hello.me 저장. commandMap 객체의 key 값 중 한개.
			command = request.getRequestURI().substring(request.getContextPath().length());// 10("/") 부터 가져온다. -> model2/hello.me
			// action : action.HelloAction 객체를 저장.
			action = commandMap.get(command);
			// forward = new ActionForward(false,"hello.jsp") 저장
			forward = action.execute(request,response);
		}catch(NullPointerException e) {
			forward = new ActionForward(false,null);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getView());
			}else {
				if(forward.getView()==null) {
					forward.setView(command.replace(".me", ".jsp"));
				}
				// forward 대상 페이지를 설정.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getView());  
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("nopage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
