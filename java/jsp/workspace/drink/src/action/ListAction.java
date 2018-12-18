package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class ListAction extends UserLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = null;
		String url = null;
		if(!login.equals("admin")) {
			msg="관리자만 조회 가능합니다.";
			url = "main.me";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		}else {
			List<Member> list = new MemberDao().list();
			request.setAttribute("list", list);
			return new ActionForward(false,"list.jsp");
		}
	}

}
