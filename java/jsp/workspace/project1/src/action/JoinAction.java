package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Member;
import model.MemberDao;
/*
 * 회원 가입을 위한 Action 클래스
 * 1. 파라미터 정보 Member 객체 저장
 * 2. Member 객체를 db에 insert
 * 3. 등록성공 : loginForm.jsp
 *     등록실패 : joinForm.jsp
 */

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			Member mem = new Member();
			mem.setId(request.getParameter("id"));
			mem.setName(request.getParameter("name"));
			mem.setPass(request.getParameter("pass"));
			mem.setGender(Integer.parseInt(request.getParameter("gender")));
			mem.setEmail(request.getParameter("email"));
			mem.setTel(request.getParameter("tel"));
			mem.setPicture(request.getParameter("picture"));
			System.out.println(mem);
			int result = new MemberDao().insert(mem);
			
			if(result > 0) return new ActionForward(true,"loginform.jsp");
			else return new ActionForward(true,"homemain.jsp");
	}
}
