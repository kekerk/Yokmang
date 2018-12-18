package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class JoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setMax(Integer.parseInt(request.getParameter("max")));
		mem.setTel(request.getParameter("tel"));
		mem.setAddr(request.getParameter("addr"));
		mem.setBirthday(request.getParameter("birthday"));
		mem.setPicture(request.getParameter("picture"));
		int result = new MemberDao().insert(mem);
		if(result>0)return new ActionForward(true,"loginForm.jsp");
		else return new ActionForward(true,"joinForm.jsp");
	}

}
