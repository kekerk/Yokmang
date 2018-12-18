package rsa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

public class CipherUtilRSA {
	static Cipher cipher;
	static {
		try {
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch(NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	public static void encryptFile(String plainfile, String cipherfile) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("privatekey.ser")); //개인키 읽음
			PrivateKey prikey = (PrivateKey) ois.readObject(); 
			ois.close();
			cipher.init(Cipher.ENCRYPT_MODE, prikey); //개인키로 암호화
			FileInputStream fis = new FileInputStream(plainfile);
			FileOutputStream fos = new FileOutputStream(cipherfile);
			CipherOutputStream cos = new CipherOutputStream(fos,cipher);
			byte[] buf = new byte[1024];
			int len;
			while((len=fis.read(buf))!= -1) {
				cos.write(buf,0,len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void getKey() {
		try {
			KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
			key.initialize(2048);
			KeyPair keyPair = key.generateKeyPair();
			PrivateKey priKey = keyPair.getPrivate();
			PublicKey pubKey = keyPair.getPublic();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("privatekey.ser"));
			out.writeObject(priKey);
			out.flush();
			out.close();
			out = new ObjectOutputStream(new FileOutputStream("publickey.ser"));
			out.writeObject(pubKey);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void decryptFile(String cipherfile, String plainfile) {
		  try {
		         ObjectInputStream ois=new ObjectInputStream(new FileInputStream("publickey.ser"));
		         PublicKey pubkey=(PublicKey)ois.readObject();
		         ois.close();
		         cipher.init(Cipher.DECRYPT_MODE, pubkey);
		         FileInputStream fis=new FileInputStream(cipherfile);
		         FileOutputStream fos=new FileOutputStream(plainfile);
		         CipherOutputStream cos=new CipherOutputStream(fos, cipher);
		         byte[] buf=new byte[1024];
		         int len;
		         System.out.println("size:"+fis.available());
		         while((len=fis.read(buf))!=-1)
		            cos.write(buf,0,len);
		         fis.close();
		         cos.flush();         cos.close();
		         fos.flush();         fos.close();
		      } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
