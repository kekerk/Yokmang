package chap14;
/*
 * Set ��ü�� �ߺ� ���� �Ǵ�.
 * 	equals(Object) : ����� true �̰�
 *  hashcode()     : ������� �ΰ��� ��ü�� ���� ���
 *  => �ߺ���ü�� �ν���.
 *  
 *  �ߺ��� ���ַ��� equals�� hashcode() �� �������̵��ؾ���. �� �� �������̵�.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Person{ //Person ��ü�� �������̵� ������ 
	String name;
	int age;
	Person (String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "("+name+","+age+")";
	}
	@Override
	public int hashCode() {
		
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) { //���� ��������� ���� ��ü �ȿ��� �ۿ�.
			Person p = (Person) obj;
			return name.equals(p.name)&&age==p.age;
		} else {
			return false;
		}
		
}


	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add(new String("abc"));
		set.add(new String("abc")); //����. String Ŭ������ �ߺ� ����.
		set.add(new Person("ȫ�浿",10));
		set.add(new Person("ȫ�浿",10));
		System.out.println(set);
	}
}
