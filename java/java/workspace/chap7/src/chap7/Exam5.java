package chap7;

import java.util.Scanner;

/*
 * Student Ŭ���� ����
 * ������� : �̸�, ��, �й�, ��������, ��������, ��������
 * ����޼��� :
 * 	1. int getTotal() : ����,����,���� ������ ���� ����
 * 	2. float getAverage() : ����,����,���� ������ ����� ����
 *  3. void info() : �Ϲ� ,�� ,�й�, ����, ����, ����, ����, ����� ����ϱ�.
 *  
 *  ������ : 
 *    1. �Ű����� (�̸�, �� , �й�)
 *    	�̸� , �� �й��� �ʱ�ȭ�ϰ� , ������ 0���� �ʱ�ȭ
 *    2. �Ű����� ( �̸� ,�� �й�, ����, ���� ,����)
 *    		�̸�,��,�й� ������ �ʱ�ȭ
 */
class Student {
	String name;
	int van;
	int no;
	int kscore;
	int escore;
	int mscore;
	
	Student( String a, int b, int c){  //������  : �ν��Ͻ� ���� �ʱ�ȭ
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
		System.out.println("�̸�: "+name + " ��: "+ van + " �й�: "+ no + " ��������: "+kscore+" ��������: "+escore+" ��������: "+mscore+" ����: "+getTotal()+" ���: "+getAverage());
	}

}
public class Exam5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �Է��ϼ���");
		int c = scan.nextInt();
		System.out.println("�й��� �Է��ϼ���");
		int n = scan.nextInt();
		System.out.println("���������� �Է��ϼ���");
		int k = scan.nextInt();
		System.out.println("���������� �Է��ϼ���");
		int e = scan.nextInt();
		System.out.println("���������� �Է��ϼ���");
		int m = scan.nextInt();
		
		Student stu1= new Student("ȫ�浿",2,1234567);
		Student stu2= new Student("��âȯ",c,n,k,e,m);
		
		stu1.info();
		stu2.info();
		
		

	}

}
