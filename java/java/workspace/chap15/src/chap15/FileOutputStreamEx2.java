package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * File�� ���� ���� ����ϱ�.
 */
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		method2();
	}

	private static void method2() {
		try {
			throw new Exception("���Ͽ� �޽��� �����ϱ�."); //���� �߻�.
		} catch (Exception e) {
	    	e.printStackTrace(); //ǥ�� ���(System.out)�� ����ϱ�.
	    	//new FileOutputStream("err.log",true)
	    	//err.log ������ �����ϴ� ��� ���� ������ �����ϰ�, ���ο� ������ �߰��ϴ� ���.
			PrintStream ps = null;
			try {
				FileOutputStream fos = new FileOutputStream("err.log",true);
				//�ڷ����� ��� x, ��¿� ����ȭ�� Ŭ����.
				//ps : err.log���Ͽ� println() ���� ����ϱ�.
				ps = new PrintStream(fos);
				ps.println(e.getMessage());
				e.printStackTrace(ps);

			} catch (FileNotFoundException fe) {
			} finally {
				ps.close();
			}

		}
	}
}