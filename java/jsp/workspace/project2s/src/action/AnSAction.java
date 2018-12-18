package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import model.AnSDao;
import model.Series;

public class AnSAction {
	private AnSDao ans = new AnSDao();
	// 등장인물 소개 액션
	public ActionForward infoact(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		Actor actor = ans.selectact(no);
		request.setAttribute("actor", actor);
		int pageNum = 1;
		int limit = 4;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int actcount = ans.actorCount();
		List<Actor> list = ans.listact(pageNum, limit);
		int maxpage = (int) ((double) actcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = actcount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("actcount", actcount);
		request.setAttribute("list", list);
		return new ActionForward(false, "infoact.jsp");
	}
	// 시리즈 소개 액션
	public ActionForward infoseries(HttpServletRequest request, HttpServletResponse response) {
		int seriesno = Integer.parseInt(request.getParameter("seriesno"));
		Series series = ans.selectseries(seriesno);
		request.setAttribute("series", series);
		int pageNum = 1;
		int limit = 3;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int seriescount = ans.seriesCount();
		List<Series> list = ans.listseries(pageNum, limit);
		int maxpage = (int) ((double) seriescount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = seriescount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("actcount", seriescount);
		request.setAttribute("list", list);
		return new ActionForward(false, "infoseries.jsp");
	}
	//등장인물 리스트 액션
	public ActionForward listact(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit = 4;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int actcount = ans.actorCount();
		List<Actor> list = ans.listact(pageNum, limit);
		int maxpage = (int) ((double) actcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = actcount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("actcount", actcount);
		request.setAttribute("list", list);
		return new ActionForward(false, "infoact.jsp");
	}
	// 시리즈 리스트 액션
	public ActionForward listseries(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit = 3;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int seriescount = ans.seriesCount();
		List<Series> list = ans.listseries(pageNum, limit);
		int maxpage = (int) ((double) seriescount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = seriescount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("actcount", seriescount);
		request.setAttribute("list", list);
		return new ActionForward(false, "infoseries.jsp");
	}
	
}
