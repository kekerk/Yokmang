package chap15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * Test1212.java ������ �о ȭ�鿡 ����ϱ�
 */
public class Test12121 {

	public static void main(String[] args) throws IOException {
		//������ �о����
		
		FileInputStream fis = new FileInputStream("src/chap15/Test1212.java");
		OutputStream os = System.out;
		// ��� 1
//		int data;
//      fis.read() : �ѱ��ھ� �д´�.
//		while((data = fis.read()) != -1) {
//			os.write(data);
// 		 	data:���� ���� ������ ����
//		}
		
		// ��� 2
//		int data;
//		byte[] buf = new byte[1024];
//		while((data = fis.read(buf)) != -1) {
//		os.write(buf);
//		buf : ���� ���� ������ ����
//		byte: ���� ���� ����Ʈ�� ��
//		System.out.println(data);
//	}		

		// ��� 3
		int data;
		byte[] buf = new byte[1024];
		byte[] pre = "aaaaa ".getBytes();
		for(int i=0;i<pre.length;i++) {
			buf[i] = pre[i];
		}
		// buf : ���� ����
		// pre.length-1 : ���� �ε��� ��
		// buf.length-pre.length : ���� �� �ִ� �ִ� ����Ʈ ��
		while((data=fis.read(buf,pre.length-1,buf.length-pre.length)) != -1) { // read(byte[] b, int off, int len) 
			os.write(buf, 0, data);
			System.out.println(data); //����Ʈ  ��
		}
		System.out.println("��� �Ϸ�");
	}
	
	Scanner scan = new Scanner(System.in);
	Boolean s = scan.hasNextLine();
	
	

}
