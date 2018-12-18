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
			msg="비밀번호가 다릅니다";
			request.setAttribute("type", type);
			url="repassform.me?id="+mem.getId();
		}else {
			int result = new MemberDao().updatepass(id,pass2);
			if(result>0) {
				msg = mem.getId()+"님의 비밀번호가 변경되었습니다";
				request.setAttribute("type", type);
				url="main.me?id="+mem.getId();
			}else {
				msg="비밀번호 변경 실패";
				request.setAttribute("type", type);
				url="repassform.me?id="+mem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
