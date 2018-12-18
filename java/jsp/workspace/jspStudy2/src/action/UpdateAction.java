package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;



public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new MemberDao().selectOne(request.getParameter("id"));
		Member updatemem= new Member();
		updatemem.setId(request.getParameter("id"));
		updatemem.setName(request.getParameter("name"));
		updatemem.setPass(request.getParameter("pass"));
		updatemem.setGender(Integer.parseInt(request.getParameter("gender")));
		updatemem.setTel(request.getParameter("tel"));
		updatemem.setEmail(request.getParameter("email"));
		updatemem.setPicture(request.getParameter("picture"));
		String msg=null;
		String url=null;
		if(!updatemem.getPass().equals(mem.getPass())) {
			msg="비밀번호가 다릅니다.";
			url="updateform.me?id="+updatemem.getId();
		}else {
			int result = new MemberDao().update(updatemem);
			if(result > 0) {
				request.setAttribute("mem", updatemem);
				msg=mem.getId()+"님의 정보가 수정되었습니다.";
				url="main.me";
			}else {
				msg="수정 실패";
				url="updateform.me?id="+updatemem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
