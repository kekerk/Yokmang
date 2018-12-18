package chap18;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/*
 * Function interface : �Ű�����, ����Ÿ���� �ִ� �Լ� ��ü.
 * 						function<�Ű�������, ����Ÿ��>
 * 						ToIntFunction<�Ű�������> : ����Ÿ���� int ��
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
			new student("ȫ�浿",80,90),
			new student("���",85,90),
			new student("�̸���",80,70)
			
	};
	//�Լ� ��ü�� �Ű������� ��.
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
		// ToIntFunction<student> : �Ű����� Ÿ���� student
		//							����Ÿ�� : int
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
		// t�� getName(),getEng(),getMath()�� �� �� ����.
		System.out.print("�л��̸�:");
		printString(t-> t.getName());
		System.out.println();
		System.out.print("��������:");
		printInt(t->t.getEng());
		System.out.println();
		System.out.print("��������:");
		printInt(t->t.getMath());
		
		System.out.println("�������� �հ�:");
		printTot(t->t.getEng());
		System.out.println("�������� �հ�:");
		printTot(t->t.getMath());
		System.out.println("�������� ���:");
		printAvg(t->t.getEng());
		System.out.println("�������� ���:");
		printAvg(t->t.getMath());
	}
}
