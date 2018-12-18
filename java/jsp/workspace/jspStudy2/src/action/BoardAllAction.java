package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.Board;
import model.BoardDao;

public class BoardAllAction {
	private BoardDao dao = new BoardDao();

	public ActionForward hello(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("hello", "hello, World");
		return new ActionForward(false, "hello.jsp");
	}

	// http://localhost:8080/jspStudy2/model2/board/list.bo
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit = 10;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int boardcount = dao.boardCount();// 총 개시물 건수
		List<Board> list = dao.list(pageNum, limit); //
		int maxpage = (int) ((double) boardcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = boardcount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("boardcount", boardcount);
		request.setAttribute("list", list);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		request.setAttribute("day", df.format(new Date()));
		return new ActionForward(false, "list.jsp");
	}

	public ActionForward write(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr");
			Board board = new Board();
			board.setName(multi.getParameter("name"));
			board.setPass(multi.getParameter("pass"));
			board.setTitle(multi.getParameter("title"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));
			int num = dao.maxNum();
			board.setNum(++num);
			board.setRef(num);
			if (dao.insert(board)) {
				request.setAttribute("msg", "게시물 등록 성공");
			} else {
				request.setAttribute("msg", "게시물 등록 실패");
			}
			request.setAttribute("url", "list.bo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward info(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board board = new BoardDao().selectOne(num);
		int result = new BoardDao().readcntadd(num);
		request.setAttribute("board", board);
		request.setAttribute("result", result);
		return new ActionForward(false, "info.jsp");
	}

	public ActionForward replyForm(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board board = new BoardDao().selectOne(num);
		request.setAttribute("board", board);
		return new ActionForward(false, null);
	}

	public ActionForward reply(HttpServletRequest request, HttpServletResponse response) {
		Board board = new Board();
		board.setNum(Integer.parseInt(request.getParameter("num")));
		board.setRef(Integer.parseInt(request.getParameter("ref")));
		board.setReflevel(Integer.parseInt(request.getParameter("reflevel")));
		board.setRefstep(Integer.parseInt(request.getParameter("refstep")));
		board.setName(request.getParameter("name"));
		board.setPass(request.getParameter("pass"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		if (new BoardDao().reply(board)) {
			request.setAttribute("msg", "답변 성공");
			request.setAttribute("url", "list.bo");
		} else {
			request.setAttribute("msg", "답변 실패");
			request.setAttribute("url", "replyForm.bo?num=" + board.getNum());
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr");
			Board board = new Board();
			board.setName(multi.getParameter("name"));
			board.setPass(multi.getParameter("pass"));
			board.setTitle(multi.getParameter("title"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));
			board.setNum(Integer.parseInt(multi.getParameter("num")));
			Board update = dao.selectOne(Integer.parseInt(multi.getParameter("num")));
			if(board.getFile1()==null || board.getFile1().equals("")) {
				board.setFile1(multi.getParameter("file2"));
			}
			if (!update.getPass().equals(board.getPass())) {
				request.setAttribute("msg", "비밀번호가 틀렸습니다.");
				request.setAttribute("url", "updateForm.bo?num=" + board.getNum());
			} else {
				if (dao.update(board)) {
					request.setAttribute("msg", "수정 성공");
					request.setAttribute("url", "list.bo");
				} else {
					request.setAttribute("msg", "수정 실패");
					request.setAttribute("url", "updateForm.bo?num=" + board.getNum());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}
	
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		Board board = dao.selectOne(num);
		if(!board.getPass().equals(pass)) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			request.setAttribute("url", "deleteform.bo?num="+num);
		}else {
			if(dao.delete(board)) {
				request.setAttribute("msg", "게시물 삭제 성공");
				request.setAttribute("url", "list.bo");
			}else {
				request.setAttribute("msg", "게시물 삭제 실패");
				request.setAttribute("url", "deleteform.bo?num="+num);
			}
		}
		return new ActionForward(false,"../alert.jsp");
	}
	
	public ActionForward searchlist(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit = 10;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		String search = null;
		String searchfor = request.getParameter("search");
		if(request.getParameter("sel").equals("1")){
			search = "title";
		}else{
			search = "name";
		}
		int searchboardcount = dao.boardCountsearch(search,searchfor); //등록된 게시물의 전체 건수. dao.boardCount()의 리턴값을 boardcount가 받게 됨.
	  	List<Board> list = dao.list2(pageNum,limit,search,searchfor);  //list : 현재 페이지에 보여지는 게시물 객체 저장.
		int maxpage = (int) ((double) searchboardcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		int boardnum = searchboardcount - ((pageNum - 1) * 10);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("searchboardcount", searchboardcount);
		request.setAttribute("list", list);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		request.setAttribute("day", df.format(new Date()));
		return new ActionForward(false, "searchList.jsp");
	}
}
