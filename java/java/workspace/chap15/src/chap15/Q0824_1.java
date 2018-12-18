package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
 /*
 * ObjectOutputStreamEx1.java ���ϰ� 

 * ObjectInputStreamEx2.java ������ ���Ͽ�

 * ObjectStream����.txt ���Ϸ� �����ϱ�

 */
public class Q0824_1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream("src/chap15/ObjectOutputStreamEx1.java");
		FileInputStream fis2 = new FileInputStream("src/chap15/ObjectInputStreamEx1.java");
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		byte[] buf = new byte[sis.available()];
		FileOutputStream out = new FileOutputStream("ObjectStream����.txt");
		int len=0;
		while((len=sis.read(buf))!= -1) {
			out.write((new String(buf,0,len)).getBytes());
		}
		out.flush();
		out.close();
		
	}
}
