package chap18;

import java.util.function.Function;

/*
 *  andThen() : 함수적인터페이스의 디폴트 메서드
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
		// Function<Member, Address> f1 : Member는 매개변수. Address는 리턴값.
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
		
		Member m = new Member("홍길동","hongkd",new Address("한국","서울"));
		city = f3.apply(m);
		System.out.println("거주 도시: " + city);
		
		f2 = (a) -> a.getCountry();
		f3 = f1.andThen(f2);
		System.out.println("국적:" + f3.apply(m));
		
///////////////////////////////////////////////////////		
		f3 = f2.compose(f1);
		System.out.println("국적:" + f3.apply(m));
		f2 = (a) -> a.getCity();
		f3 = f2.compose(f1);
		System.out.println("거주도시: "+ f3.apply(m));
		
	}
}
