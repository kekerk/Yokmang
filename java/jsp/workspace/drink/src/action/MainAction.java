package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		if(login ==null||login.equals("")) { // �α׾ƿ� ����
			return new ActionForward(true,"loginForm.jsp");
		}else { //�α��� ����
			return new ActionForward(false,"main.jsp");
		}
	}

}
