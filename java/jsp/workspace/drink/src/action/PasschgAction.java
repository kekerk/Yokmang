package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class PasschgAction extends UserLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pass = request.getParameter("pass");
		String chgpass = request.getParameter("chgpass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = null;
		String url = null;
		if(pass.equals(mem.getPass())) {
			if(dao.updatepass(id, chgpass)>0) {
				msg = "��й�ȣ ���� �Ϸ�";
				url = "main.jsp";
				request.setAttribute("close", "self.close();");
			}else {
				msg = "���� ����";
				url = "passchgForm.jsp";
			}
		}else {
			msg = "���� ��ȣ ����";
			url = "passchgForm.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
