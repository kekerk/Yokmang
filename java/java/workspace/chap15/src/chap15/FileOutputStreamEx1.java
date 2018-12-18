package chap15;
/*
 * FileOutputStream 예제
 *  => 바이트 출력스트림.
 *  =>1바이트씩 write() 실행.
 *  
 * 	write(int) : 1byte만 출력하기.
 * 	write(byte[] buf) : buf의 내용을 출력.
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		//out.txt를 생성.
		FileOutputStream fos = new FileOutputStream("out.txt");
		//out.txt 안에 글 쓰기.
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('가');fos.write('나');fos.write('다');
		//byte[] buf = String타입.getBytes();
		byte[] buf = "\n반갑습니다.".getBytes();
		fos.write(buf);
		buf = "\n안녕하세요.".getBytes();
		fos.write(buf);
		fos.flush();
		fos.close();
	}
}
