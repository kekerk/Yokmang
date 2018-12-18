package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Q0824_2_1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bin/chap15/PrintStreamEx1.class");
		byte[] buf = new byte[16];
		int len = 0;
		while((len = fis.read(buf))!= -1) {
			for(int i=0;i<len;i++) {
				System.out.printf(" %02X",buf[i]);
			}
			System.out.println();
		}
	}
}
