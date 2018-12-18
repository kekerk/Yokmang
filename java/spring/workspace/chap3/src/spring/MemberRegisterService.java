package spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao dao;
	public MemberRegisterService(MemberDao dao) {
		this.dao = dao;
	}
	// req : 입력한 값을 저장하고 있는 객체
	public void regist(RegisterRequest req) {
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) { // 이미 등록된 이메일일 경우
			throw new AlreadyExistingMemberException("email 중복" + req.getEmail()); //main에 예외를 던짐.(메서드를 호출한 곳에 넘김)
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
