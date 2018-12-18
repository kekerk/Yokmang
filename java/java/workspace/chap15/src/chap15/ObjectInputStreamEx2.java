package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx2 {
	public static void main(String[] args) throws Throwable {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj2.ser"));
		//ois.readObject(); : 이름없는 생성자 호출.
		UserInfo2 dc1 = (UserInfo2) ois.readObject();
		UserInfo2 dc2 = (UserInfo2) ois.readObject();
		System.out.println("사용자 1 :"+dc1);
		System.out.println("사용자 2 :"+dc2);
	}
}
