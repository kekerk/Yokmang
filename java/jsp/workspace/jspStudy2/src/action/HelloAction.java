package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//http://
public class HelloAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setAttribute("hello", "hello World");
		return new ActionForward(false,"hello.jsp");
	}
}
