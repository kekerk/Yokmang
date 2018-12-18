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
import action.AllBoardAllAction;


@WebServlet(urlPatterns= {"*.all"}, initParams= {@WebInitParam(name="properties",value="Allboard.properties")})
public class AllBoardControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Properties pr = new Properties();
    public AllBoardControllerServlet() {
        super();
    
    }
    public void init(ServletConfig config) throws ServletException{
    	String props = config.getInitParameter("properties");
    	FileInputStream f = null;
    	try {
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
			command = request.getRequestURI().substring(request.getContextPath().length());
			Class[] paramType = new Class[] {HttpServletRequest.class, HttpServletResponse.class};
			Object[] paramObjs = new Object[] {request, response};
			String methodName = pr.getProperty(command);
			Method method = AllBoardAllAction.class.getMethod(methodName, paramType); 
			forward = (ActionForward) method.invoke(new AllBoardAllAction(), paramObjs);
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
					forward.setView(command.replace(".all", ".jsp"));
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
