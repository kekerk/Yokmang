package chap18;

import java.util.Arrays;
import java.util.List;

/*
 * filter() �޼��� :  ���ǿ� �´� ��Ҹ� ��Ʈ������ �����ϱ�.
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
		List<Member2> list = Arrays.asList(new Member2("ȫ�浿",Member2.MALE,30),
				new Member2("�質��",Member2.FEMALE,20),
				new Member2("���",Member2.MALE,35),
				new Member2("������",Member2.FEMALE,15)
				);
		
		double ageAvg = list.stream().filter(m -> m.getGender() == Member2.MALE).mapToInt(Member2 :: getAge).average().getAsDouble();
		System.out.println("���� ��� ����: " + ageAvg);
		ageAvg = list.stream().filter(m -> m.getGender() == Member2.FEMALE).mapToInt(Member2 :: getAge).average().getAsDouble();
		System.out.println("���� ��� ����: " + ageAvg);
		System.out.println("30�� �̻��� ����� �̸� ����ϱ�");
		// forEach( s -> ... ) ���� s�� String Ÿ��. map(Member2 :: getName)���� getName�� ������Ƿ� �ش�Ǵ� ���� Ÿ�Ե��� String
//		list.stream().filter(m-> m.getAge() >= 30 ).forEach( m -> System.out.println(m.getName()));
		list.stream().filter(m-> m.getAge() >= 30 ).map(Member2 :: getName).forEach( s -> System.out.println(s));
//		list.stream().filter(m -> m.getAge() >= 30).map(Member2 :: getName).forEach(System.out :: println);
		// 
		System.out.println("���� Member�� �̸��� ���� ����ϱ�.");
		list.stream().filter(m -> m.getGender() == Member2.FEMALE).forEach( s -> System.out.println(s.getName()+":"+s.getAge()));
		
		

	}
}
