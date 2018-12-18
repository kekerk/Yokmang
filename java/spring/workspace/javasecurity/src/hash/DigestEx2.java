package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * SHA 256 알고리즘을 이용하여 useraccount 테이블의 비밀번호를 해쉬 값으로 변경하기
 * 1. Class.forName(드라이버이름);
 * 2. DriverManager.getConnection(url,user,password) : 객체 생성
 * 3. PrepareStatement pstmt = conn.prepareStatement(sql); user_backup 테이블에서 password 컬럼만 조회 sql 구문 작성하기
 * 4. ResultSet rs = pstmt.executeQuery();
 * 5. rs의 모든 레코드의 password를 hash 알고리즘을 이용하여 해쉬 값 구하기
 * 5번에서 구한 hash 값을 db에 update 하기
 */
public class DigestEx2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		//Class.forName("드라이버이름") : jar파일 연결하기.
		Class.forName("org.mariadb.jdbc.Driver");
		//Connection 객체 생성
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb", "scott", "tiger");
		//쿼리문 저장
		PreparedStatement ps = conn.prepareStatement("select userid, password from user_backup");
		//쿼리문 실행하여 resultset에 저장
		ResultSet rs = ps.executeQuery();
		MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 해쉬알고리즘을 이용한 해쉬값
		while (rs.next()) {
			String userid = rs.getString("userid"); //userid 컬럼의 한 레코드씩 가져옴
			byte[] result = rs.getString("password").getBytes(); // result : 원본 데이터
			byte[] hash = md.digest(result); // hash : 해쉬 데이터
			String dbHash = "";
			for (byte b : hash) {	dbHash += String.format("%02x", b);   }
			PreparedStatement ps2 = conn.prepareStatement("update user_backup set password=? where userid = ?");
			ps2.setString(1, dbHash);
			ps2.setString(2, userid);
			ps2.executeUpdate();
		}
	}
}
