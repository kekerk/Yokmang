package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.Board;
import model.BoardDao;
import model.Rec;
import model.Reply;

public class BoardAllAction {
	private BoardDao dao = new BoardDao();

	public ActionForward hello(HttpServletRequest request, HttpServletResponse respone) {
		request.setAttribute("hello", "Hello World");
		return new ActionForward(false, "hello.jsp");
	}

	// http://localhost:8080/jspStudy2/model2/board/list.bo 호출 시 list 메서드 호출
	public ActionForward list(HttpServletRequest request, HttpServletResponse respone) {
		int pageNum = 1;
		int limit = 6;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		// 검색 정보
		String column = request.getParameter("column");
		String find = request.getParameter("find");
		int code = Integer.parseInt(request.getParameter("code"));
		if (column == null || column.equals("")) {
			column = null;
		}
		if (find == null || find.equals("")) {
			find = null;
		}
		request.setAttribute("code", code);
		request.setAttribute("find", find);
		int boardcount = dao.boardCount(column, find, code);
		List<Board> list = dao.list(pageNum, limit, column, find, code);
		int maxpage = (int) ((double) boardcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
		int endpage = startpage + 9;
		if (endpage > maxpage)
			endpage = maxpage;
		// 글의 개수만큼 처리하기 위함.
		int boardnum = (boardcount - ((pageNum - 1) * limit));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("boardcount", boardcount);
		request.setAttribute("list", list);
		request.setAttribute("boardnum", boardnum);
		return new ActionForward(false, "list.jsp");
	}

	public ActionForward rlist(HttpServletRequest request, HttpServletResponse response) {
		int rpage = 1;
		int rlimit = 5;
		try {
			int rnum = Integer.parseInt(request.getParameter("rnum"));
			List<Reply> rlist = dao.rlist(rpage, rlimit, rnum);
			request.setAttribute("rlist", rlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "info.jsp#a");
	}

	public ActionForward reply(HttpServletRequest request, HttpServletResponse response) {
		double rating = Double.parseDouble(request.getParameter("rating"));
		String rcontent = request.getParameter("rcontent");
		String rname = request.getParameter("rname");
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			Board bd = dao.selectOne(num);
			Reply r = new Reply();
			bd.setRating(rating);
			r.setNum(num);
			r.setRating(rating);
			r.setRcontent(rcontent);
			r.setRname(rname);
			int rnum = dao.rpnum();
			r.setRnum(++rnum);
			if(dao.reply(r)) {
				request.setAttribute("msg", "등록 성공");
			}else {
				request.setAttribute("msg", "등록 실패");
			}
			
			request.setAttribute("url", "info.bo?num=" + r.getNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward write(HttpServletRequest request, HttpServletResponse respone) {
		String path = request.getServletContext().getRealPath("/") + "main/board/img/";
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, size, "euc-kr");
			Board board = new Board();
			board.setName(multi.getParameter("name"));
			board.setPass(multi.getParameter("pass"));
			board.setTitle(multi.getParameter("title"));
			board.setContent(multi.getParameter("content"));
			board.setFile1(multi.getFilesystemName("file1"));
			board.setCode(Integer.parseInt(multi.getParameter("code")));
			BoardDao dao = new BoardDao();
			int num = dao.maxNum();
			board.setNum(++num);
			if (dao.insert(board)) {
				request.setAttribute("msg", "게시물 등록 성공");
			} else {
				request.setAttribute("msg", "게시물 등록 실패");
			}
			request.setAttribute("board", board);
			request.setAttribute("url", "list.bo?code=" + board.getCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward info(HttpServletRequest request, HttpServletResponse respone) {
		int num = Integer.parseInt(request.getParameter("num"));
		int rpage = 1;
		int rlimit = 5;
		BoardDao dao = new BoardDao();
		int readcnt = dao.readcntadd(num);
		Board b = dao.selectOne(num);
		List<Reply> rlist = dao.rlist(rpage, rlimit, num);
		request.setAttribute("b", b);
		request.setAttribute("rlist", rlist);
		request.setAttribute("readcnt", readcnt);
		return new ActionForward(false, "info.jsp");
	}
	
	public ActionForward updateForm(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = dao.selectOne(num);
		request.setAttribute("b", b);
		return new ActionForward();
	}
	
	public ActionForward update(HttpServletRequest request, HttpServletResponse respone) {
		Board bd = new Board();
		int size = 10 * 1024 * 1024;
		String path = request.getServletContext().getRealPath("/") + "main/board/img/";
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "euc-kr");
			bd.setNum(Integer.parseInt(multi.getParameter("num")));
			bd.setName(multi.getParameter("name"));
			bd.setPass(multi.getParameter("pass"));
			bd.setTitle(multi.getParameter("title"));
			bd.setContent(multi.getParameter("content"));
			bd.setFile1(multi.getFilesystemName("file1"));
			if (multi.getFilesystemName("file1") == null) {
				bd.setFile1(multi.getParameter("file2"));
			} else {
				bd.setFile1(multi.getFilesystemName("file1"));
			}
			int num = Integer.parseInt(multi.getParameter("num"));
			Board bd2 = dao.selectOne(num);
			if (!bd2.getPass().equals(bd.getPass())) {
				request.setAttribute("msg", "암호 오류");
				request.setAttribute("url", "updateForm.bo?num=" + bd.getNum());
			} else {
				if (dao.update(bd)) {
					request.setAttribute("msg", "수정 성공");
					request.setAttribute("url", "info.bo?num=" + bd.getNum());
				} else {
					request.setAttribute("msg", "수정 실패");
					request.setAttribute("url", "updateForm.bo?num=" + bd.getNum());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward rdelete(HttpServletRequest request, HttpServletResponse respone) {
		String rname = (String)request.getSession().getAttribute("login"); 
	    String msg = null;
		String url = null;
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		Reply name = dao.selectRp(rnum);
		try {
			if (!rname.equals(name.getRname())) {
				msg = "본인만 삭제 가능합니다.";
				url = "info.bo?num=" + name.getNum();
			} else {
				if (dao.rdelete(name) > 0) {
					msg = "삭제 성공";
					url = "info.bo?num=" + name.getNum();
				} else {
					msg = "삭제 실패, 다시 시도해주세요";
					url = "info.bo?num=" + name.getNum();
				}
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward delete(HttpServletRequest request, HttpServletResponse respone) {
		String msg = null;
		String url = null;
		int num = Integer.parseInt(request.getParameter("num"));
		Board bd = dao.selectOne(num);
		try {
			String admin = (String)request.getSession().getAttribute("login");
			if(admin.equals("admin")) {
				if(dao.delete(bd)>0) {
				  if(dao.del(bd)==0) {
					msg = "삭제 성공";
					url = "list.bo?code="+bd.getCode();
				  }else {
				    msg = "삭제 성공";
					url = "list.bo?code="+bd.getCode();  
				  }
				}else {
					msg = "삭제 실패";
					url = "info.bo?num="+bd.getNum();
				}
			}

			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}
	public ActionForward rank(HttpServletRequest request, HttpServletResponse respone) {
		try {
			Rec rmd = new Rec();
			List<Rec> list = dao.rank(rmd);
			request.setAttribute("list",list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ActionForward(false,"recommend.jsp");
	}
}
