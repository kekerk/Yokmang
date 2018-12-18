package spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao dao;
	public MemberRegisterService(MemberDao dao) {
		this.dao = dao;
	}
	// req : �Է��� ���� �����ϰ� �ִ� ��ü
	public void regist(RegisterRequest req) {
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) { // �̹� ��ϵ� �̸����� ���
			throw new AlreadyExistingMemberException("email �ߺ�" + req.getEmail()); //main�� ���ܸ� ����.(�޼��带 ȣ���� ���� �ѱ�)
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
