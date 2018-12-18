package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberMapper;

public class MemberDao {
	private static final String ns = "mapper.MemberMapper.";
	public Member selectOne(String id) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
			return session.selectOne(ns+"select",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int insert(Member mem) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MemberMapper.class).insert(mem);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Member> list() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectList(ns+"select");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int update(Member mem) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MemberMapper.class).update(mem);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public int delete(Member mem) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MemberMapper.class).delete(mem);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public int updatepass(String id, String pass) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("pass", pass);
//전달 받는 파라미터는 xml 파일에서 하나밖에 받을 수 없으므로 객체를 한 개 만들던지, map으로 두개의 값을 넣어줘야 한다.
			return session.getMapper(MemberMapper.class).updatepass(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
}
