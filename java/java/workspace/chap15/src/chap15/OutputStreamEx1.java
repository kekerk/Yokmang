package chap15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * OutputStream : byte�� ��� ��Ʈ��.
 * 	1byte ������ write() ��.
 * 
 *  PrintStream System.out; : ǥ�� ���. ȭ�� ���.
 *  PrintStream Ŭ������ OutputStream�� ����Ŭ������.
 */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write('1');
		out.write('2');
		out.write('3');
		out.write('a');
		out.write('b');
		out.write('c');
		out.write('��');
		out.write('��');
		out.write('��');
//		out.write('��');
//		out.write('��');
//		out.write('��');
//		out.write('��');
//		out.write('��');
//		out.write('��');
		// .flush() : ������ ������ �������� ���� ����
		out.flush();
		// .close() : ��½�Ʈ�� �ݱ�. 
//		out.close();
		System.out.println();
		//System.out �� PrintStream
		Writer wr = new OutputStreamWriter(System.out);
		wr.write('1');
		wr.write('2');
		wr.write('3');
		wr.write('a');
		wr.write('b');
		wr.write('c');
		wr.write('��');
		wr.write('��');
		wr.write('��');
		wr.flush();
		wr.close();
		
	}
}
