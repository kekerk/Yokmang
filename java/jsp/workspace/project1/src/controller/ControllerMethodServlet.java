package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import action.BoardAllAction;


@WebServlet(urlPatterns= {"*.bo"}, initParams= {@WebInitParam(name="properties",value="method.properties")})
public class ControllerMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Properties : Map<String,String> ��ü.  -> FileInputStream���� �ѹ��� ó�� ����.	
    private Properties pr = new Properties();
    public ControllerMethodServlet() {
        super();
    
    }
    public void init(ServletConfig config) throws ServletException{
    	// props : "method.properties" ����.
    	String props = config.getInitParameter("properties");
    	FileInputStream f = null;
    	try {
    		// f : WEB-INF/method.properties ������ �б� ���� �Է� ��Ʈ��.
    		// properties ������ " /model2/hello.bo=hello " ����  key : /model2/hello.bo  value:hello
    		f = new FileInputStream(config.getServletContext().getRealPath("/")+"WEB-INF/"+props);
    		pr.load(f);
    	}catch(IOException e) {throw new ServletException(e);}
    	finally {
    		try {
    			if(f != null) f.close();
    		}catch(IOException e) {}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = null;
		String command =null;
		try {
			// command : "/model2/hello.bo"
			command = request.getRequestURI().substring(request.getContextPath().length());
			Class[] paramType = new Class[] {HttpServletRequest.class, HttpServletResponse.class};
			Object[] paramObjs = new Object[] {request, response};
			// methodName : "hello"
			String methodName = pr.getProperty(command);
			// method : BoardAllAction Ŭ�������� hello(HttpServletRequest,HttpServletResponse) �̸��� �޼��� ����
			// 				  ������ �̸��� �ش��ϴ� �޼��� ��ü.
			//                �޼��� ��ü�� ��üȭ.
			Method method = BoardAllAction.class.getMethod(methodName, paramType);  //�����ε� : �Ű����� Ÿ���� �ٸ��� �ٸ� �޼��带 ã�� �ȴ�.
			// invoke : method�� ȣ��.
			// forward = new BoardAllAction().hello(request,response);
			forward = (ActionForward) method.invoke(new BoardAllAction(), paramObjs);
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
					forward.setView(command.replace(".bo", ".jsp"));
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getView());
				dispatcher.forward(request, response);
			}
		}else {
			response.sendRedirect("nopage.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}