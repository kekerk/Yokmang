package chap14;
/*
 * Set 객체의 중복 여부 판단.
 * 	equals(Object) : 결과가 true 이고
 *  hashcode()     : 결과값이 두개의 객체가 같은 경우
 *  => 중복객체로 인식함.
 *  
 *  중복을 없애려면 equals와 hashcode() 를 오버라이딩해야함. 둘 다 오버라이딩.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Person{ //Person 객체가 오버라이딩 했으니 
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
		if(obj instanceof Person) { //내가 만들었으니 나의 객체 안에서 작용.
			Person p = (Person) obj;
			return name.equals(p.name)&&age==p.age;
		} else {
			return false;
		}
		
}


	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add(new String("abc"));
		set.add(new String("abc")); //실패. String 클래스는 중복 인지.
		set.add(new Person("홍길동",10));
		set.add(new Person("홍길동",10));
		System.out.println(set);
	}
}
