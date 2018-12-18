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
			msg="관리자 탈퇴 불가";
			url="list.me";
		} else {
			if (login.equals("admin")) {
				int result = new MembersDao().delete(mem);
				if (result > 0) {
					msg = mem.getId() + "님 회원 정보 삭제 완료";
					url = "list.me";
				} else {
					msg = "회원 정보 삭제 실패";
					url = "list.me";
				}
			} else {
				if (!mem.getPassword().equals(password)) {
					msg = "비밀번호 오류";
					url = "deleteform.me?id=" + mem.getId();
				} else {
					int result = new MembersDao().delete(mem);
					if (result > 0) {
						request.getSession().invalidate();
						msg = mem.getId() + "님의 탈퇴가 완료되었습니다.";
						url="loginform.me";
					}else {
						msg="게시물을 삭제하고 탈퇴하세요";
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
