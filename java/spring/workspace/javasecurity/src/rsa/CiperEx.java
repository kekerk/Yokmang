package rsa;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//AES ��ȣȭ �ϱ�
public class CiperEx {
	public static void main(String[] args) {
		String plain1 = "�ȳ��ϼ���. ȫ�浿�Դϴ�.";
		String ciper1 = CiperRSA.encrypt(plain1);
		System.out.println("��ȣ��:" + ciper1);
		String plain2 = CiperRSA.decrypt(ciper1);
		System.out.println("��ȣ��:" + plain2);
	}

}
