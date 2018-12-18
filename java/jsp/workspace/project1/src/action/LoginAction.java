package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;
/*
 * 1. id, pass �Ķ���� ����
 * 2. id�� db���� ȸ������ ��ȸ. ������ �ش� ���̵� ����. alert -> loginform.jsp
 * 3. ���̵� ������ pass ����
 * 		��й�ȣ ��ġ : id ���� �α��� �ϼ̽��ϴ�.  -> main.me
 * 		��й�ȣ ����ġ : ��й�ȣ�� Ʋ���ϴ�.       -> loginform.jsp
 */
public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = "�ش� ���̵� ����";
		String url = "loginform.jsp";
		if(mem != null) { // ȸ���� �����ϴ� ���
			if(pass.equals(mem.getPass())) {
				msg=id+"���� �α��� �ϼ̽��ϴ�.";
				url ="main.me";
				request.getSession().setAttribute("login", id);  //request.getSession().setAttribute("login", id) : id ������ ���ǿ� "login" ����. 
				request.getSession().setAttribute("name", mem.getName());  //request.getSession().setAttribute("login", id) : id ������ ���ǿ� "login" ����. 
				System.out.println(id);
				System.out.println(mem.getName());
			}else {
				msg="��й�ȣ ����";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp"); //model2 �������� member�� board ����
	}
}
