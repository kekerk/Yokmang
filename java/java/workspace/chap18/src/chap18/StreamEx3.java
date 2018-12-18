package chap18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student2 implements Comparable<Student2> { //정렬하기위해 Comparable 인터페이스 구현받고 compareTo() 오버라이딩. 
	private String name;
	private int score;

	public Student2(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	// 이름순으로 정렬.
	@Override
	public int compareTo(Student2 s) {
		
//		return (name.compareTo(s.name))*(-1);
		return (name.compareTo(s.name));
	}
	
	
	// 성적의 오름차순 정렬하도록 기본설정하기.
//	@Override
//	public int compareTo(Student2 s) {
//		
//		return score - s.score;
//	}
	

}
public class StreamEx3 {
	public static void main(String[] args) {
		List<Student2> list = Arrays.asList(new Student2("홍길동", 90), new Student2("김삿갓", 80), new Student2("이몽룡", 100));

		int tot = list.stream().mapToInt(Student2::getScore).sum();
		long count = list.stream().mapToInt(Student2::getScore).count();
		double avg = list.stream().mapToInt(Student2::getScore).average().getAsDouble();
		System.out.println("인원수 :" + count);
		System.out.println("총합 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println();
		list.stream().forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
		System.out.println();
		// 오름차순 정렬하여 출력하기 -- sorted()에서 에러가 남. comparable(인터페이스) 구현해야함.
		// 1. Comparable 구현클래스의 객체만 정렬이 가능.
		// 2. 
		list.stream().sorted().forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
		// 이름 내림차순.
		System.out.println();
		list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
	}
}
