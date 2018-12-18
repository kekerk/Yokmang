package chap18;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 *  Stream 예제 : jdk 8.0 이후 버전에서만 사용 가능.
 *  			내부반복자 역할. 빠른 처리 속도.
 *  			병렬 처리가 가능.
 */
public class StreamEx1 {

	public static void main(String[] args) {
		// List<String> list : String 타입만 모아서 list로
		List<String> list = Arrays.asList("홍길동", "김삿갓", "이몽룡");
		System.out.println("외부 반복자(Iterator)로 조회하기.");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name + " ");
		}
		System.out.println();
		System.out.println("내부 반복자(Stream)로 조회하기.");
		Stream<String> st = list.stream();
		// name : list의 요소들 하나하나를 지목.
		st.forEach(name -> System.out.println(name + " "));
		System.out.println();
		List<student> list2 = Arrays.asList(new student("홍길동", 80, 90), new student("김삿갓", 70, 80),
				new student("이몽룡", 85, 92));
		System.out.println("Stream<student> 이용");
		Stream<student> st2 = list2.stream();
		// s의 타입은 student. s는 student 객체 한개. 요소 객체.
		// .forEach : 한개씩 읽어오는 메서드.
		st2.forEach(s -> {
			String name = s.getName(); // 홍길동
			int sum = s.getEng()+s.getMath(); //점수 합산
			System.out.println(name+" 총점: "+ sum);
		});
		System.out.println();
		//결과가 홍길동,영어,수학,총점,평균
		Stream<student> st3 = list2.stream();
		st3.forEach(s -> {
			String name = s.getName();
			int e = s.getEng();
			int m = s.getMath();
			int sum = s.getEng()+s.getMath();
			double avg = sum/2.0;
			if(s.getName().equals("홍길동")){
			System.out.println(name+" 수학점수: " + m +" 영어점수: "+ e +" 총점: "+ sum + " 평균 : "+avg);
			}
		});
		//부분 스트림으로 생성하기.
		// mapToInt
		System.out.print("학생들의 수학 점수 평균: ");
		//IntStream : mapToInt
		// 정수형 값을 요소로 가지고 있는 Stream
		double avg = list2.stream().mapToInt(student :: getMath).average().getAsDouble();
		System.out.println(avg);
		
		System.out.print("학생들의 영어 점수 평균: ");
		avg = list2.stream().mapToInt(student :: getEng).average().getAsDouble();
		System.out.println(avg);
		
		System.out.print("학생들의 수학 점수 총합: ");
		long sum = list2.stream().mapToInt(student :: getMath).sum();
		System.out.println(sum);
		
		System.out.print("학생들의 영어 점수 총합: ");
		sum = list2.stream().mapToInt(student :: getEng).sum();
		System.out.println(sum);
		
		Stream<student> st4 = list2.stream();
		
	}

}
