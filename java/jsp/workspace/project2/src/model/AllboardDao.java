package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.AllBoardMapper;

public class AllboardDao {
	private static final String ns = "mapper.AllBoardMapper.";

	public int maxNum() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(AllBoardMapper.class).maxNum(); 
		} catch (Exception e) {
			DBConnection.close(session);
		}
		return 0;
	}

	public boolean insert(Allboard allboard) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(AllBoardMapper.class).insert(allboard);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
	

	public int boardCount(int boardtype,String column, String find) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("boardtype", boardtype);
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
	
	public int boardCount(int boardtype,String column, String find,String dormi) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("boardtype", boardtype);
			map.put("dormi", dormi);
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

	public List<Allboard> list(int boardtype,String column,String find,int pageNum, int limit) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardtype", boardtype);
			map.put("column", column);
			map.put("find", find);
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
	public List<Allboard> list(int boardtype,String column,String find,String dormi,int pageNum, int limit) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardtype", boardtype);
			map.put("dormi", dormi);
			map.put("column", column);
			map.put("find", find);
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

	public Allboard selectOne(int boardtype,int no) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("boardtype", boardtype);
			map.put("no", no);
			return session.selectOne(ns + "select", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int readcntadd(Allboard allboard) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allboard", allboard);
			return session.getMapper(AllBoardMapper.class).readcntadd(allboard); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;

	}

	public boolean update(Allboard allboard) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(AllBoardMapper.class).update(allboard);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}

	public boolean delete(Allboard allboard) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(AllBoardMapper.class).delete(allboard);
			if (result > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;

	}
	
	public List<Allboard> list2(int boardtype,int pageNum, int limit, String search, String searchfor) {
		SqlSession session = DBConnection.getSession();
		List<Allboard> list = null;
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("boardtype", boardtype);
			map.put("limit", limit);
			map.put("startrow", startrow);
			map.put("search", search);
			map.put("searchfor", searchfor);
			return session.selectList(ns + "select", map); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int boardCountsearch(int boardtype,String search, String searchfor) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardtype", boardtype);
			map.put("search", search);
			map.put("searchfor", searchfor);
			return session.selectOne(ns + "boardCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public List<Allboard> list2(int boardtype,String dormi,int pageNum, int limit, String search, String searchfor) {
		SqlSession session = DBConnection.getSession();
		List<Allboard> list = null;
		try {
			int startrow = (pageNum - 1) * limit;
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("boardtype", boardtype);
			map.put("dormi", dormi);
			map.put("limit", limit);
			map.put("startrow", startrow);
			map.put("search", search);
			map.put("searchfor", searchfor);
			return session.selectList(ns + "select", map); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int boardCountsearch(int boardtype,String dormi,String search, String searchfor) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("boardtype", boardtype);
			map.put("dormi", dormi);
			map.put("search", search);
			map.put("searchfor", searchfor);
			return session.selectOne(ns + "boardCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}	
}
