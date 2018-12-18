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
			(byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, (byte) 0x5A, }; //�ʱ�ȭ vector ����
	static AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
	static Cipher cipher;
	static {
		try {
			//cipher : AES �˰���, CSC ���ȭ ��带 �̿��Ͽ� ��/��ȣȭ �ϴ� ��ȣ ��ü ����
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	// ��ȣȭ
	// plainfile : ���� ����, �Է�����
	// cipherfile : ��ȣȭ�� ����, �������
	public static void encryptFile(String plainfile, String cipherfile) {
		try {
			//��ϵ� key�� �б�
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
			Key key = (Key) ois.readObject(); //���Ͽ� ����� Key ��ü�� ����
			ois.close();
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);//��ȣȭ ��ü�� ����
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
	
	public static byte[] makeKey(String key) { //128��Ʈ ������ key�� ����
		int len = key.length();
		char ch = 'A';
		for(int i=len;i<16;i++) {
			key += ch++;
		}
		return key.substring(0, 16).getBytes();
	}
	
	public static void getKey(String key) {
		try {
			Key genkey = new SecretKeySpec(makeKey(key),"AES"); //��/��ȣȭ�� ����� Ű ��ü ����
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("key.ser"));
			out.writeObject(genkey); // Serializable ���� ��ü�� writeObject(obj) ��°�����. -> Key �������̽��� Serializable �������̽��� �����Ǿ� �ִ�.
			out.flush();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// ��ȣȭ
	// plainfile : ��ȣȭ�� ����
	// cipherfile : ��ȣȭ�� ����
	public static void decryptFile(String cipherfile, String plainfile) {
	try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
		Key key = (Key) ois.readObject();
		ois.close();
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);// ��ȣȭ�� ������ ��ȣ ��ü
		FileInputStream fis = new FileInputStream(cipherfile);// ��ȣȭ�� ����
		FileOutputStream fos = new FileOutputStream(plainfile);// ��ȣȭ�� ����
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);//��ȣȭ
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
			cipher.init(Cipher.ENCRYPT_MODE, genkey, paramSpec);//��ȣȭ ��ü�� ����
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
			cipher.init(Cipher.DECRYPT_MODE, genkey, paramSpec);//��ȣȭ ��ü�� ����
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
