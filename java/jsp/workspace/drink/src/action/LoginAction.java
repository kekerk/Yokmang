package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id= request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = "해당 아이디 없음";
		String url = "loginForm.jsp";
		if(mem!=null) {//회원이 존재하는 경우
			if(pass.equals(mem.getPass())) {
				msg= id+"로그인 함";
				url="main.me";
				request.getSession().setAttribute("login", id); //request.getSession().setAttribute("login", id) : login 정보를 세션에 저장
			}else {
				msg="비밀번호 오류";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getSession().setAttribute("name", mem.getName());
		return new ActionForward(false,"../alert.jsp"); //model2 폴더에서 member와 board 공용
	}

}
