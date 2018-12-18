package chap8;

import java.util.Date;

/*
 * 직원 클래스  Employee
 * 1. 변수
 * 		직원구분, 이름, 소속부서
 * 2. 메서드
 *     getPay() {}
 *  정규직원과 비정규직원으로 나눈다.
 *  
 *  정규직원클래스(FormalEmployee)
 *  1. 변수
 *  	직원번호, 직급, 연봉
 *  2. 메서드 
 *    getPay() {} : 연봉/12 의 급여를 받는다.
 * 비정규직원클래스(InFormalEmplyee)
 *  1. 변수
 *  	계약 만료일, 기본임금
 *  2. 메서드 
 *    getPay() {} : 기본임금
 */

class Employee {
	String name;
	String dept;
	String type;

	
	int getPay() {
		return 0;
	}
	@Override
	public String toString() {
		return "이름: "+name + ",부서: "+dept+",직원구분: "+type;
	}

}

class FormalEmployee extends Employee {
	int number;
	int yearpay;
	String position;
	
	FormalEmployee(int number,int yearpay,String position){
		this.number = number;
		this.yearpay = yearpay;
		this.position = position;
	}
	@Override // 어노테이션 : 메서드의 오버라이딩 여부 검증
	int getPay() {

		return yearpay / 12;

	}
	public String toString() {
		return "직원번호: "+number + ",직급: "+position+",연봉: "+yearpay+",월급: "+getPay();
	}

}

class InFormalEmployee extends Employee {

	String expireDate; // java.util
	int pay; // 기본임금
	InFormalEmployee(String expireDate, int pay){
		this.expireDate = expireDate;
		this.pay = pay;
	}
	@Override // 어노테이션 : 메서드의 오버라이딩 여부 검증
	int getPay() {
		return pay;
	}
	
	public String toString() {
		return "계약만료일: "+expireDate + ",임금: "+getPay();
	}

}

public class Exam2 {

	public static void main(String[] args) {
		
		FormalEmployee fm = new FormalEmployee(1,2400,"팀장");
		InFormalEmployee ifm = new InFormalEmployee("2022/09/21", 180);
		System.out.println(fm);
		System.out.println(ifm);
	}
}
