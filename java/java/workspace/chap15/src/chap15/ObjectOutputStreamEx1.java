package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Serializable: 직렬화를 위해
class Customer implements Serializable{ //객체의 직렬화
	private String name;
	private int age;
	// transient : 해당 field(변수, 값)는 직렬화 대상에서 제외시키는 예약어.
	private transient String jumin;
	public Customer(String name, int age, String jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
	
}
public class ObjectOutputStreamEx1 {
	public static void main(String[] args) throws IOException{
		//객체를 쓰겠다. ObjectOutputStream. obj.ser 안에는 객체 자체 통째로 들어가 있다.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
		
		Customer cs1 = new Customer("홍길동", 25,"1234");
		Customer cs2 = new Customer("김삿갓", 30,"5678");
		//객체 메모리 자체가 write됨.
		oos.writeObject(cs1);
		oos.writeObject(cs2);
		System.out.println("고객1: "+cs1);
		System.out.println("고객1: "+cs2);
		
	}
}
