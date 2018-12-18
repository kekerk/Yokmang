package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberMapper;
/*---------------------------------------------------------------------- */	
public class MemberDao {
	private static final String ns = "mapper.MemberMapper.";
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
	/*---------------------------------------------------------------------- */		
	public Member selectOne(String id) {
		SqlSession session = DBConnection.getSession(); 
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
			return session.selectOne(ns+"select",map);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null ;
	}
	/*---------------------------------------------------------------------- */	
	public Member selectOnepass(String pass) {
		SqlSession session = DBConnection.getSession(); 
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("pass", pass);
			//executeQuery : DBMS의 데이터 정보를 조회하기.
			return session.selectOne(ns+"select",map);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null ;
	}
	/*---------------------------------------------------------------------- */		
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
	/*---------------------------------------------------------------------- */		
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
/*---------------------------------------------------------------------- */
	public int delete(Member mem) {
		SqlSession session = DBConnection.getSession(); 
		String sql= "delete from member where id=? ";
			try {
		return session.getMapper(MemberMapper.class).delete(mem); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;

	}
	/*---------------------------------------------------------------------- */	
	public int updatepass(String id, String pass) {
		SqlSession session = DBConnection.getSession();
		String sql = "update member "
				+ " set pass=? where id=?";
		try {
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("pass", pass);
			return session.getMapper(MemberMapper.class).updatepass(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
}
