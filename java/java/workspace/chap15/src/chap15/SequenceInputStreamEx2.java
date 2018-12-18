package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class SequenceInputStreamEx2 {
	public static void main(String[] args) throws IOException {
		FileInputStream f1 = new FileInputStream("a.txt");
		FileInputStream f2 = new FileInputStream("abc.txt");
		FileInputStream f3 = new FileInputStream("err.log");
		int len=0;
//		SequenceInputStream si = new SequenceInputStream(f1, f2);
//		byte[] buf = new byte[si.available()];
//		while((len=si.read(buf))!= -1) {
//			System.out.println(new String(buf,0,len));
//		}
//		
		byte[] buf = new byte[f1.available()+f2.available()+f3.available()];
		Vector<InputStream> v = new Vector<InputStream>();
		v.add(f1);v.add(f2);v.add(f3);
		SequenceInputStream si2 = new SequenceInputStream(v.elements());
		while((len=si2.read(buf))!= -1) {
			System.out.println(new String(buf,0,len));
		}

		
	}
}
