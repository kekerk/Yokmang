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
			msg="관리자 탈퇴 불가";
			url="list.me";
		} else {
			if (login.equals("admin")) {
				int result = new MemberDao().delete(mem);
				if (result > 0) {
					msg = mem.getId() + "님 회원 정보 삭제 완료";
					url = "list.me";
				} else {
					msg = "회원 정보 삭제 실패";
					url = "list.me";
				}
			} else {
				if (!mem.getPass().equals(pass)) {
					msg = "비밀번호 오류";
					url = "deleteform.me?id=" + mem.getId();
				} else {
					int result = new MemberDao().delete(mem);
					if (result > 0) {
						request.getSession().invalidate();
						msg = mem.getId() + "님의 탈퇴가 완료되었습니다.";
						url="loginform.me";
					}else {
						msg="탈퇴 실패";
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
