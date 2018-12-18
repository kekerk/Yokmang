package chap7;

import java.util.Scanner;

/*
 * Student 클래스 구현
 * 멤버변수 : 이름, 반, 학번, 국어점수, 영어점수, 수학점수
 * 멤버메서드 :
 * 	1. int getTotal() : 국어,영어,수학 점수의 합을 리턴
 * 	2. float getAverage() : 국어,영어,수학 점수의 평균을 리턴
 *  3. void info() : 일므 ,반 ,학번, 국어, 영어, 수학, 총점, 평균을 출력하기.
 *  
 *  생성자 : 
 *    1. 매개변수 (이름, 반 , 학번)
 *    	이름 , 반 학번을 초기화하고 , 점수는 0으로 초기화
 *    2. 매개변수 ( 이름 ,반 학번, 국어, 영어 ,수학)
 *    		이름,반,학번 점수들 초기화
 */
class Student {
	String name;
	int van;
	int no;
	int kscore;
	int escore;
	int mscore;
	
	Student( String a, int b, int c){  //생성자  : 인스턴스 변수 초기화
		name = a;
		van = b;
		no =c;
	
	}
	Student( String a1, int b1, int c1, int k, int e, int m){
		name = a1;
		van = b1;
		no =c1;
		kscore = k;
		escore = e;
		mscore = m;
	}
	
	int getTotal() {
		return kscore + escore + mscore ;
		
	}
	
	float getAverage() {
		return  (getTotal()/3f);
	}
	
	void info() {
		System.out.println("이름: "+name + " 반: "+ van + " 학번: "+ no + " 국어점수: "+kscore+" 영어점수: "+escore+" 수학점수: "+mscore+" 총점: "+getTotal()+" 평균: "+getAverage());
	}

}
public class Exam5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("반을 입력하세요");
		int c = scan.nextInt();
		System.out.println("학번을 입력하세요");
		int n = scan.nextInt();
		System.out.println("국어점수를 입력하세요");
		int k = scan.nextInt();
		System.out.println("영어점수를 입력하세요");
		int e = scan.nextInt();
		System.out.println("수학점수를 입력하세요");
		int m = scan.nextInt();
		
		Student stu1= new Student("홍길동",2,1234567);
		Student stu2= new Student("이창환",c,n,k,e,m);
		
		stu1.info();
		stu2.info();
		
		

	}

}
