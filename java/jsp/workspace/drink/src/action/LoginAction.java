package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id= request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = "�ش� ���̵� ����";
		String url = "loginForm.jsp";
		if(mem!=null) {//ȸ���� �����ϴ� ���
			if(pass.equals(mem.getPass())) {
				msg= id+"�α��� ��";
				url="main.me";
				request.getSession().setAttribute("login", id); //request.getSession().setAttribute("login", id) : login ������ ���ǿ� ����
			}else {
				msg="��й�ȣ ����";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.getSession().setAttribute("name", mem.getName());
		return new ActionForward(false,"../alert.jsp"); //model2 �������� member�� board ����
	}

}
