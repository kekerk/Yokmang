package chap14;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * TreeSet 예제 : MyClass를 정렬하기.
 * 				TreeSet 객체에 추가될 MyClass는 반드시 Comparable 인터페이스를 구현해야함.
 * 				내부적으로 Comparator의 Comparable이 동작하기때문에 인터페이스를 implements 시켜줘야 한다.
 * 
 *내부적으로 Comparator의 기능이 동작 한다.
 */
class Phone implements Comparable{
	String name;
	int number;
	public Phone(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", number=" + number + "]";
	}
	
	
// 클래스에 Comparable을 구현시키고. compareTo 기능을 오버라이딩.
	//Phone 클래스의 기본정렬방식은 이름의 오름차순으로 지정함.
	@Override
	public int compareTo(Object o) {
		Phone p = (Phone) o;
		return name.compareTo(p.name);
		
	}
	
}
//Phone이 Comparable로 형변환이 안됨.
public class SetEx4 {
	public static void main(String[] args) {
		TreeSet<Phone> set = new TreeSet<Phone>();
		set.add(new Phone("홍길동",1234));
		set.add(new Phone("김삿갓",3456));
		set.add(new Phone("이몽룡",5678));
		System.out.println("이름의 오름차순으로 정렬");
		System.out.println(set);
		for(Phone p : set) {
			System.out.println(p);
		}
		
		System.out.println("전화번호의 오름차순으로 정렬");
		set = new TreeSet<Phone>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Phone p1 = (Phone)o1;
				Phone p2 = (Phone)o2;
				//결과값이 음수 : o1이 앞으로 옴.
				//결과값이 양수 : o2가 앞으로 옴.
				return p1.number - p2.number;
			}
		});
		set.add(new Phone("홍길동",1234));
		set.add(new Phone("김삿갓",3456));
		set.add(new Phone("이몽룡",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
		System.out.println("이름의 내림차순으로 정렬");
		set = new TreeSet<Phone>(new NameDesc());
		set.add(new Phone("홍길동",1234));
		set.add(new Phone("김삿갓",3456));
		set.add(new Phone("이몽룡",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
		System.out.println("전화번호의 내림차순으로 정렬");
		set = new TreeSet<Phone>(new NumberDesc());
		set.add(new Phone("홍길동",1234));
		set.add(new Phone("김삿갓",3456));
		set.add(new Phone("이몽룡",5678));
		for(Phone s : set) {
			System.out.println(s);
		}
	}
}


class NameDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Phone p1 = (Phone) o1;
		Phone p2 = (Phone) o2;
//		return p1.compareTo(p2)*(-1);
		return p2.compareTo(p1);
	}
	
}
//정수형 오름차순 정렬 : p1.정수변수 - p2.정수변수
class NumberDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Phone p1 = (Phone) o1;
		Phone p2 = (Phone) o2;
		return (p1.number - p2.number)*(-1);
//		return p2.number-p1.number;
	}
	
}
