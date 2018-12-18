package rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
/*
 * RSA : ���Ī ��ȣ, ����Ű ��ȣ
 * 		 ��ȣȭ�� ��ȣȭ�� ���Ǵ� Ű�� �ٸ���.
 * 		Ű�� 2����
 * 		����Ű�� ��ȣȭ�� ����Ű�� ��ȣȭ : ���� ����
 * 		����Ű�� ��ȣȭ�� ����Ű�� ��ȣȭ : ���ڼ��� ���,  ���ι����� ���
 * 		Key ����� 2048bit. ���ȼ��� �پ��.
 * 		��/��ȣȭ �� ���� �ɸ�. 245byte �̻��� ��ȣȭ �ȵ�.
 */
public class CiperRSA {
	static Cipher cipher;
	static PrivateKey priKey;
	static PublicKey pubKey;
	static {
		try {
			//ECB ���� ��ȣȭ.  PKCS1 �е�
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
			key.initialize(2048); //RSA�� 2048��Ʈ�� Ű�� ����(�ý��ۿ��� ����)
			KeyPair keyPair = key.genKeyPair();
			priKey = keyPair.getPrivate(); //����Ű ����
			pubKey = keyPair.getPublic();  //����Ű ����
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String encrypt(String plain) {
		byte[] ciperMsg = new byte[245];
		try {
			cipher.init(Cipher.ENCRYPT_MODE, priKey); // ����Ű�� ��ȣȭ
			ciperMsg = cipher.doFinal(plain.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return byteToHex(ciperMsg).trim();
	}
	private static String byteToHex(byte[] ciperMsg) {
		if(ciperMsg == null) return null;
		int len = ciperMsg.length;
		String str = "";
		for(int i=0;i<len;i++) {
			str += String.format("%02X", (ciperMsg[i]));
		}
		return str;
	}
	public static String decrypt(String ciper) {
		byte[] plainMsg = new byte[1024];
		try {
			cipher.init(Cipher.DECRYPT_MODE, pubKey); //����Ű�� ��ȣȭ
			plainMsg = cipher.doFinal(hexToByte(ciper.trim()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new String(plainMsg).trim();
	}
	private static byte[] hexToByte(String str) {
		if(str == null) return null;
		if(str.length() < 2) return null;
		byte[] buffer = new byte[str.length()/2];//
		for(int i=0;i<buffer.length;i++) {
			buffer[i] = (byte) Integer.parseInt(str.substring(i*2, i*2+2),16);
		}
		return buffer;
	}
}
