package chap18;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/*
 * Function interface : 매개변수, 리턴타입이 있는 함수 객체.
 * 						function<매개변수형, 리턴타입>
 * 						ToIntFunction<매개변수형> : 리턴타입이 int 형
 */

class student {
	private String name;
	private int eng;
	private int math;
	public student(String name, int eng, int math) {
		this.name =name;
		this.eng = eng;
		this.math = math;
	}
	public String getName() { return name;}
	public int getEng() { return eng;}
	public int getMath() { return math;}
}
public class LambdaEx8 {
	private static student[] list = {
			new student("홍길동",80,90),
			new student("김삿갓",85,90),
			new student("이몽룡",80,70)
			
	};
	//함수 객체가 매개변수로 들어감.
	public static void printString(Function<student,String> f) {
		for (student s : list) {
			System.out.print(f.apply(s)+" ");
		}
	 System.out.println();
	}
	public static void printInt(Function<student,Integer> f) {
		for (student s : list) {
			System.out.print(f.apply(s)+" ");
		}
	 System.out.println();
	}
	
	public static void printTot(ToIntFunction<student> f) {
		// ToIntFunction<student> : 매개변수 타입은 student
		//							리턴타입 : int
		int sum=0;
		for(student s: list) {
		  	sum+=f.applyAsInt(s);
		}
		System.out.println(sum);
	}
	
	public static void printAvg(ToDoubleFunction<student> f) {
		
		double sum=0;
		int cnt=0;
		for(student s: list) {
		  	sum+=f.applyAsDouble(s);
		  	cnt++;
		}
		
		System.out.printf("%.2f\n",sum/cnt);
	}
	
	public static void main(String[] args) {
		// t의 getName(),getEng(),getMath()를 쓸 수 있음.
		System.out.print("학생이름:");
		printString(t-> t.getName());
		System.out.println();
		System.out.print("영어점수:");
		printInt(t->t.getEng());
		System.out.println();
		System.out.print("수학점수:");
		printInt(t->t.getMath());
		
		System.out.println("영어점수 합계:");
		printTot(t->t.getEng());
		System.out.println("수학점수 합계:");
		printTot(t->t.getMath());
		System.out.println("영어점수 평균:");
		printAvg(t->t.getEng());
		System.out.println("수학점수 평균:");
		printAvg(t->t.getMath());
	}
}
