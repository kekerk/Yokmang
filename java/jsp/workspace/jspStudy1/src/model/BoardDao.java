package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public int maxNum() { //board ���̺��� ����� num �÷��� �ִ밪 ����
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select ifnull(max(num),0) from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1); //ifnull(max(num),0)
		}catch(SQLException e) {
			DBConnection.close(conn, pstmt, rs);
		}
		return 0;
	}
	public boolean insert(Board board) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into board ";
			       sql += " (num,name,pass,title,content,file1,regdate,readcnt,ref,reflevel,refstep) ";
			       sql += " values (?,?,?,?,?,?,now(),0,?,?,?) ";
	    try {
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1,board.getNum());
	    		pstmt.setString(2,board.getName());
	    		pstmt.setString(3,board.getPass());
	    		pstmt.setString(4,board.getTitle());
	    		pstmt.setString(5,board.getContent());
	    		pstmt.setString(6,board.getFile1());
	    		pstmt.setInt(7,board.getRef());
	    		pstmt.setInt(8,board.getReflevel());
	    		pstmt.setInt(9,board.getRefstep());
	    		pstmt.executeUpdate();
				return true;
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	DBConnection.close(conn, pstmt, null);
	    }
	    return false;
	}
	
	public int boardCount() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	public List<Board> list(int pageNum, int limit){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from board "
						 + " order by ref desc, refstep asc limit ?,?";
		// limit ?,? : �����ε���(0����) ���� ����
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*limit);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPass(rs.getString("pass"));
				board.setFile1(rs.getString("file1"));
				board.setRef(rs.getInt("ref"));
				board.setReflevel(rs.getInt("reflevel"));
				board.setRefstep(rs.getInt("refstep"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setRegdate(rs.getTimestamp("regdate"));
				list.add(board);
			}
			return list; // db���� ��ȸ�� �Խù� ��ü�� ����.
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public Board selectOne(int num) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select ���� sql�� �ޱ� ���� �������̽�.
		String sql = "select * from board where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			//executeQuery : DBMS�� ������ ������ ��ȸ�ϱ�.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// �� Member ��ü�� ���� ������ ������ ���� set
				Board board = new Board(); 
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPass(rs.getString("pass"));
				board.setFile1(rs.getString("file1"));
				board.setRef(rs.getInt("ref"));
				board.setReflevel(rs.getInt("reflevel"));
				board.setRefstep(rs.getInt("refstep"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setRegdate(rs.getTimestamp("regdate"));
				return board;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null ;
	}
	
	public int readcntadd(int num) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		String sql= "update  board set ";
			sql 	+=  " readcnt=readcnt+1 where num=?";
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			return pstmt.executeUpdate(); //  int executeUpdate() : ����(�߰�,����,����) �� ���ڵ��� ���� ����.
															   //  pstmt.executeUpdate(); : DBMS�� ������ insert ���� ��� ����.  1�̶�� ���ڰ� return�ɰ���. (������)
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;

	}
	
	public boolean update(Board board) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		String sql= "update  board set ";
			sql 	+=  " name=?,title=?,content=?,file1=? where num=?";
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,board.getName());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContent());
			pstmt.setString(4,board.getFile1());
			pstmt.setInt(5,board.getNum());

			pstmt.executeUpdate(); 
		return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;

	}
	
	public boolean delete(Board board) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		String sql= "delete from board where num=? ";
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board.getNum());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return false;

	}
	/* reply �޼���
	 * board : ���ۿ� ���� ���� : num,ref,reflevel,refstep
	 * 				��ۿ� ���� ���� :  name,pass,title,content
	 */
	public boolean reply (Board board) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int num = this.maxNum(); // �ִ� num �� ����
		int ref = board.getRef(); // ������ ref�� 
		int reflevel = board.getReflevel(); //������ reflevel��
		int refstep = board.getRefstep(); //������ refstep��
/* ����� ��ȸ ���� : ref desc, refstep asc
 * 	   num   ref  reflevel refstep 
 * 		3			3			0			0		=>����
 * 		2			2			0			0		=>����
 * 		6			2			1			1		=>2���� ���
 *		5			2			1			2		=>2���� ���
 *		7			2			2			3		=> 2���� ��� 5�� ���� ���
 * 		4			2			1			4		=>2���� ���	
 * 		1			1			0			0		=>����
 * 
 * 		
 */
		   try {
		String sql = "update board set refstep = refstep+1 "; //������ ����� �ִ� ��� refstep�� 1�� �������Ѽ� ��ġ �缳��
			       sql += " where ref=? and refstep > ? ";
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1,ref);
	    		pstmt.setInt(2,refstep);
	    		pstmt.executeUpdate();
	    		//�ϳ��� �޼���
	    		board.setRef(ref);
	    		board.setReflevel(++reflevel);
	    		board.setRefstep(++refstep); //1
	    		board.setNum(++num);
				return this.insert(board);
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }finally {
	    	DBConnection.close(conn, pstmt, null);
	    }
	    return false;
	}
	
	
	public List<Board> list2(int pageNum, int limit,String search, String searchfor){
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = "select * from board  where "+search+" like '%"+searchfor + "%'  order by ref desc, refstep asc limit ?,?";
		// limit ?,? : �����ε���(0����) ���� ����
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*limit);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setPass(rs.getString("pass"));
				board.setFile1(rs.getString("file1"));
				board.setRef(rs.getInt("ref"));
				board.setReflevel(rs.getInt("reflevel"));
				board.setRefstep(rs.getInt("refstep"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setRegdate(rs.getTimestamp("regdate"));
				list.add(board);
			}
			return list; // db���� ��ȸ�� �Խù� ��ü�� ����.
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int boardCountsearch(String search, String searchfor) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board where "+ search + " like '%" + searchfor +"%' ";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return 0;
	}
}
