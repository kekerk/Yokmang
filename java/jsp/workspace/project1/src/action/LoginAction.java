package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;
/*
 * 1. id, pass 파라미터 저장
 * 2. id로 db에서 회원정보 조회. 없으면 해당 아이디 없음. alert -> loginform.jsp
 * 3. 아이디가 있으면 pass 검증
 * 		비밀번호 일치 : id 님이 로그인 하셨습니다.  -> main.me
 * 		비밀번호 불일치 : 비밀번호가 틀립니다.       -> loginform.jsp
 */
public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = "해당 아이디 없음";
		String url = "loginform.jsp";
		if(mem != null) { // 회원이 존재하는 경우
			if(pass.equals(mem.getPass())) {
				msg=id+"님이 로그인 하셨습니다.";
				url ="main.me";
				request.getSession().setAttribute("login", id);  //request.getSession().setAttribute("login", id) : id 정보를 세션에 "login" 저장. 
				request.getSession().setAttribute("name", mem.getName());  //request.getSession().setAttribute("login", id) : id 정보를 세션에 "login" 저장. 
				System.out.println(id);
				System.out.println(mem.getName());
			}else {
				msg="비밀번호 오류";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp"); //model2 폴더에서 member와 board 공용
	}
}
