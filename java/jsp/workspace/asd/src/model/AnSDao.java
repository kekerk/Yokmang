package model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.SqlSession;

import mapper.ActornSeriesMapper;
import mapper.MembersMapper;


public class AnSDao {
	private static final String ns = "mapper.ActornSeriesMapper.";
	public Actor selectact(int no) {
		SqlSession session = DBConnection.getSession(); 
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("no", no);
			return session.selectOne(ns+"selectactor",map);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null ;
	}
	public Series selectseries(int seriesno) {
		SqlSession session = DBConnection.getSession(); 
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("seriesno", seriesno);
			return session.selectOne(ns+"selectseries",map);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null ;
	}
	
	public List<Actor> listact(int pageNum, int limit) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum-1)*limit;
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("limit", limit);
			map.put("startrow", startrow);
			return session.selectList(ns+"selectactor",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public List<Actor> listact() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectList(ns+"selectactor");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public List<Series> listseries(int pageNum,int limit) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum-1)*limit;
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("limit", limit);
			map.put("startrow", startrow);
			return session.selectList(ns+"selectseries",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public List<Series> listseries() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectList(ns+"selectseries");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public int actorCount() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectOne(ns + "actorCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public int seriesCount() {
		SqlSession session = DBConnection.getSession();
		try {
			return session.selectOne(ns + "seriesCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Series> sort() {
		SqlSession session = DBConnection.getSession();
		try {

			return session.selectList(ns + "sort");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	
	public int seriescnt(int seriesno) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("seriesno", seriesno);
			return session.getMapper(ActornSeriesMapper.class).seriescnt(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	
}
