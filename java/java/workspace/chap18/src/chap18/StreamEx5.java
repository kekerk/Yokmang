package chap18;

import java.util.Arrays;
import java.util.List;

/*
 * filter() 메서드 :  조건에 맞는 요소만 스트림으로 변경하기.
 */
class Member2 implements Comparable{
	public static final int MALE =0 ;
	public static final int FEMALE = 1;
	private String name;
	private int gender;
	private int age;
	public Member2(String name, int gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}

	public int compareTo(Member2 o) {
		
		return name.compareTo(o.name);
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
public class StreamEx5 {
	public static void main(String[] args) {
		List<Member2> list = Arrays.asList(new Member2("홍길동",Member2.MALE,30),
				new Member2("김나리",Member2.FEMALE,20),
				new Member2("김삿갓",Member2.MALE,35),
				new Member2("성춘향",Member2.FEMALE,15)
				);
		
		double ageAvg = list.stream().filter(m -> m.getGender() == Member2.MALE).mapToInt(Member2 :: getAge).average().getAsDouble();
		System.out.println("남자 평균 나이: " + ageAvg);
		ageAvg = list.stream().filter(m -> m.getGender() == Member2.FEMALE).mapToInt(Member2 :: getAge).average().getAsDouble();
		System.out.println("여자 평균 나이: " + ageAvg);
		System.out.println("30살 이상인 사람의 이름 출력하기");
		// forEach( s -> ... ) 에서 s는 String 타입. map(Member2 :: getName)에서 getName을 찍었으므로 해당되는 값의 타입들이 String
//		list.stream().filter(m-> m.getAge() >= 30 ).forEach( m -> System.out.println(m.getName()));
		list.stream().filter(m-> m.getAge() >= 30 ).map(Member2 :: getName).forEach( s -> System.out.println(s));
//		list.stream().filter(m -> m.getAge() >= 30).map(Member2 :: getName).forEach(System.out :: println);
		// 
		System.out.println("여자 Member의 이름과 나이 출력하기.");
		list.stream().filter(m -> m.getGender() == Member2.FEMALE).forEach( s -> System.out.println(s.getName()+":"+s.getAge()));
		
		

	}
}
