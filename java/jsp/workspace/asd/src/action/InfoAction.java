package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;
import model.MembersDao;

public class InfoAction extends UserLoginAction { //InfoAction이 먼저 호출되는게 아니라 UserLoginAction이 먼저 호출되어 실행된다.
	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Members mem = new MembersDao().selectOne(id);
		request.setAttribute("mem", mem);
		return new ActionForward(false,null);
	}
}
