package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao { // �����ϴ� ���� ��ü
	private static long nextId=0;
	private Map<String,Member> map = new HashMap<>();
	public Member selectByEmail(String email) {
		return map.get(email); //Member ��ü ����
	}
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	public Collection<Member> selectAll(){
		return map.values(); //��� Ű�� ������ select
	}
}
