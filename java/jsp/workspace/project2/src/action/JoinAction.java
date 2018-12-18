package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;
import model.MembersDao;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			Members mem = new Members();
			mem.setId(request.getParameter("id"));
			mem.setName(request.getParameter("name"));
			mem.setNickname(request.getParameter("nickname"));
			mem.setPassword(request.getParameter("password"));
			mem.setGender(Integer.parseInt(request.getParameter("gender")));
			if(request.getParameter("dormi").equals("1")) {
				mem.setDormi("Gryffindor");
			}else if(request.getParameter("dormi").equals("2")){
				mem.setDormi("Slytherin");
			}
			else if(request.getParameter("dormi").equals("3")){
				mem.setDormi("Hufflepuff");
			}else {
				mem.setDormi("Ravenclaw");
			}
			mem.setGrade(Integer.parseInt(request.getParameter("grade")));
			mem.setEmail(request.getParameter("email"));
			mem.setTel(request.getParameter("tel"));
			mem.setBoardcnt(0);
			int result = new MembersDao().insert(mem);
			if(result > 0) return new ActionForward(true,"loginform.jsp");
			else return new ActionForward(true,"joinform.jsp");
	}
}
