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
				msg = "비밀번호 변경 완료";
				url = "main.jsp";
				request.setAttribute("close", "self.close();");
			}else {
				msg = "수정 오류";
				url = "passchgForm.jsp";
			}
		}else {
			msg = "기존 암호 오류";
			url = "passchgForm.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
