package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*---------------------------------------------------------------------- */	
public class MemberDao {
	public int insert(Member mem) {
		Connection conn = DBConnection.getConnection(); //DBConnection 클래스를 만들어야 한다. getConnection() 메서드는 클래스 메서드로 되어야하므로 static
		PreparedStatement pstmt = null;
		String sql= "insert into member ";
			sql 	+=  " (id,pass,name,gender,tel,email,picture)";
			sql   +=  " values(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mem.	getId());
			pstmt.setString(2,mem.getPass());
			pstmt.setString(3,mem.getName());
			pstmt.setInt(4,mem.getGender());
			pstmt.setString(5,mem.getTel());
			pstmt.setString(6,mem.getEmail());
			pstmt.setString(7,mem.getPicture());
			//  pstmt.executeUpdate(); : DBMS에 실제로 insert 구문 명령 전달.  1이라는 숫자가 return될것임. (정수형)
			//  int executeUpdate() : 변경(추가,삭제,수정) 된 레코드의 갯수 리턴.
			return pstmt.executeUpdate(); //1 , 쿼리 실행
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// 사용하고 난 뒤 close됨.
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	/*---------------------------------------------------------------------- */		
	public Member selectOne(String id) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			//executeQuery : DBMS의 데이터 정보를 조회하기.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 새 Member 객체를 만들어서 각각의 값들을 전부 set
				Member mem = new Member(); 
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getInt("gender"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setPicture(rs.getString("picture"));
				return mem; // mem : db의 정보를 저장하는 객체.
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null ;
	}
	/*---------------------------------------------------------------------- */	
	public Member selectOnepass(String pass) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where pass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pass);
			//executeQuery : DBMS의 데이터 정보를 조회하기.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// 새 Member 객체를 만들어서 각각의 값들을 전부 set
				Member mem = new Member(); 
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getInt("gender"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setPicture(rs.getString("picture"));
				return mem; // mem : db의 정보를 저장하는 객체.
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null ;
	}
	/*---------------------------------------------------------------------- */		
	public List<Member> list() {
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member ";
		try {
			List<Member> list = new ArrayList<Member>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member(); 
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setGender(rs.getInt("gender"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setPicture(rs.getString("picture"));
				list.add(mem); //db의 정보 저장 
			}
			return list ;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, rs);
		}
		return null;
	}
	/*---------------------------------------------------------------------- */		
	public int update(Member mem) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		String sql= "update  member set ";
			sql 	+=  " name=?,gender=?,tel=?,email=?,picture=? where id=?";
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mem.getName());
			pstmt.setInt(2,mem.getGender());
			pstmt.setString(3,mem.getTel());
			pstmt.setString(4,mem.getEmail());
			pstmt.setString(5,mem.getPicture());
			pstmt.setString(6,mem.getId());
			
		return pstmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;

	}
/*---------------------------------------------------------------------- */
	public int delete(Member mem) {
		Connection conn = DBConnection.getConnection(); 
		PreparedStatement pstmt = null;
		String sql= "delete from member where id=? ";
			try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mem.getId());
		return pstmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;

	}
/*---------------------------------------------------------------------- */	
	public int repass(Member mem) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update member "
				+ " set pass=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getPass());
			pstmt.setString(2, mem.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
	/*---------------------------------------------------------------------- */	
	public int updatepass(String id, String pass) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update member "
				+ " set pass=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
		return 0;
	}
}
