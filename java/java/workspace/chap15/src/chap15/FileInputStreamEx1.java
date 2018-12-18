package chap15;
/*
 *  FileInputStream 예제
 *  1. InputStream 클래스의 하위 클래스
 *  2. 바이트형 입력 스트림.
 *  3. 출발지가 파일임.
 *   
 */

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		
//		Reader s = new InputStreamReader(fis);
//		int data=0;
//		while((data = fis.read())!= -1) {
//			System.out.print((char) data);
//		}

		// fis.available() : 읽기 가능 바이트 수를 리턴.
		int len=0;
		byte[] buf = new byte[fis.available()];
		/*
		 * len = fis.read(buf)
		 * 	fis로부터 데이터를 읽어서 buf 배열에 저장됨.
		 *  실제로 읽은 바이트 수를 len에 저장.
		 *  
		 *  new String(buf,0,len)
		 *  buf의 내용을 0번 인덱스부터 len-1인덱스까지 String 객체로 생성.
		 *  
		 *  -1 : EOF(End of File을 만나면 리턴됨)
		 *  	다 읽고 다시 while을 들어가면 파일의 끝을 만나고 그 값을 -1로 리턴.
		 */
		while((len = fis.read(buf))!= -1) {
			//buf를 0부터 len까지 String으로 찍는다.
			System.out.print((new String(buf,0,len)).toString());
		}
	}
}
