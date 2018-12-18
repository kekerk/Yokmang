package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnSDao;
import model.Series;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login=(String) session.getAttribute("login");
		List<Series> serieslist = new AnSDao().sort();
		int rank = new AnSDao().seriesCount();
		if(login == null || login.equals("")) { //로그아웃 상태
			return new ActionForward(true,"loginform.jsp");
		}else { //로그인상태
			// 시리즈 랭크 순으로 배열
			request.setAttribute("serieslist", serieslist); 
			request.setAttribute("rank", rank);
			return new ActionForward(false,"homemain.jsp");
		}
	}
}
