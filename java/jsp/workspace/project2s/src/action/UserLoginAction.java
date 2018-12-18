package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class UserLoginAction implements Action {
	protected String login;
	protected String id;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		login = (String)request.getSession().getAttribute("login");
		id = request.getParameter("id");
		String type=null;
		if(request.getRequestURI().contains("delete"))
			type="삭제";
		else if(request.getRequestURI().contains("update"))
			type="수정";
		else if(request.getRequestURI().contains("repass"))
			type="비밀번호 재설정";
		else
			type="조회";
		if(login==null) {
			request.setAttribute("msg","로그인 후 거래하세요");
			request.setAttribute("url","loginform.jsp");
			return new ActionForward(false,"../alert.jsp");
		}else {
			if(!login.equals(id) && !login.equals("admin")) {
				request.setAttribute("msg", "본인 정보만 "+type+" 가능합니다.");
				request.setAttribute("url", "main.jsp");
				return new ActionForward(false,"../alert.jsp");
			}
		}
		return doExecute(request, response);
	}
	
	public abstract ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception; //body가 없는 추상 메서드

}
