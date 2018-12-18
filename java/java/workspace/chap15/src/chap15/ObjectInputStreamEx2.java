package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx2 {
	public static void main(String[] args) throws Throwable {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj2.ser"));
		//ois.readObject(); : �̸����� ������ ȣ��.
		UserInfo2 dc1 = (UserInfo2) ois.readObject();
		UserInfo2 dc2 = (UserInfo2) ois.readObject();
		System.out.println("����� 1 :"+dc1);
		System.out.println("����� 2 :"+dc2);
	}
}
