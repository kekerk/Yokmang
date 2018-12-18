package model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.BoardMapper;

public class BoardDao {
	private static final String ns = "mapper.BoardMapper.";

	public int maxNum() { // board ���̺��� ����� num �÷��� �ִ밪 ����
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).maxNum();
		} catch (Exception e) {
			DBConnection.close(session);
		}
		return 0;
	}

	public boolean insert(Board board) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(BoardMapper.class).insert(board);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}

	public int boardCount(String column, String find) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("column", column);
			map.put("find", find);
			return session.selectOne(ns + "boardCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	public List<Board> list(int pageNum, int limit, String column, String find) {
		SqlSession session = DBConnection.getSession();
		// limit ?,? : �����ε���(0����) ���� ����
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("column", column);
			map.put("find", find);
			map.put("limit", limit);
			map.put("startrow", startrow);
			return session.selectList(ns + "select", map); // db���� ��ȸ�� �Խù� ��ü�� ����.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public Board selectOne(int num) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("num", num);
			return session.selectOne(ns + "select", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int readcntadd(int num) {
		SqlSession session = DBConnection.getSession();
		String sql = "update  board set ";
		sql += " readcnt=readcnt+1 where num=?";
		try {
			return session.getMapper(BoardMapper.class).readcntadd(num); // int executeUpdate() : ����(�߰�,����,����) �� ���ڵ��� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;

	}

	public boolean update(Board board) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(BoardMapper.class).update(board);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}

	public boolean delete(Board board) {
		SqlSession session = DBConnection.getSession();
		//String sql = "delete from board where num=? ";
		try {
			int result = session.getMapper(BoardMapper.class).delete(board);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;

	}
	/*
	 * reply �޼��� board : ���ۿ� ���� ���� : num,ref,reflevel,refstep ��ۿ� ���� ���� :
	 * name,pass,title,content
	 */
	public boolean reply(Board board) {
		SqlSession session = DBConnection.getSession();
		int num = this.maxNum(); // �ִ� num �� ����
		int ref = board.getRef(); // ������ ref��
		int reflevel = board.getReflevel(); // ������ reflevel��
		int refstep = board.getRefstep(); // ������ refstep��
		/*
		 * ����� ��ȸ ���� : ref desc, refstep asc num ref reflevel refstep 3 3 0 0 =>���� 2 2 0
		 * 0 =>���� 6 2 1 1 =>2���� ��� 5 2 1 2 =>2���� ��� 7 2 2 3 => 2���� ��� 5�� ���� ��� 4 2 1 4
		 * =>2���� ��� 1 1 0 0 =>����
		 * 
		 * 
		 */
		try {
			Map map = new HashMap();
			map.put("ref", ref);
			map.put("refstep", refstep);
			session.getMapper(BoardMapper.class).refstepadd(map);
			board.setRef(ref);
			board.setReflevel(++reflevel);
			board.setRefstep(++refstep); // 1
			board.setNum(++num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return this.insert(board);
	}

	public List<Board> list2(int pageNum, int limit, String search, String searchword) {
		SqlSession session = DBConnection.getSession();
		List<Board> list = null;
		// limit ?,? : �����ε���(0����) ���� ����
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("limit", limit);
			map.put("startrow", startrow);
			map.put("search", search);
			map.put("searchword", searchword);
			return session.selectList(ns + "select", map); // db���� ��ȸ�� �Խù� ��ü�� ����.
			// limit ?,? : �����ε���(0����) ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int boardCountsearch(String search, String searchword) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("search", search);
			map.put("searchword", searchword);
			return session.selectOne(ns + "boardCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
}
