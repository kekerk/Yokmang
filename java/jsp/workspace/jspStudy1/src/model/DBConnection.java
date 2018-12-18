package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*  DB연동  */
public class DBConnection {
	static Connection getConnection() {
		Connection conn = null;
		try {
				Class.forName("org.mariadb.jdbc.Driver"); //클래스 정보 로딩
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb","scott", "tiger"); //DB 연결
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) {
				conn.commit();
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
