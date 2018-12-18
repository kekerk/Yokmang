package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 1. javasecurity 자바 프로젝트 생성
 * 2. hash 패키지 생성
 * 3. DigestEx.java 파일 생성
 * 
 */
//대표적인 hash 알고리즘
public class DigestEx {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] plain = null;
		byte[] hash = null;
		String[] algo = {"MD5","SHA-1","SHA-256"};
		System.out.println("해쉬값을 구할 문자열 입력");
		plain = br.readLine().getBytes();
		 for(String a : algo) {
			 MessageDigest md = MessageDigest.getInstance(a);
			 hash = md.digest(plain); //해쉬값 구하기
			 System.out.println(a+" 해쉬값 크기 : "+(hash.length*8)+"bits");
			 System.out.print("암호문: ");
			 for(byte b : hash) { System.out.printf("%02x",b); }
			 System.out.println();
		 }
	}
}
