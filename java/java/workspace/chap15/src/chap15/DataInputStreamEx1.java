package chap15;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * DataInputStream : DataOutputStream 의 복구화.
 * 		             1. 단점 : 입력된 순서를 알아야 한다.
 * 					 
 * 
 */
public class DataInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		//"data.ser"의 내용을 읽어온다. 내 화면으로.
		FileInputStream fis = new FileInputStream("data.ser");
		DataInputStream dis = new DataInputStream(fis);
		// 단점 : 입력된 순서대로 출력을 할 수 있다.
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
	}
}
