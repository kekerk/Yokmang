package test;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Ciper {
	private static byte[] randomKey;
	private final static byte[] iv = new byte[] { //�ʱ�ȭ ����
			(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F,
			(byte) 0x5A, 
			(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 
			(byte) 0x5A };

	static Cipher cipher;

	static {
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] getRandomKey(String algo) throws Exception {
		/*
		 * AES �˰��� : 128, 192, 256 ��Ʈ �� �Ѱ� ���ð���
		 */
		KeyGenerator keyGen = KeyGenerator.getInstance(algo);
		keyGen.init(128); // 128 ��Ʈ¥�� Ű ����
		SecretKey key = keyGen.generateKey();
		return key.getEncoded();
	}

	// ��ȣȭ
	public static String encrypt(String plain) {
		byte[] ciperMsg = new byte[1024];
		try {
			// randomKey : 128��Ʈ ũ���� key ����
			randomKey = getRandomKey("AES");
			Key key = new SecretKeySpec(randomKey, "AES");// key ��ü ����
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv); //�ʱ�ȭ vector ��ü ����
			// Cipher.ENCRYPT_MODE : ��ȣȭ ���
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			ciperMsg = cipher.doFinal(paddingString(plain).getBytes()); // paddingString(plain).getBytes() : byte�� �迭
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteToHex(ciperMsg).trim();
	}

	private static String byteToHex(byte[] ciperMsg) {
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
	public static String decrypt(String ciper) {
		byte[] plainMsg = new byte[1024];
		try {
			
			Key key = new SecretKeySpec(randomKey, "AES"); 
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			//Cipher.DECRYPT_MODE : ��ȣȭ
			cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
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
