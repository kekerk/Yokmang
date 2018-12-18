package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import model.Member;
import model.MemberDao;

public class RepassAction extends UserLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		Member mem = new MemberDao().selectOne(id);
		String msg=null;
		String url=null;
		String type = "repass";
		if(!mem.getPass().equals(pass1)) {
			msg="��й�ȣ�� �ٸ��ϴ�";
			request.setAttribute("type", type);
			url="repassform.me?id="+mem.getId();
		}else {
			int result = new MemberDao().updatepass(id,pass2);
			if(result>0) {
				msg = mem.getId()+"���� ��й�ȣ�� ����Ǿ����ϴ�";
				request.setAttribute("type", type);
				url="main.me?id="+mem.getId();
			}else {
				msg="��й�ȣ ���� ����";
				request.setAttribute("type", type);
				url="repassform.me?id="+mem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
