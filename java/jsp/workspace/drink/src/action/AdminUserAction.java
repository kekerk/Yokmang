package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AdminUserAction implements Action{
	protected String login;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		login = (String)request.getSession().getAttribute("login");
		String msg = null;
		String url = null;
		if(login == null) {
			msg = "로그인하세요";
			url = "loginForm.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		}
		if(!login.equals("admin")) {
			msg = "관리자만 조회 가능합니다.";
			url="main.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		}
		return doExecute(request,response);
	}
	public abstract ActionForward doExecute(HttpServletRequest request, HttpServletResponse response)
	throws Exception;
}