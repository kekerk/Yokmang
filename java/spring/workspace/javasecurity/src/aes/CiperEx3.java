package aes;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/*
 * key : userid
 * user_backup ���̺��� email ���� ��ȣȭ�ϱ�.
 * 
 */
public class CiperEx3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bigdb", "scott", "tiger");
		PreparedStatement ps = conn.prepareStatement("select userid, email from user_backup");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String key = rs.getString("userid");
			String plain1 = rs.getString("email");
			String ciper1 = Ciper.encrypt(plain1, key);
			PreparedStatement ps2 = conn.prepareStatement("update user_backup set email=? where userid=?");
			ps2.setString(1, ciper1);
			ps2.setString(2, key);
			ps2.executeUpdate();
		}
	}
	static class Ciper {
		private final static byte[] iv = new byte[] { //�ʱ�ȭ ����
				(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F,
				(byte) 0x5A, 
				(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 
				(byte) 0x5A };

		static Cipher cipher;

		static {

			try {
				// Cipher.getInstance("AES/CBC/PKCS5Padding") : AES�� CBC��� (�ʱ�ȭ ���� �����Ѵ�) �е� ����� PKCS5Padding - ó�� �ѹ��� �ʼ������� ������.
				/*
				 * AES : ��ȣ �˰��� ���� -> �� ������ 128��Ʈ ���·� ����� ��. 16����Ʈ
				 * CBC : ��ȭ ���
				 * PKCS5Padding : �е� ���
				 */
				cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static byte[] makeKey(String key) {
			int len = key.length();
			char ch = 'A';
			for( int i=len;i<16;i++) {
				key += ch++;
			}
			return key.substring(0, 16).getBytes();
		}

		// ��ȣȭ
		public static String encrypt(String plain, String key) {
			byte[] ciperMsg = new byte[1024];
			try {
				Key genkey = new SecretKeySpec(makeKey(key), "AES");// key ��ü ����
				AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv); //�ʱ�ȭ vector ��ü ����
				// Cipher.ENCRYPT_MODE : ��ȣȭ ���
				cipher.init(Cipher.ENCRYPT_MODE, genkey, paramSpec);
				ciperMsg = cipher.doFinal(paddingString(plain).getBytes()); // paddingString(plain).getBytes() : byte�� �迭
			} catch (Exception e) {
				e.printStackTrace();
			}
			return byteToHex(ciperMsg).trim();
		}

		private static String byteToHex(byte[] ciperMsg){
			if (ciperMsg == null)
				return null;
			int len = ciperMsg.length;
			String str = "";
			for (int i = 0; i < len; i++) {
				if ((ciperMsg[i] & 0xFF) < 16) { // (ciperMsg[i] & 0xFF) : ���� �� ��� ����� �ٲ��ֱ� ���� 
					str += "0" + Integer.toHexString(ciperMsg[i] & 0xFF); //���ڿ� ���·� �ٽ� ����� ��
				} else {
					str += Integer.toHexString(ciperMsg[i] & 0xFF); //���ڿ� ���·� �ٽ� ����� ��
				}
			}
			return str;
		}

		private static String paddingString(String plain) {
			char paddingChar = ' ';
			int size = 16;
			int x = plain.length() % size; // ex) plain.length = 5
			int len = size - x;
			for (int i = 0; i < len; i++) {
				plain += paddingChar; //16����Ʈ �� ���ڶ� �κ��� ���� ' '���� ä��. 16����Ʈ�� ä������.  �Ϻ��� ������ �����.
			}
			return plain;
		}

		// ��ȣȭ
		public static String decrypt(String ciper, String key) {
			byte[] plainMsg = new byte[1024];
			try {
				Key genkey = new SecretKeySpec(makeKey(key), "AES"); 
				AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
				//Cipher.DECRYPT_MODE : ��ȣȭ
				cipher.init(Cipher.DECRYPT_MODE, genkey, paramSpec);
				plainMsg = cipher.doFinal(hexToByte(ciper.trim()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new String(plainMsg).trim();
		}

		private static byte[] hexToByte(String str) { //byte�� �迭 ����� �޼���
			if (str == null)
				return null;
			if (str.length() < 2)
				return null;
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16); // 2���� ��� ��ȣȭ ��Ŵ
			}
			return buffer;
		}
	}
	
	
}
