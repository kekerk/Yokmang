package chap15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * InputStream ���� :
 * 	1. ����Ʈ�� �Է½�Ʈ��.
 * 		read()�� ������ ����Ʈ(1byte) ����.
 * Reader ����
 * 	2. ������ �Է½�Ʈ��.
 *     read() �� ������ char(2byte) ����.
 *     
 *     InputStream => Reader : InputStreamReader
 *     InpuStreamReader => Reader�� ���� Ŭ������. InpuStreamReader is a Reader.(Reader ��)
 *     	������ : InputStreamReader(InputStream)
 */	
public class InputStreamEx1 {

	public static void main(String[] args) throws IOException {

		// ina : Ű���� �Է�. System.in ��ü�� ����.
		
		InputStream ina = System.in;
		
		//�ѱ��� ǥ���ϱ� ���� 2byte ������ ǥ���ؾ� �ϱ� ������ Reader Ŭ������ ����ϰ�. 
		//system.in(InputStream Ŭ������ ���)�� �ޱ� ���� new InputStreamReader �����ڸ� ���� ��ü�� �����Ѵ�.
		//system.in(�⺸�� �Է�)�� InputStream Ŭ������ ��ü.
		
		//in : ǥ���Է� ��ü�� Reader ���·� ����� ��ü�� ����.
		Reader in = new InputStreamReader(System.in);
		int data = 0;
		//InputStream ���� read()�� �ϸ� 1����Ʈ�� �д´�.
		//Reader ���� read()�� �ϸ� 2����Ʈ�� �д´�.
		//in.read() : '��' �Է��ϸ� data ������ '��' ���ڰ� �����.
		while((data=in.read())!= -1) { //ctrl + z : EOF ǥ��.
			System.out.print((char) data);
		}

	}

}
