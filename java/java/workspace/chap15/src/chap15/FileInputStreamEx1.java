package chap15;
/*
 *  FileInputStream ����
 *  1. InputStream Ŭ������ ���� Ŭ����
 *  2. ����Ʈ�� �Է� ��Ʈ��.
 *  3. ������� ������.
 *   
 */

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		
//		Reader s = new InputStreamReader(fis);
//		int data=0;
//		while((data = fis.read())!= -1) {
//			System.out.print((char) data);
//		}

		// fis.available() : �б� ���� ����Ʈ ���� ����.
		int len=0;
		byte[] buf = new byte[fis.available()];
		/*
		 * len = fis.read(buf)
		 * 	fis�κ��� �����͸� �о buf �迭�� �����.
		 *  ������ ���� ����Ʈ ���� len�� ����.
		 *  
		 *  new String(buf,0,len)
		 *  buf�� ������ 0�� �ε������� len-1�ε������� String ��ü�� ����.
		 *  
		 *  -1 : EOF(End of File�� ������ ���ϵ�)
		 *  	�� �а� �ٽ� while�� ���� ������ ���� ������ �� ���� -1�� ����.
		 */
		while((len = fis.read(buf))!= -1) {
			//buf�� 0���� len���� String���� ��´�.
			System.out.print((new String(buf,0,len)).toString());
		}
	}
}
