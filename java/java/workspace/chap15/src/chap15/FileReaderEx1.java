package chap15;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/chap15/FileInputStreamEx1.java");
		// available을 잡지 못하므로 일정 크기의 char 생성.
//		int data= 0;
//		while((data =fr.read()) != -1) {
//			System.out.print((char) data);
//		}
		
		char[] buf = new char[1000];
		int len = 0;
		while((len = fr.read(buf))!= -1) {
			System.out.print(new String(buf,0,len));
		}
	}
}
