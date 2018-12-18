package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserInfo1 {
	public String name;
	public String password;
	public UserInfo1(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public UserInfo1() {}

	@Override
	public String toString() {
		return "UserInfo1 [name=" + name + ", password=" + password;
	}

}

class UserInfo2 extends UserInfo1 implements Serializable {
	private int age;

	public UserInfo2() {}

	public UserInfo2(String name, String password, int age) {
		super(name, password);
		this.age = age;

	}

	@Override
	public String toString() {
		return super.toString() + ",age=" + age + "]";
	}

	//////////////////////////////////부모 클래스에서 serializable을 구현하지 못할 경우//////////////////////////////
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
		;
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
}

public class ObjectOutputStreamEx2 {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj2.ser"));
		UserInfo2 ui1 = new UserInfo2("홍길동", "1234", 25);
		UserInfo2 ui2 = new UserInfo2("김삿갓", "5678", 30);
		oos.writeObject(ui1);
		oos.writeObject(ui2);
		System.out.println("사용자 1 :" + ui1);
		System.out.println("사용자 2 :" + ui2);

	}
}
