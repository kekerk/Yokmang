package chap15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * OutputStream : byte형 출력 스트림.
 * 	1byte 단위로 write() 됨.
 * 
 *  PrintStream System.out; : 표준 출력. 화면 출력.
 *  PrintStream 클래스는 OutputStream의 하위클래스임.
 */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write('1');
		out.write('2');
		out.write('3');
		out.write('a');
		out.write('b');
		out.write('c');
		out.write('가');
		out.write('나');
		out.write('다');
//		out.write('ㄱ');
//		out.write('ㅏ');
//		out.write('ㄴ');
//		out.write('ㅏ');
//		out.write('ㄷ');
//		out.write('ㅏ');
		// .flush() : 버퍼의 내용을 목적지로 강제 전송
		out.flush();
		// .close() : 출력스트림 닫기. 
//		out.close();
		System.out.println();
		//System.out 은 PrintStream
		Writer wr = new OutputStreamWriter(System.out);
		wr.write('1');
		wr.write('2');
		wr.write('3');
		wr.write('a');
		wr.write('b');
		wr.write('c');
		wr.write('가');
		wr.write('나');
		wr.write('다');
		wr.flush();
		wr.close();
		
	}
}
