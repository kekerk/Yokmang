package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 1. javasecurity �ڹ� ������Ʈ ����
 * 2. hash ��Ű�� ����
 * 3. DigestEx.java ���� ����
 * 
 */
//��ǥ���� hash �˰���
public class DigestEx {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] plain = null;
		byte[] hash = null;
		String[] algo = {"MD5","SHA-1","SHA-256"};
		System.out.println("�ؽ����� ���� ���ڿ� �Է�");
		plain = br.readLine().getBytes();
		 for(String a : algo) {
			 MessageDigest md = MessageDigest.getInstance(a);
			 hash = md.digest(plain); //�ؽ��� ���ϱ�
			 System.out.println(a+" �ؽ��� ũ�� : "+(hash.length*8)+"bits");
			 System.out.print("��ȣ��: ");
			 for(byte b : hash) { System.out.printf("%02x",b); }
			 System.out.println();
		 }
	}
}
