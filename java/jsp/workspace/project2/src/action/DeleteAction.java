package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;
import model.MembersDao;

public class DeleteAction extends UserLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login = (String) request.getSession().getAttribute("login");
		String password = request.getParameter("password");
		String msg = null;
		String url = null;
		Members mem = new MembersDao().selectOne(id);
		if (id.equals("admin")) {
			msg="������ Ż�� �Ұ�";
			url="list.me";
		} else {
			if (login.equals("admin")) {
				int result = new MembersDao().delete(mem);
				if (result > 0) {
					msg = mem.getId() + "�� ȸ�� ���� ���� �Ϸ�";
					url = "list.me";
				} else {
					msg = "ȸ�� ���� ���� ����";
					url = "list.me";
				}
			} else {
				if (!mem.getPassword().equals(password)) {
					msg = "��й�ȣ ����";
					url = "deleteform.me?id=" + mem.getId();
				} else {
					int result = new MembersDao().delete(mem);
					if (result > 0) {
						request.getSession().invalidate();
						msg = mem.getId() + "���� Ż�� �Ϸ�Ǿ����ϴ�.";
						url="loginform.me";
					}else {
						msg="�Խù��� �����ϰ� Ż���ϼ���";
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
