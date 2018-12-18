package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import model.Members;
import model.MembersDao;

public class RepassAction extends UserLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Members mem = new MembersDao().selectOne(id);
		String msg=null;
		String url=null;
		if(!mem.getPassword().equals(password1)) {
			msg="��й�ȣ�� �ٸ��ϴ�";
			url="repassform.me?id="+mem.getId();
		}else {
			int result = new MembersDao().updatepass(id,password2);
			if(result>0) {
				msg = mem.getId()+"���� ��й�ȣ�� ����Ǿ����ϴ�";
				url="main.me?id="+mem.getId();
			}else {
				msg="��й�ȣ ���� ����";
				url="repassform.me?id="+mem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
