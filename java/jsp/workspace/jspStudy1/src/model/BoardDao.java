package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public int maxNum() { //board 테이블의 저장된 num 컬럼의 최대값 리턴
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
		// limit ?,? : 시작인덱스(0부터) 부터 갯수
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
			return list; // db에서 조회된 게시물 객체를 리턴.
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
		ResultSet rs = null; //select 구문 sql을 받기 위한 인터페이스.
		String sql = "select * from board where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			//executeQuery : DBMS의 데이터 정보를 조회하기.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 새 Member 객체를 만들어서 각각의 값들을 전부 set
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
			return pstmt.executeUpdate(); //  int executeUpdate() : 변경(추가,삭제,수정) 된 레코드의 갯수 리턴.
															   //  pstmt.executeUpdate(); : DBMS에 실제로 insert 구문 명령 전달.  1이라는 숫자가 return될것임. (정수형)
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
	/* reply 메서드
	 * board : 원글에 대한 정보 : num,ref,reflevel,refstep
	 * 				답글에 대한 정보 :  name,pass,title,content
	 */
	public boolean reply (Board board) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		int num = this.maxNum(); // 최대 num 값 리턴
		int ref = board.getRef(); // 원글의 ref값 
		int reflevel = board.getReflevel(); //원글의 reflevel값
		int refstep = board.getRefstep(); //원글의 refstep값
/* 목록의 조회 순서 : ref desc, refstep asc
 * 	   num   ref  reflevel refstep 
 * 		3			3			0			0		=>원글
 * 		2			2			0			0		=>원글
 * 		6			2			1			1		=>2번의 답글
 *		5			2			1			2		=>2번의 답글
 *		7			2			2			3		=> 2번의 답글 5에 대한 답글
 * 		4			2			1			4		=>2번의 답글	
 * 		1			1			0			0		=>원글
 * 
 * 		
 */
		   try {
		String sql = "update board set refstep = refstep+1 "; //기존의 답글이 있는 경우 refstep을 1씩 증가시켜서 위치 재설정
			       sql += " where ref=? and refstep > ? ";
	    		pstmt = conn.prepareStatement(sql);
	    		pstmt.setInt(1,ref);
	    		pstmt.setInt(2,refstep);
	    		pstmt.executeUpdate();
	    		//하나의 메서드
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
		// limit ?,? : 시작인덱스(0부터) 부터 갯수
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
			return list; // db에서 조회된 게시물 객체를 리턴.
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
