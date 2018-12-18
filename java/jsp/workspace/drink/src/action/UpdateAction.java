package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class UpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(request.getParameter("id")); // db�� ����� ������ ������ Member ��ü.
		Member update = new Member(); // �Ķ���� ������ ������ Member ��ü.
		update.setId(request.getParameter("id"));
		update.setPass(request.getParameter("pass"));
		update.setName(request.getParameter("name"));
		update.setAddr(request.getParameter("addr"));
		update.setTel(request.getParameter("tel"));
		update.setBirthday(request.getParameter("birthday"));
		update.setMax(Integer.parseInt(request.getParameter("max")));
		update.setPicture(request.getParameter("picture"));
		String msg = null;
		String url = null;
		if(!mem.getPass().equals(update.getPass())) {
			msg="��й�ȣ�� Ȯ���ϼ���";
			url="updateForm.me"+mem.getId();
		}else {
			int result = dao.update(update);
			if(result>0) {
				msg = "�����Ϸ�";
				url="info.me?id="+mem.getId();
			}else {
				msg="��������";
				url="updateForm.me?id="+mem.getId();
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
