package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.AllBoardMapper;
import mapper.CommentsMapper;

public class CommentsDao {
	private static final String ns = "mapper.CommentsMapper.";
	public int maxreplyNo() { 
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(CommentsMapper.class).maxreplyNo(); 
		} catch (Exception e) {
			DBConnection.close(session);
		}
		return 0;
	}
	public boolean reply(Comments comments) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(CommentsMapper.class).insert(comments);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
	
	public int boardCount(int no) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("no", no);
			return session.selectOne(ns + "commentsCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public List<Comments> list(int no, int pageNum, int limit) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("no", no);
			map.put("limit", limit);
			map.put("startrow", startrow);
			return session.selectList(ns + "select", map); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public Comments selectOne(int ref_no) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("ref_no", ref_no);
			return session.selectOne(ns + "select", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public List<Comments> selectforDeleteall(int no) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("no", no);
			return session.selectList(ns + "select", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	public boolean delete(Comments comments) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(CommentsMapper.class).delete(comments);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
		public boolean deleteAll(List<Comments> list) {
			SqlSession session = DBConnection.getSession();
			try {
				for(Comments C : list) {
					int result = session.getMapper(CommentsMapper.class).deleteall(C);
					if (result > 0)
						return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(session);
			}
			return false;

	}
}
