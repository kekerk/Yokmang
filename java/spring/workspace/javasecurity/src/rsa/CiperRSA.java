package rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
/*
 * RSA : 비대칭 암호, 공개키 암호
 * 		 암호화와 복호화에 사용되는 키가 다르다.
 * 		키가 2개임
 * 		공개키로 암호화시 개인키로 복호화 : 문서 보안
 * 		개인키로 암호화시 공개키로 복호화 : 전자서명에 사용,  부인방지에 사용
 * 		Key 사이즈가 2048bit. 보안성이 뛰어나다.
 * 		암/복호화 시 오래 걸림. 245byte 이상은 암호화 안됨.
 */
public class CiperRSA {
	static Cipher cipher;
	static PrivateKey priKey;
	static PublicKey pubKey;
	static {
		try {
			//ECB 모드로 암호화.  PKCS1 패딩
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
			key.initialize(2048); //RSA용 2048비트로 키를 생성(시스템에서 생성)
			KeyPair keyPair = key.genKeyPair();
			priKey = keyPair.getPrivate(); //개인키 설정
			pubKey = keyPair.getPublic();  //공개키 설정
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String encrypt(String plain) {
		byte[] ciperMsg = new byte[245];
		try {
			cipher.init(Cipher.ENCRYPT_MODE, priKey); // 개인키로 암호화
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
			cipher.init(Cipher.DECRYPT_MODE, pubKey); //공개키로 복호화
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
