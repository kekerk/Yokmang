package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class Q0824_1_1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream("src/chap15/ObjectOutputStreamEx1.java");
		FileInputStream fis2 = new FileInputStream("src/chap15/ObjectInputStreamEx1.java");
		//두개의 스트림 연결
//		SequenceInputStream si = new SequenceInputStream(fis1, fis2);
		FileOutputStream fos  = new FileOutputStream("ObjectStream예제_1.txt");
		//Vector 이용
		Vector<InputStream> v = new Vector<InputStream>();
		v.add(fis1);
		v.add(fis2);
		SequenceInputStream si = new SequenceInputStream(v.elements());
		int len=0;
		byte[] buf = new byte[1024];
		while((len=si.read(buf))!= -1) {
			fos.write(buf,0,len);
		}
		si.close();
		fos.close();
	}

}
