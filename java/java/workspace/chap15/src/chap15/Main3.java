package chap15;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * bin/chap15/Test1212.class ����Ʈ�ڵ� ������ �о 16������ ����ϱ�
 */
public class Main3 {
	public static void main(String[] args) throws IOException {
//		System.out.printf("%d\n",100);
//		System.out.printf("%o\n",100);
//		System.out.printf("%x\n",100);
		FileInputStream fis = new FileInputStream("bin/chap15/Test1212.class");
		int len;
		byte[] buf = new byte[16];
		while((len = fis.read(buf))!= -1) {
			for(byte b : buf) {
				System.out.printf("%02X\t",b);	
			}
			System.out.println();
		}
		fis.close();
	}
}
