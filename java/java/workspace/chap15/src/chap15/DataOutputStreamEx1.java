package chap15;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
*	DataOutputStream 예제
*	보조스트림.
*	기본자료형으로 출력하는 기능.
*	순서대로 출력이 되어야한다.
*/
public class DataOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		// "data.ser" 파일 생성.
		FileOutputStream fos = new FileOutputStream("data.ser");
		DataOutputStream dos = new DataOutputStream(fos);
		// 입력 부분.
		dos.writeBoolean(true);
		dos.writeInt(1234);	
		dos.writeChar('A'); 
		dos.writeDouble(123.45);
		System.out.println(dos.size()+"바이트");
		dos.flush(); dos.close();

	}
}
