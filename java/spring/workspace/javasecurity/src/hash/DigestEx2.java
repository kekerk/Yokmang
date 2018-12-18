package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * SHA 256 �˰����� �̿��Ͽ� useraccount ���̺��� ��й�ȣ�� �ؽ� ������ �����ϱ�
 * 1. Class.forName(����̹��̸�);
 * 2. DriverManager.getConnection(url,user,password) : ��ü ����
 * 3. PrepareStatement pstmt = conn.prepareStatement(sql); user_backup ���̺��� password �÷��� ��ȸ sql ���� �ۼ��ϱ�
 * 4. ResultSet rs = pstmt.executeQuery();
 * 5. rs�� ��� ���ڵ��� password�� hash �˰����� �̿��Ͽ� �ؽ� �� ���ϱ�
 * 5������ ���� hash ���� db�� update �ϱ�
 */
public class DigestEx2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		//Class.forName("����̹��̸�") : jar���� �����ϱ�.
		Class.forName("org.mariadb.jdbc.Driver");
		//Connection ��ü ����
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb", "scott", "tiger");
		//������ ����
		PreparedStatement ps = conn.prepareStatement("select userid, password from user_backup");
		//������ �����Ͽ� resultset�� ����
		ResultSet rs = ps.executeQuery();
		MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 �ؽ��˰����� �̿��� �ؽ���
		while (rs.next()) {
			String userid = rs.getString("userid"); //userid �÷��� �� ���ڵ徿 ������
			byte[] result = rs.getString("password").getBytes(); // result : ���� ������
			byte[] hash = md.digest(result); // hash : �ؽ� ������
			String dbHash = "";
			for (byte b : hash) {	dbHash += String.format("%02x", b);   }
			PreparedStatement ps2 = conn.prepareStatement("update user_backup set password=? where userid = ?");
			ps2.setString(1, dbHash);
			ps2.setString(2, userid);
			ps2.executeUpdate();
		}
	}
}
