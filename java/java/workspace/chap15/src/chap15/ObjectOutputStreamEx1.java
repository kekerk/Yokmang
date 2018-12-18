package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Serializable: ����ȭ�� ����
class Customer implements Serializable{ //��ü�� ����ȭ
	private String name;
	private int age;
	// transient : �ش� field(����, ��)�� ����ȭ ��󿡼� ���ܽ�Ű�� �����.
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
		//��ü�� ���ڴ�. ObjectOutputStream. obj.ser �ȿ��� ��ü ��ü ��°�� �� �ִ�.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
		
		Customer cs1 = new Customer("ȫ�浿", 25,"1234");
		Customer cs2 = new Customer("���", 30,"5678");
		//��ü �޸� ��ü�� write��.
		oos.writeObject(cs1);
		oos.writeObject(cs2);
		System.out.println("��1: "+cs1);
		System.out.println("��1: "+cs2);
		
	}
}
