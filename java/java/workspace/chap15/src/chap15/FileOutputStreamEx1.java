package chap15;
/*
 * FileOutputStream ����
 *  => ����Ʈ ��½�Ʈ��.
 *  =>1����Ʈ�� write() ����.
 *  
 * 	write(int) : 1byte�� ����ϱ�.
 * 	write(byte[] buf) : buf�� ������ ���.
 */
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		//out.txt�� ����.
		FileOutputStream fos = new FileOutputStream("out.txt");
		//out.txt �ȿ� �� ����.
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('��');fos.write('��');fos.write('��');
		//byte[] buf = StringŸ��.getBytes();
		byte[] buf = "\n�ݰ����ϴ�.".getBytes();
		fos.write(buf);
		buf = "\n�ȳ��ϼ���.".getBytes();
		fos.write(buf);
		fos.flush();
		fos.close();
	}
}
