package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class ListAction extends AdminUserAction{

	@Override
	public ActionForward adminExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg=null;
		String url=null;
		List<Member> list = new MemberDao().list();
		request.setAttribute("list", list);
			return new ActionForward(false,"list.jsp");
		}
	}

