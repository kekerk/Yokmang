package chap18;

import java.util.function.Function;

/*
 *  andThen() : �Լ����������̽��� ����Ʈ �޼���
 */
class Member {
	private String name;
	private String id;
	private Address addr;
	public Member(String name, String id, Address addr) {
		super();
		this.name = name;
		this.id = id;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public Address getAddr() {
		return addr;
	}
}

class Address {
	private String country;
	private String city;
	public Address(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public String getCity() {
		return city;
	}
	
}
public class LambdaEx11 {
	public static void main(String[] args) {
		// Function<Member, Address> f1 : Member�� �Ű�����. Address�� ���ϰ�.
		Function<Member, Address> f1;
		Function<Address, String> f2;
		Function<Member,  String> f3;
		
		String city;
		
		f1 = (m) -> {
			return m.getAddr();
		};
		f2 = (a) -> {
			return a.getCity();
		};
		f3 = f1.andThen(f2);
		
		
//		f1 = (m) -> m.getAddr();
//		f2 = (a) -> a.getCity();
//		f3 = f1.andThen(f2);
		
		Member m = new Member("ȫ�浿","hongkd",new Address("�ѱ�","����"));
		city = f3.apply(m);
		System.out.println("���� ����: " + city);
		
		f2 = (a) -> a.getCountry();
		f3 = f1.andThen(f2);
		System.out.println("����:" + f3.apply(m));
		
///////////////////////////////////////////////////////		
		f3 = f2.compose(f1);
		System.out.println("����:" + f3.apply(m));
		f2 = (a) -> a.getCity();
		f3 = f2.compose(f1);
		System.out.println("���ֵ���: "+ f3.apply(m));
		
	}
}
