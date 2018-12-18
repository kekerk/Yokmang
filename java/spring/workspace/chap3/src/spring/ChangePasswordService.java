package spring;

public class ChangePasswordService {
	private MemberDao dao;
	public ChangePasswordService(MemberDao dao) {
		this.dao = dao;
	}
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = dao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPw, newPw);
		dao.update(member);
	}
}
