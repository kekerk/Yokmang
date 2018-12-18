package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import model.AnSDao;
import model.Members;
import model.MembersDao;
import model.Series;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MembersDao dao = new MembersDao();
		Members mem = dao.selectOne(id);
		String msg = "해당 아이디 없음";
		String url = "loginform.jsp";
		if(mem != null) { 
			if(password.equals(mem.getPassword())) {
				msg=id+"님이 로그인 하셨습니다.";
				url ="main.me";
				List<Series> serieslist = new AnSDao().sort();
				int rank = new AnSDao().seriesCount();
				List<Actor> actlist = new AnSDao().listact();
				request.getSession().setAttribute("dormi", mem.getDormi());  
				request.getSession().setAttribute("grade", mem.getGrade());  
				request.getSession().setAttribute("serieslist", serieslist);  
				request.getSession().setAttribute("rank", rank);  
				request.getSession().setAttribute("actlist", actlist);  
				request.getSession().setAttribute("login", id);
			}else {
				msg="비밀번호 오류";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
