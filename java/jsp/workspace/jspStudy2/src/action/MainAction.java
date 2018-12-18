package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *  로그인 후 처리
 *  로그인 검증이 필요함.
 *  로그인이 검증   로그인 상태: main.jsp로 forward
 *  						로그아웃 상태 : loginform.jsp로 redirect 함.
 */
public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login=(String) session.getAttribute("login");
		if(login == null || login.equals("")) { //로그아웃 상태
			return new ActionForward(true,"loginform.jsp");
		}else { //로그인상태
			return new ActionForward(false,"main.jsp");
		}
	}
}
