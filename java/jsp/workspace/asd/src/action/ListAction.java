package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;
import model.MembersDao;

public class ListAction extends AdminUserAction{

	@Override
	public ActionForward adminExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Members> list = new MembersDao().list();
		request.setAttribute("list", list);
			return new ActionForward(false,"list.jsp");
		}
	}

