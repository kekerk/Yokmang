package chap8;

import java.util.Date;

/*
 * ���� Ŭ����  Employee
 * 1. ����
 * 		��������, �̸�, �ҼӺμ�
 * 2. �޼���
 *     getPay() {}
 *  ���������� �������������� ������.
 *  
 *  ��������Ŭ����(FormalEmployee)
 *  1. ����
 *  	������ȣ, ����, ����
 *  2. �޼��� 
 *    getPay() {} : ����/12 �� �޿��� �޴´�.
 * ����������Ŭ����(InFormalEmplyee)
 *  1. ����
 *  	��� ������, �⺻�ӱ�
 *  2. �޼��� 
 *    getPay() {} : �⺻�ӱ�
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
		return "�̸�: "+name + ",�μ�: "+dept+",��������: "+type;
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
	@Override // ������̼� : �޼����� �������̵� ���� ����
	int getPay() {

		return yearpay / 12;

	}
	public String toString() {
		return "������ȣ: "+number + ",����: "+position+",����: "+yearpay+",����: "+getPay();
	}

}

class InFormalEmployee extends Employee {

	String expireDate; // java.util
	int pay; // �⺻�ӱ�
	InFormalEmployee(String expireDate, int pay){
		this.expireDate = expireDate;
		this.pay = pay;
	}
	@Override // ������̼� : �޼����� �������̵� ���� ����
	int getPay() {
		return pay;
	}
	
	public String toString() {
		return "��ุ����: "+expireDate + ",�ӱ�: "+getPay();
	}

}

public class Exam2 {

	public static void main(String[] args) {
		
		FormalEmployee fm = new FormalEmployee(1,2400,"����");
		InFormalEmployee ifm = new InFormalEmployee("2022/09/21", 180);
		System.out.println(fm);
		System.out.println(ifm);
	}
}
