package chap15;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * DataInputStream : DataOutputStream �� ����ȭ.
 * 		             1. ���� : �Էµ� ������ �˾ƾ� �Ѵ�.
 * 					 
 * 
 */
public class DataInputStreamEx1 {
	public static void main(String[] args) throws IOException {
		//"data.ser"�� ������ �о�´�. �� ȭ������.
		FileInputStream fis = new FileInputStream("data.ser");
		DataInputStream dis = new DataInputStream(fis);
		// ���� : �Էµ� ������� ����� �� �� �ִ�.
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
	}
}
