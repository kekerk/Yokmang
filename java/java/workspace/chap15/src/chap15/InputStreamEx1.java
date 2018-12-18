package chap15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * InputStream 예제 :
 * 	1. 바이트형 입력스트림.
 * 		read()의 단위가 바이트(1byte) 단위.
 * Reader 예제
 * 	2. 문자형 입력스트림.
 *     read() 의 단위가 char(2byte) 단위.
 *     
 *     InputStream => Reader : InputStreamReader
 *     InpuStreamReader => Reader의 하위 클래스임. InpuStreamReader is a Reader.(Reader 임)
 *     	생성자 : InputStreamReader(InputStream)
 */	
public class InputStreamEx1 {

	public static void main(String[] args) throws IOException {

		// ina : 키보드 입력. System.in 객체를 참조.
		
		InputStream ina = System.in;
		
		//한글을 표현하기 위해 2byte 단위로 표현해야 하기 때문에 Reader 클래스를 사용하고. 
		//system.in(InputStream 클래스의 기능)을 받기 위해 new InputStreamReader 생성자를 통해 객체를 생성한다.
		//system.in(기보드 입력)은 InputStream 클래스의 객체.
		
		//in : 표준입력 객체를 Reader 형태로 변경된 객체를 참조.
		Reader in = new InputStreamReader(System.in);
		int data = 0;
		//InputStream 에서 read()를 하면 1바이트씩 읽는다.
		//Reader 에서 read()를 하면 2바이트씩 읽는다.
		//in.read() : '가' 입력하면 data 변수에 '가' 문자가 저장됨.
		while((data=in.read())!= -1) { //ctrl + z : EOF 표시.
			System.out.print((char) data);
		}

	}

}
