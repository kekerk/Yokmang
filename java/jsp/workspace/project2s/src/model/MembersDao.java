package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MembersMapper;

/*---------------------------------------------------------------------- */
public class MembersDao {
	private static final String ns = "mapper.MembersMapper.";

	public int insert(Members mem) { // mapper.interface 颇老 立辟
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MembersMapper.class).insert(mem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBConnection.close(session);
		}
		return 0;
	}

	/*---------------------------------------------------------------------- */
	public Members selectOne(String id) { // mapper.xml 颇老 立辟
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			return session.selectOne(ns + "select", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	/*---------------------------------------------------------------------- */
	public List<Members> list() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectList(ns + "select");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	/*---------------------------------------------------------------------- */
	public int update(Members mem) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MembersMapper.class).update(mem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	/*---------------------------------------------------------------------- */
	public int delete(Members mem) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(MembersMapper.class).delete(mem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;

	}

	/*---------------------------------------------------------------------- */
	public int updatepass(String id, String password) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("password", password);
			return session.getMapper(MembersMapper.class).updatepass(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	/*---------------------------------------------------------------------- */
	public int boardcnt(String id) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			return session.getMapper(MembersMapper.class).boardcnt(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
		/*---------------------------------------------------------------------- */
	}

	public int gradeup(String id) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			return session.getMapper(MembersMapper.class).gradeup(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
}
