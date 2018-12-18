package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Members;
import model.MembersDao;



public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Members mem = new MembersDao().selectOne(request.getParameter("id"));
		Members updatemem= new Members();
		updatemem.setId(request.getParameter("id"));
		updatemem.setNickname(request.getParameter("nickname"));
		updatemem.setPassword(request.getParameter("password"));
		updatemem.setTel(request.getParameter("tel"));
		updatemem.setEmail(request.getParameter("email"));
		String msg=null;
		String url=null;
		if(!updatemem.getPassword().equals(mem.getPassword())) {
			msg="��й�ȣ�� �ٸ��ϴ�.";
			url="updateform.me?id="+updatemem.getId();
		}else {
			int result = new MembersDao().update(updatemem);
			if(result > 0) {
				request.setAttribute("mem", updatemem);
				msg=mem.getId()+"���� ������ �����Ǿ����ϴ�.";
				url="main.me";
			}else {
				msg="���� ����";
				url="updateform.me?id="+updatemem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
