package chap15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * Test1212.java 파일을 읽어서 화면에 출력하기
 */
public class Test12121 {

	public static void main(String[] args) throws IOException {
		//데이터 읽어오기
		
		FileInputStream fis = new FileInputStream("src/chap15/Test1212.java");
		OutputStream os = System.out;
		// 방법 1
//		int data;
//      fis.read() : 한글자씩 읽는다.
//		while((data = fis.read()) != -1) {
//			os.write(data);
// 		 	data:실제 읽은 파일의 정보
//		}
		
		// 방법 2
//		int data;
//		byte[] buf = new byte[1024];
//		while((data = fis.read(buf)) != -1) {
//		os.write(buf);
//		buf : 실제 읽은 파일의 정보
//		byte: 실제 읽은 바이트의 수
//		System.out.println(data);
//	}		

		// 방법 3
		int data;
		byte[] buf = new byte[1024];
		byte[] pre = "aaaaa ".getBytes();
		for(int i=0;i<pre.length;i++) {
			buf[i] = pre[i];
		}
		// buf : 읽은 내용
		// pre.length-1 : 저장 인덱스 값
		// buf.length-pre.length : 읽을 수 있는 최대 바이트 수
		while((data=fis.read(buf,pre.length-1,buf.length-pre.length)) != -1) { // read(byte[] b, int off, int len) 
			os.write(buf, 0, data);
			System.out.println(data); //바이트  수
		}
		System.out.println("출력 완료");
	}
	
	Scanner scan = new Scanner(System.in);
	Boolean s = scan.hasNextLine();
	
	

}
