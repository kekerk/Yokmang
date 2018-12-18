package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 *  �α��� �� ó��
 *  �α��� ������ �ʿ���.
 *  �α����� ����   �α��� ����: main.jsp�� forward
 *  						�α׾ƿ� ���� : loginform.jsp�� redirect ��.
 */
public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login=(String) session.getAttribute("login");
		if(login == null || login.equals("")) { //�α׾ƿ� ����
			return new ActionForward(true,"loginform.jsp");
		}else { //�α��λ���
			return new ActionForward(false,"main.jsp");
		}
	}
}
