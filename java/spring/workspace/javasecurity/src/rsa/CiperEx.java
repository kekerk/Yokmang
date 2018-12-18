package rsa;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//AES 암호화 하기
public class CiperEx {
	public static void main(String[] args) {
		String plain1 = "안녕하세요. 홍길동입니다.";
		String ciper1 = CiperRSA.encrypt(plain1);
		System.out.println("암호문:" + ciper1);
		String plain2 = CiperRSA.decrypt(ciper1);
		System.out.println("복호문:" + plain2);
	}

}
