package chap18;

import java.util.function.Predicate;

/*
 * Predicate �������̽�
 * �Ű����� ����, ����Ÿ�� boolean
 * 
 */
public class LambdaEx10 {
	private static student[] list = { new student("ȫ�浿", 50, 60), new student("�̸���", 95, 90),
			new student("���", 75, 80), new student("�Ӳ���", 65, 70) };

	public static void main(String[] args) {
		System.out.print("���������� 60�� �̻��� �л��� ���� ���:");
//		double engAvg = avg(t -> t.getEng() >= 60);
		//���� ���¿� �ٸ� ����.
		Predicate<student> p =(t) -> {
			if(t.getEng() >= 60) return true;
			else return false;
		};
		double engAvg = avg1(p);
		System.out.println(engAvg);
		System.out.print("���������� 60�� �̻��� �л��� ���� ���:");
		System.out.println(avg2(t-> t.getMath() >= 60));
		
		System.out.print("�̸��� �л��� ���� ������ ���:");
		System.out.printf("%d,%.2f\n",tot(t->t.getName().equals("�̸���")),avg3(t->t.getName().equals("�̸���")));
		
		p = (t) ->  t.getName().equals("ȫ�浿") ; //���ٽ� ����.
		System.out.print("ȫ�浿 �л��� ���� ������ ���:");
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
		for (student s : list) { //�̸���, 95
			if (p.test(s)) { //true�� ����. �ƴϸ� ���� ����.
				count++;
				sum += s.getEng();
			}
		}
		return (double) sum / count;
	}
	
	private static double avg2(Predicate<student> p) {
		int count = 0, sum = 0;
		for (student s : list) { //�̸���, 95
			if (p.test(s)) { //true�� ����. �ƴϸ� ���� ����.
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