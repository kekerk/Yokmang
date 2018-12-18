package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx1 { //객체 자체를 주고 받는 것

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.ser"));
		Customer cs1 = (Customer) ois.readObject();
		Customer cs2 = (Customer) ois.readObject();
		System.out.println(cs1);
		System.out.println(cs2);
	}

}
