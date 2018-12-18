package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class DeleteAction extends UserLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne(id);
		String msg = null;
		String url = null;
		if(id.equals("admin")) {
			msg="������ Ż�� �Ұ�";
			url = "list.me";
		}else {
			if(login.equals("admin")||pass.equals(m.getPass())) {
				int result = dao.delete(m);
				if(result>0) {
					if(login.equals("admin")) {
						msg = "���� Ż��";
						url="list.me";
					}else {
						request.getSession().invalidate();
						msg = "Ż�� ����";
						url = "loginForm.me";
					}
				}else {
					msg="Ż�� ����";
					url="deleteForm.jsp?id="+id;
				}
			}else {
				msg="��й�ȣ ����";
				url="deleteForm.jsp?id="+id;
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	
}
