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
			msg="°ü¸®ÀÚ Å»Åð ºÒ°¡";
			url = "list.me";
		}else {
			if(login.equals("admin")||pass.equals(m.getPass())) {
				int result = dao.delete(m);
				if(result>0) {
					if(login.equals("admin")) {
						msg = "°­Á¦ Å»Åð";
						url="list.me";
					}else {
						request.getSession().invalidate();
						msg = "Å»Åð ¼º°ø";
						url = "loginForm.me";
					}
				}else {
					msg="Å»Åð ½ÇÆÐ";
					url="deleteForm.jsp?id="+id;
				}
			}else {
				msg="ºñ¹Ð¹øÈ£ ¿À·ù";
				url="deleteForm.jsp?id="+id;
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	
}
