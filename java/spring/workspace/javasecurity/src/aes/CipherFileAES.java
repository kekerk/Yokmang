package aes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherFileAES {
	private final static byte[] iv = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, (byte) 0x5A,
			(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, (byte) 0x5A, }; //초기화 vector 설정
	static AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
	static Cipher cipher;
	static {
		try {
			//cipher : AES 알고리즘, CSC 블록화 모드를 이용하여 암/복호화 하는 암호 객체 생성
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	// 암호화
	// plainfile : 원문 파일, 입력파일
	// cipherfile : 암호화된 파일, 출력파일
	public static void encryptFile(String plainfile, String cipherfile) {
		try {
			//등록된 key를 읽기
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
			Key key = (Key) ois.readObject(); //파일에 저장된 Key 객체를 복원
			ois.close();
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);//암호화 객체를 설정
			FileInputStream fis = new FileInputStream(plainfile);
			FileOutputStream fos = new FileOutputStream(cipherfile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			byte[] buf = new byte[1024];
			int len;
			while ((len = fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] makeKey(String key) { //128비트 형태의 key로 만듬
		int len = key.length();
		char ch = 'A';
		for(int i=len;i<16;i++) {
			key += ch++;
		}
		return key.substring(0, 16).getBytes();
	}
	
	public static void getKey(String key) {
		try {
			Key genkey = new SecretKeySpec(makeKey(key),"AES"); //암/복호화에 사용할 키 객체 생성
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("key.ser"));
			out.writeObject(genkey); // Serializable 구현 객체만 writeObject(obj) 출력가능함. -> Key 인터페이스는 Serializable 인터페이스가 구현되어 있다.
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 복호화
	// plainfile : 복호화된 파일
	// cipherfile : 암호화된 파일
	public static void decryptFile(String cipherfile, String plainfile) {
	try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
		Key key = (Key) ois.readObject();
		ois.close();
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);// 복호화로 설정된 암호 객체
		FileInputStream fis = new FileInputStream(cipherfile);// 암호화된 문서
		FileOutputStream fos = new FileOutputStream(plainfile);// 복호화된 문서
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);//복호화
		byte[] buf = new byte[1024];
		int len;
		System.out.println("size:"+fis.available());
		while ((len = fis.read(buf)) != -1) {
			cos.write(buf, 0, len);
		}
		fis.close();
		cos.flush();
		cos.close();
		fos.flush();
		fos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	public static void encryptFileWithPasskey(String passkey, String pfile, String cfile) {
		try {
			Key genkey = new SecretKeySpec(makeKey(passkey),"AES");
			cipher.init(Cipher.ENCRYPT_MODE, genkey, paramSpec);//암호화 객체를 설정
			FileInputStream fis = new FileInputStream(pfile);
			FileOutputStream fos = new FileOutputStream(cfile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			byte[] buf = new byte[1024];
			int len;
			while ((len = fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void decryptFileWithPasskey(String passkey, String cfile, String pfile) {
		try {
			Key genkey = new SecretKeySpec(makeKey(passkey),"AES");
			cipher.init(Cipher.DECRYPT_MODE, genkey, paramSpec);//암호화 객체를 설정
			FileInputStream fis = new FileInputStream(cfile);
			FileOutputStream fos = new FileOutputStream(pfile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			byte[] buf = new byte[1024];
			int len;
			while ((len = fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
