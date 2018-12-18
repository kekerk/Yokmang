package action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.Allboard;
import model.AllboardDao;
import model.AnSDao;

import model.Comments;
import model.CommentsDao;
import model.Members;
import model.MembersDao;
import model.Series;

public class AllBoardAllAction {
	private AllboardDao bdao = new AllboardDao();
	private MembersDao mdao = new MembersDao();

	// http://localhost:8080/jspStudy2/model2/board/list.bo
	public ActionForward list(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit;
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		String dormi = (String) request.getParameter("dormi");
		String Scopedormi = (String) request.getSession().getAttribute("dormi");
		String login = (String) request.getSession().getAttribute("login");
		Members member = new MembersDao().selectOne(login);
		if ((boardtype == 1) || (boardtype == 2)) { // 사진 관련 게시판
			limit = 6;
		} else { // 3 : 기숙사별 게시판, 4: 자유게시판
			limit = 10;
		}
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		String column = request.getParameter("column");
		String find = request.getParameter("find");
		if (column == null || column.equals("")) {
			column = null;
		}
		if (find == null || find.equals("")) {
			find = null;
		}
		request.setAttribute("find", find);
		if (boardtype != 3) {
			int boardcount = bdao.boardCount(boardtype, column, find);// 총 개시물 건수
			List<Allboard> list = bdao.list(boardtype, column, find, pageNum, limit); //
			int maxpage = (int) ((double) boardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			int boardnum = 0;
			if ((boardtype == 1) || (boardtype == 2)) {
				boardnum = boardcount - ((pageNum - 1) * 6);
			} else {
				boardnum = boardcount - ((pageNum - 1) * 10);
			}
			request.setAttribute("boardtype", boardtype);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("boardnum", boardnum);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("boardcount", boardcount);
			request.setAttribute("dormi", dormi);
			request.setAttribute("list", list);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			request.setAttribute("day", df.format(new Date()));

			return new ActionForward(false, "list.jsp");

		} else {
			if (Scopedormi.equals("master")) {
				int boardcount = bdao.boardCount(boardtype, column, find, dormi);// 총 개시물 건수
				List<Allboard> list = bdao.list(boardtype, column, find, dormi, pageNum, limit); //
				int maxpage = (int) ((double) boardcount / limit + 0.95);
				int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
				int endpage = startpage + 9;
				if (endpage > maxpage)
					endpage = maxpage;
				int boardnum = boardcount - ((pageNum - 1) * 10);
				request.setAttribute("boardtype", boardtype);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("boardnum", boardnum);
				request.setAttribute("maxpage", maxpage);
				request.setAttribute("startpage", startpage);
				request.setAttribute("endpage", endpage);
				request.setAttribute("boardcount", boardcount);
				request.setAttribute("dormi", dormi);
				request.setAttribute("list", list);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				request.setAttribute("day", df.format(new Date()));
				return new ActionForward(false, "list.jsp");
			} else {
				if (member.getDormi().equals(dormi)) {
					int boardcount = bdao.boardCount(boardtype, column, find, dormi);// 총 개시물 건수
					List<Allboard> list = bdao.list(boardtype, column, find, dormi, pageNum, limit); //
					int maxpage = (int) ((double) boardcount / limit + 0.95);
					int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
					int endpage = startpage + 9;
					if (endpage > maxpage)
						endpage = maxpage;
					int boardnum = boardcount - ((pageNum - 1) * 10);
					request.setAttribute("boardtype", boardtype);
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
				} else {
					request.setAttribute("msg", "타 기숙사생은 접근할 수 없어!");
					request.setAttribute("url", "../members/homemain.jsp");
					return new ActionForward(false, "../alert.jsp");
				}
			}
		}
	}

	public ActionForward write(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/allboard/file/";
		String login = (String) request.getSession().getAttribute("login");
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr");
			if (boardtype == 1 || boardtype == 2) {
				boolean imgable = multi.getContentType("file1").contains("image");
				if (!imgable) {
					request.setAttribute("msg", "이미지 파일만 업로드 가능합니다");
					request.setAttribute("url", "writeForm.all?boardtype=" + boardtype);
					return new ActionForward(false, "../alert.jsp");
				}
				String filename = multi.getFilesystemName("file1");
				ParameterBlock pb = new ParameterBlock();
				pb.add(path + filename);
				RenderedOp rop = JAI.create("fileload", pb);
				BufferedImage bi = rop.getAsBufferedImage();
				int width = bi.getWidth() / 5;
				int height = bi.getHeight() / 5;
				BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = thumb.createGraphics();
				g.drawImage(bi, 0, 0, width, height, null);
				File f = new File(path + "sm_" + filename);
				ImageIO.write(thumb, "jpg", f);
				// request.setAttribute("filename", filename);
			}
			Allboard allboard = new Allboard();
			allboard.setId(multi.getParameter("id"));
			allboard.setNickname(multi.getParameter("nickname"));
			allboard.setDormi(multi.getParameter("dormi"));
			allboard.setPassword(multi.getParameter("password"));
			if (boardtype == 1) {
				allboard.setSeriesno(Integer.parseInt(multi.getParameter("seriesno")));
				Series series = new AnSDao().selectseries(Integer.parseInt(multi.getParameter("seriesno")));
				allboard.setSeriesname(series.getPosname());
				int seriescnt = new AnSDao().seriescnt(Integer.parseInt(multi.getParameter("seriesno")));
				series.setSeriescnt(seriescnt);
			}
			allboard.setTitle(multi.getParameter("title"));
			allboard.setContent(multi.getParameter("content"));
			allboard.setFile1(multi.getFilesystemName("file1"));
			allboard.setBoardtype(Integer.parseInt(multi.getParameter("boardtype")));
			int num = bdao.maxNum();
			allboard.setNo(++num);
			Members member = new MembersDao().selectOne(multi.getParameter("id"));
			if (bdao.insert(allboard)) {
				if (boardtype == 3) {
					if (new MembersDao().boardcnt(member.getId()) >= 1) { // grade*10 + 1 번째 게시물이 작성되었을 때 학년 업그레이드
						if (member.getBoardcnt() == member.getGrade() * 10) {
							new MembersDao().gradeup(member.getId());
							request.setAttribute("msg", "학년이 올라갔습니다. 재로그인하면 확인하실 수 있습니다.");
							request.setAttribute("url",
									"list.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype"))
											+ "&dormi=" + multi.getParameter("dormi"));
							return new ActionForward(false, "../alert.jsp");
						}
					}
					return new ActionForward(false,
							"list.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype")) + "&dormi="
									+ multi.getParameter("dormi"));

				} else {
					if (new MembersDao().boardcnt(member.getId()) >= 1) {
						if (member.getBoardcnt() == member.getGrade() * 10) {
							new MembersDao().gradeup(member.getId());
							request.setAttribute("msg", "학년이 올라갔습니다. 재로그인하면 확인하실 수 있습니다.");
							request.setAttribute("url",
									"list.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype"))
											+ "&dormi=" + multi.getParameter("dormi"));
							return new ActionForward(false, "../alert.jsp");
						}
					}
					return new ActionForward(false,
							"list.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype")));
				}
			} else {
				if (boardtype == 3) {
					return new ActionForward(false,
							"writeForm.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype")) + "&dormi="
									+ multi.getParameter("dormi"));
				} else {
					return new ActionForward(false,
							"writeForm.all?boardtype=" + Integer.parseInt(multi.getParameter("boardtype")));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward info(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		String login = (String) request.getSession().getAttribute("login");
		String dormi = request.getParameter("dormi");
		Allboard allboard = bdao.selectOne(boardtype, no);
		int result = bdao.readcntadd(allboard);
		/*
		 * reply list
		 */
		int pageNum = 1;
		int limit = 5;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		int boardcount = new CommentsDao().boardCount(no);
		List<Comments> commentslist = new CommentsDao().list(no, pageNum, limit);
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
		request.setAttribute("commentslist", commentslist);
		request.setAttribute("boardtype", boardtype);
		request.setAttribute("login", login);
		request.setAttribute("dormi", dormi);
		request.setAttribute("allboard", allboard);
		request.setAttribute("result", result);
		return new ActionForward(false, "info.jsp");
	}

	public ActionForward Form(HttpServletRequest request, HttpServletResponse response) {
		int no = 0;
		if (request.getRequestURI().contains("delete"))
			no = Integer.parseInt(request.getParameter("no"));
		else if (request.getRequestURI().contains("update"))
			no = Integer.parseInt(request.getParameter("no"));
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		String login = (String) request.getSession().getAttribute("login");
		Members member = mdao.selectOne(login);
		Allboard allboard = bdao.selectOne(boardtype, no);
		request.setAttribute("allboard", allboard);
		request.setAttribute("member", member);
		return new ActionForward(false, null);
	}

	public ActionForward update(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/allboard/file/";
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr");
			Allboard allboard = new Allboard();
			int no = Integer.parseInt(multi.getParameter("no"));
			int boardtype = Integer.parseInt(multi.getParameter("boardtype"));
			allboard.setNickname(multi.getParameter("nickname"));
			allboard.setPassword(multi.getParameter("password"));
			allboard.setTitle(multi.getParameter("title"));
			allboard.setContent(multi.getParameter("content"));
			allboard.setDormi(multi.getParameter("dormi"));
			allboard.setFile1(multi.getFilesystemName("file1"));
			allboard.setBoardtype(Integer.parseInt(multi.getParameter("boardtype")));
			allboard.setNo(no);
			Allboard update = bdao.selectOne(boardtype, no);
			if (allboard.getFile1() == null || allboard.getFile1().equals("")) {
				allboard.setFile1(multi.getParameter("file2"));
			}
			if (boardtype != 3) {
				if (!update.getPassword().equals(allboard.getPassword())) {
					request.setAttribute("msg", "비밀번호가 틀렸습니다.");
					request.setAttribute("url", "updateForm.all?no=" + allboard.getNo() + "&boardtype=" + boardtype);
				} else {
					if (bdao.update(allboard)) {
						request.setAttribute("msg", "수정 성공");
						request.setAttribute("url", "list.all?boardtype=" + boardtype);
					} else {
						request.setAttribute("msg", "수정 실패");
						request.setAttribute("url",
								"updateForm.all?no=" + allboard.getNo() + "&boardtype=" + boardtype);
					}
				}
			} else {
				if (!update.getPassword().equals(allboard.getPassword())) {
					request.setAttribute("msg", "비밀번호가 틀렸습니다.");
					request.setAttribute("url", "updateForm.all?no=" + allboard.getNo() + "&boardtype=" + boardtype
							+ "&dormi=" + multi.getParameter("dormi"));
				} else {
					if (bdao.update(allboard)) {
						request.setAttribute("msg", "수정 성공");
						request.setAttribute("url",
								"list.all?boardtype=" + boardtype + "&dormi=" + multi.getParameter("dormi"));
					} else {
						request.setAttribute("msg", "수정 실패");
						request.setAttribute("url", "updateForm.all?no=" + allboard.getNo() + "&boardtype=" + boardtype
								+ "&dormi=" + multi.getParameter("dormi"));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		String dormi = (request.getParameter("dormi"));
		String pass = request.getParameter("password");
		Allboard allboard = bdao.selectOne(boardtype, no);
		List<Comments> list = new CommentsDao().selectforDeleteall(no);
		System.out.println(list);
		if (boardtype != 3) {
			if (!allboard.getPassword().equals(pass)) {
				request.setAttribute("msg", "비밀번호가 틀렸습니다.");
				request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
			} else {
				if (list.isEmpty()) {
					if (bdao.delete(allboard)) {

						request.setAttribute("msg", "게시물 삭제 성공");
						request.setAttribute("url", "list.all?boardtype=" + boardtype);

					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
					}
				} else {
					if (new CommentsDao().deleteAll(list)) {
						if (bdao.delete(allboard)) {
							request.setAttribute("msg", "게시물 삭제 성공");
							request.setAttribute("url", "list.all?boardtype=" + boardtype);
						} else {
							request.setAttribute("msg", "게시물 삭제 실패");
							request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
						}
					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
					}
				}
			}
		} else {
			if (!allboard.getPassword().equals(pass)) {
				request.setAttribute("msg", "비밀번호가 틀렸습니다.");
				request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
			} else {
				if (list.isEmpty()) {
					if (bdao.delete(allboard)) {
						request.setAttribute("msg", "게시물 삭제 성공");
						request.setAttribute("url", "list.all?boardtype=" + boardtype + "&dormi=" + dormi);
					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url",
								"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
					}
				} else {
					if (new CommentsDao().deleteAll(list)) {
						if (bdao.delete(allboard)) {
							request.setAttribute("msg", "게시물 삭제 성공");
							request.setAttribute("url", "list.all?boardtype=" + boardtype + "&dormi=" + dormi);
						} else {
							request.setAttribute("msg", "게시물 삭제 실패");
							request.setAttribute("url",
									"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
						}
					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url",
								"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
					}
				}
			}
		}

		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward deleteadmin(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		List<Comments> list = new CommentsDao().selectforDeleteall(no);
		String dormi = request.getParameter("dormi");
		Allboard allboard = bdao.selectOne(boardtype, no);
		if (boardtype != 3) {
			if (list.isEmpty()) {
				if (bdao.delete(allboard)) {
					request.setAttribute("msg", "게시물 삭제 성공");
					request.setAttribute("url", "list.all?boardtype=" + boardtype);
				} else {
					request.setAttribute("msg", "게시물 삭제 실패");
					request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
				}
			} else {
				if (new CommentsDao().deleteAll(list)) {
					if (bdao.delete(allboard)) {
						request.setAttribute("msg", "게시물 삭제 성공");
						request.setAttribute("url", "list.all?boardtype=" + boardtype);
					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
					}
				} else {
					request.setAttribute("msg", "게시물 삭제 실패");
					request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
				}
			}
		} else {
			if (list.isEmpty()) {
				if (bdao.delete(allboard)) {
					request.setAttribute("msg", "게시물 삭제 성공");
					request.setAttribute("url", "list.all?boardtype=" + boardtype + "&dormi=" + dormi);
				} else {
					request.setAttribute("msg", "게시물 삭제 실패");
					request.setAttribute("url",
							"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
				}
			} else {
				if (new CommentsDao().deleteAll(list)) {
					if (bdao.delete(allboard)) {
						request.setAttribute("msg", "게시물 삭제 성공");
						request.setAttribute("url", "list.all?boardtype=" + boardtype + "&dormi=" + dormi);
					} else {
						request.setAttribute("msg", "게시물 삭제 실패");
						request.setAttribute("url",
								"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
					}
				} else {
					request.setAttribute("msg", "게시물 삭제 실패");
					request.setAttribute("url",
							"deleteform.all?no=" + no + "&boardtype=" + boardtype + "&dormi=" + dormi);
				}
			}
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward searchlist(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit;
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		String dormi = (String) request.getParameter("dormi");
		String login = (String) request.getSession().getAttribute("login");
		Members member = new MembersDao().selectOne(login);
		if ((boardtype == 1) || (boardtype == 2)) { // 사진 관련 게시판
			limit = 6;
		} else { // 3 : 기숙사별 게시판, 4: 자유게시판
			limit = 10;
		}
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (NumberFormatException e) {
		}
		String search = null;
		String searchfor = request.getParameter("search");
		if (request.getParameter("sel").equals("1")) {
			search = "title";
		} else {
			search = "nickname";
		}
		if (boardtype != 3) {
			int searchboardcount = bdao.boardCountsearch(boardtype, search, searchfor);
			List<Allboard> list = bdao.list2(boardtype, pageNum, limit, search, searchfor);
			int maxpage = (int) ((double) searchboardcount / limit + 0.95);
			int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
			int endpage = startpage + 9;
			if (endpage > maxpage)
				endpage = maxpage;
			int boardnum = 0;
			if ((boardtype == 1) || (boardtype == 2)) {
				boardnum = searchboardcount - ((pageNum - 1) * 6);
			} else if ((boardtype == 4)) { // 4: 자유게시판
				boardnum = searchboardcount - ((pageNum - 1) * 10);
			} else if (boardtype == 5) {
				boardnum = searchboardcount - ((pageNum - 1) * 5);
			}
			request.setAttribute("boardtype", boardtype);
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
		} else {
			if (member.getDormi().equals(dormi)) {
				int boardcount = bdao.boardCountsearch(boardtype, dormi, search, searchfor);// 총 개시물 건수
				List<Allboard> list = bdao.list2(boardtype, dormi, pageNum, limit, search, searchfor); //
				int maxpage = (int) ((double) boardcount / limit + 0.95);
				int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;
				int endpage = startpage + 9;
				if (endpage > maxpage)
					endpage = maxpage;
				int boardnum = boardcount - ((pageNum - 1) * 10);
				request.setAttribute("boardtype", boardtype);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("boardnum", boardnum);
				request.setAttribute("maxpage", maxpage);
				request.setAttribute("startpage", startpage);
				request.setAttribute("endpage", endpage);
				request.setAttribute("boardcount", boardcount);
				request.setAttribute("list", list);
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				request.setAttribute("day", df.format(new Date()));
				return new ActionForward(false, "searchList.jsp");
			} else {
				request.setAttribute("msg", "타 기숙사생은 접근할 수 없어!");
				request.setAttribute("url", "../members/homemain.jsp");
				return new ActionForward(false, "../alert.jsp");
			}
		}
	}

	public ActionForward reply(HttpServletRequest request, HttpServletResponse response) {
		String login = (String) request.getSession().getAttribute("login");
		Members member = new MembersDao().selectOne(login);
		Comments comments = new Comments();
		comments.setNo(Integer.parseInt(request.getParameter("no")));
		int refno = new CommentsDao().maxreplyNo();
		comments.setRef_no(++refno);
		comments.setBoardtype(Integer.parseInt(request.getParameter("boardtype")));
		comments.setId(member.getId());
		comments.setNickname(member.getNickname());
		comments.setGrade(member.getGrade());
		comments.setDormi(member.getDormi());
		comments.setContent(request.getParameter("content"));
		if (new CommentsDao().reply(comments)) {
			request.setAttribute("comments", comments);
			return new ActionForward(false, "info.all?no=" + Integer.parseInt(request.getParameter("no"))
					+ "&boardtype=" + Integer.parseInt(request.getParameter("boardtype")));
		} else {

			return new ActionForward(true, "info.all?no=" + Integer.parseInt(request.getParameter("no")) + "&boardtype="
					+ Integer.parseInt(request.getParameter("boardtype")));
		}
	}
	public ActionForward commentdelete(HttpServletRequest request, HttpServletResponse response) {
		int ref_no = Integer.parseInt(request.getParameter("ref_no"));
		int no = Integer.parseInt(request.getParameter("no"));
		int boardtype = Integer.parseInt(request.getParameter("boardtype"));
		Comments comments = new CommentsDao().selectOne(ref_no);
		if (new CommentsDao().delete(comments)) {
			request.setAttribute("msg", "댓글 삭제 성공");
			request.setAttribute("url", "info.all?no=" + no + "&boardtype=" + boardtype);
		} else {
			request.setAttribute("msg", "댓글 삭제 실패");
			request.setAttribute("url", "deleteform.all?no=" + no + "&boardtype=" + boardtype);
		}
		return new ActionForward(false, "../alert.jsp");
	}

}
