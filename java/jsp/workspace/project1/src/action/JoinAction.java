package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Member;
import model.MemberDao;
/*
 * ȸ�� ������ ���� Action Ŭ����
 * 1. �Ķ���� ���� Member ��ü ����
 * 2. Member ��ü�� db�� insert
 * 3. ��ϼ��� : loginForm.jsp
 *     ��Ͻ��� : joinForm.jsp
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
