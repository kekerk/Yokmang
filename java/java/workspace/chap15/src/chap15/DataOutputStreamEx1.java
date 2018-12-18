package chap15;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
*	DataOutputStream ����
*	������Ʈ��.
*	�⺻�ڷ������� ����ϴ� ���.
*	������� ����� �Ǿ���Ѵ�.
*/
public class DataOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		// "data.ser" ���� ����.
		FileOutputStream fos = new FileOutputStream("data.ser");
		DataOutputStream dos = new DataOutputStream(fos);
		// �Է� �κ�.
		dos.writeBoolean(true);
		dos.writeInt(1234);	
		dos.writeChar('A'); 
		dos.writeDouble(123.45);
		System.out.println(dos.size()+"����Ʈ");
		dos.flush(); dos.close();

	}
}
