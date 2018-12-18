package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		if(login ==null||login.equals("")) { // 로그아웃 상태
			return new ActionForward(true,"loginForm.jsp");
		}else { //로그인 상태
			return new ActionForward(false,"main.jsp");
		}
	}

}
