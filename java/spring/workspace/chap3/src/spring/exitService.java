package spring;

import java.util.Collection;
import java.util.Iterator;

public class exitService {
	private MemberDao dao;

	public exitService(MemberDao dao) {
		this.dao = dao;
	}

	public void exit() {
		Collection<Member> clt = dao.selectAll();
		Iterator<Member> i = clt.iterator();
		while (i.hasNext()) {
			Member m = i.next();
			System.out.println(m.getEmail() + "," + m.getName() + "," + m.getPassword());
		}
	}
}
