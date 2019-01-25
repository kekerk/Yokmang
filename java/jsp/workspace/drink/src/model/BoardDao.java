package model;

import java.util.ArrayList;
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
			return session.getMapper(BoardMapper.class).maxNum(); // �ε��� ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public int rpnum() { 
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).rpnum(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	public boolean insert(Board board) {
		SqlSession session = DBConnection.getSession();
		try {
			int result= session.getMapper(BoardMapper.class).insert(board);
			if(result>0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
	public List<Board> list(int pageNum, int limit,String column, String find,int code) {
		SqlSession session = DBConnection.getSession();
		try {
			int startrow = (pageNum-1) *limit;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("startrow", startrow);
			map.put("limit", limit);
			map.put("column", column);
			map.put("find", find);
			map.put("code", code);
			return session.selectList(ns+"select",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public List<Reply> rlist(int rpage,int rlimit,int num){
		SqlSession session = DBConnection.getSession();
		try {
			int rstartrow = (rpage-1) *rlimit;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("num", num);
			map.put("rstartrow", rstartrow);
			map.put("rlimit", rlimit);
			return session.selectList(ns+"rlist",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int boardCount(String column, String find,int code) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("column", column);
			map.put("find", find);
			map.put("code", code);
			return session.selectOne(ns+"boardCount",map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public boolean reply(Reply reply) {
		SqlSession session = DBConnection.getSession();
		try {
			int result= session.getMapper(BoardMapper.class).reply(reply);
			if(result>0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
	public Board selectOne(int num) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("num", num);
			return session.selectOne(ns+"select",map);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int readcntadd(int num) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).readcntadd(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public boolean update(Board bd) {
		SqlSession session = DBConnection.getSession();
		try {
			int result = session.getMapper(BoardMapper.class).update(bd);
			if(result>0)return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return false;
}
	
	/*
	 * bd : ������ ���� : num, ref, reflevel, refstep
	 *      ����� ���� : name, pass, title, content
	 * 
	 */
	
	public int delete(Board bd) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).delete(bd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int del(Board bd) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).del(bd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int rdelete(Reply rp) {
		SqlSession session = DBConnection.getSession();
		try {
			return session.getMapper(BoardMapper.class).rdelete(rp);
		}finally {
			DBConnection.close(session);
		}
	}

	public Reply selectRp(int rnum) {
		SqlSession session = DBConnection.getSession();
		try {
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("rnum", rnum);
			return session.selectOne(ns+"rselect",map);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public List<Rec> rank(Rec rmd) {
		SqlSession session = DBConnection.getSession();
		try {
			List<Rec> list = new ArrayList<Rec>();
			return session.getMapper(BoardMapper.class).rank(list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}

}
