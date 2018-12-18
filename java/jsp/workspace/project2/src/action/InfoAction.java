package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;
import model.MembersDao;

public class InfoAction extends UserLoginAction { //InfoAction�� ���� ȣ��Ǵ°� �ƴ϶� UserLoginAction�� ���� ȣ��Ǿ� ����ȴ�.
	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Members mem = new MembersDao().selectOne(id);
		request.setAttribute("mem", mem);
		return new ActionForward(false,null);
	}
}
