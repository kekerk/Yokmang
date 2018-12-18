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
 * urlPatterns = {"*.me"} : xxx.me 요청시 ControllerServlet 서블릿 호출
 */
@WebServlet(urlPatterns= {"*.me"}, 
initParams= {@WebInitParam (name="properties", value="action.properties")})

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,Action> commandMap = new HashMap<String,Action>();
       
    public ControllerServlet() {
        super();
    }
    /*
     * init : 서블릿이 처음 호출 시 한 번 실행되는 메서드
     * config : properties = action.properties config 객체 전달.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//props : "action.properties" 저장
    	String props = config.getInitParameter("properties");
    	//pr : Map 객체. (Key,value) 쌍
    	// Hashtable 클래스의 하위 객체 : Properties 클래스.
    	Properties pr = new Properties();
    	FileInputStream f = null;
    	try {
    		// f : /WEB-INF/action.properties 파일을 지정
    		f = new FileInputStream(config.getServletContext().getRealPath("/")+"WEB-INF/"+props);
    		pr.load(f);;
    		/*
    		 *  /model2/hello.me=action.HelloAction
    		 * pr.put("/model2/hello.me","action.HelloAction")
    		 */
    	} catch(IOException e) {
    		throw new ServletException(e);
    	}finally {
    		try {
    			if(f!=null) f.close();
    		}catch(IOException e) {}
    	}
    	for(Object k : pr.keySet()) {
    		String command = (String)k; // /model2/hello.me
    		String className=pr.getProperty(command); // "action.HelloAction"
    		try {
//commandClass    : action.HelloAction 클래스를 로드
//newInstance     : 객체화 시킴
//commandInstance : action.HelloAction 클래스의 객체 저장
    			Class commandClass = Class.forName(className);
    			Object commandInstance = commandClass.newInstance();
//                         key      ,    value
//commandMap      : /model2/hello.me, action.HelloAction 객체
    			commandMap.put(command, (Action)commandInstance);
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
    	}
    }
/*
 *  doGet 메서드가 실행되면 commandMap만 남는다.
 * method 를 post방식으로 하지 않았기 때문에 url 방식으로 들어오면 doGet이 먼저 실행된다.
 * doPost를 쓰기 위해서는 form에서 method를 post로 실행해야 한다.
 * 
 * command [/model2/hello.me]
 * action = commandMap.get(command); : HelloAction 객체가 들어간다.
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); //파라미터 인코딩
		Action action = null;
		ActionForward forward = null;
		String command=null;
		try {
// request.getRequestURI : jspStudy2/model2/hello.me
// request.getContextPath() : /jspStudy2
// command : /model2/hello.me 저장. commandMap객체의 key값 중 한개
			command = request.getRequestURI().substring(request.getContextPath().length());
			//action : action.HelloAction 객체를 저장.
			action = commandMap.get(command);
			//forward : new ActionForward(false,"hello.jsp")
			//리턴타입은 forward로 execute 메서드 안에 request와 response가 들어감.
			forward = action.execute(request,response);
		}catch(NullPointerException e) {
			forward = new ActionForward(false,null);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getView());
			}else {
				//forward 대상 페이지를 설정
				if(forward.getView()==null) {
					forward.setView(command.replace(".me", ".jsp"));
				}
				//forward가 null이 아니므로 바로 else로 와서 RequestDispatcher 객체를 생성함.
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getView()) ;// forward.getView() : hello.jsp
		//      hello.jsp . 
				dispatcher.forward(request, response);
			}
		}else {
			response.sendRedirect("nopage.jsp");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
