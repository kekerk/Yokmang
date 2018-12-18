package chap18;

import java.util.function.Predicate;

/*
 * Predicate 인터페이스
 * 매개변수 존재, 리턴타입 boolean
 * 
 */
public class LambdaEx10 {
	private static student[] list = { new student("홍길동", 50, 60), new student("이몽룡", 95, 90),
			new student("김삿갓", 75, 80), new student("임꺽정", 65, 70) };

	public static void main(String[] args) {
		System.out.print("영어점수가 60점 이상인 학생의 영어 평균:");
//		double engAvg = avg(t -> t.getEng() >= 60);
		//위의 형태와 다른 형태.
		Predicate<student> p =(t) -> {
			if(t.getEng() >= 60) return true;
			else return false;
		};
		double engAvg = avg1(p);
		System.out.println(engAvg);
		System.out.print("수학점수가 60점 이상인 학생의 수학 평균:");
		System.out.println(avg2(t-> t.getMath() >= 60));
		
		System.out.print("이몽룡 학생의 점수 총점과 평균:");
		System.out.printf("%d,%.2f\n",tot(t->t.getName().equals("이몽룡")),avg3(t->t.getName().equals("이몽룡")));
		
		p = (t) ->  t.getName().equals("홍길동") ; //람다식 정리.
		System.out.print("홍길동 학생의 점수 총점과 평균:");
		System.out.printf("%d,%.2f\n",tot(p),avg3(p));
	}
	

	private static int tot(Predicate<student> p) {
		int sum = 0;
		for(student s: list) {
			if(p.test(s)) {
				sum = s.getEng()+s.getMath();
			}
		}
		return sum;
	}

	private static double avg1(Predicate<student> p) {
		int count = 0, sum = 0;
		for (student s : list) { //이몽룡, 95
			if (p.test(s)) { //true면 실행. 아니면 실행 안함.
				count++;
				sum += s.getEng();
			}
		}
		return (double) sum / count;
	}
	
	private static double avg2(Predicate<student> p) {
		int count = 0, sum = 0;
		for (student s : list) { //이몽룡, 95
			if (p.test(s)) { //true면 실행. 아니면 실행 안함.
				count++;
				sum += s.getMath();
			}
		}
		return (double) sum / count;
	}
	
	private static double avg3(Predicate<student> p) {
		return tot(p)/2.0;
	}
	
}