package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class DeleteAction extends UserLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login = (String) request.getSession().getAttribute("login");
		String pass = request.getParameter("pass");
		String msg = null;
		String url = null;
		Member mem = new MemberDao().selectOne(id);
		if (id.equals("admin")) {
			msg="������ Ż�� �Ұ�";
			url="list.me";
		} else {
			if (login.equals("admin")) {
				int result = new MemberDao().delete(mem);
				if (result > 0) {
					msg = mem.getId() + "�� ȸ�� ���� ���� �Ϸ�";
					url = "list.me";
				} else {
					msg = "ȸ�� ���� ���� ����";
					url = "list.me";
				}
			} else {
				if (!mem.getPass().equals(pass)) {
					msg = "��й�ȣ ����";
					url = "deleteform.me?id=" + mem.getId();
				} else {
					int result = new MemberDao().delete(mem);
					if (result > 0) {
						request.getSession().invalidate();
						msg = mem.getId() + "���� Ż�� �Ϸ�Ǿ����ϴ�.";
						url="loginform.me";
					}else {
						msg="Ż�� ����";
						url="deleteform.me?id="+mem.getId();
					}
				}
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
