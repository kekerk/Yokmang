package chap5;

/*
 *  if ���� ����
 *  if(���ǹ�) {
 *   ���๮1 => ���ǹ��� ����� ���� ��� ���� �Ǵ� �κ�
 *   	   => ����Ǵ� ������ 1���� ��� {} ������ �����ϴ�.
 *  } else if(���ǹ�) {
 *   ���๮2 => else if(���ǹ�)�� ��������� ��� ���� �Ǵ� �κ�  
 *  }else {
 *   ���๮3 => ���ǹ��� ����� ������ ��� ����Ǵ� �κ� 
 *  }
 * 
 */
import java.util.Scanner;

public class IfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		/*
		 * if(score>=60) { System.out.println("�հ��� �����մϴ�."); } else
		 * System.out.println("�ʴ� ���հ��̴�.");
		 */
		String grade = null;

		if (score >= 90) {
			if (score >= 95)
				grade = "A+";
			else
				grade = "A0";
			// System.out.println("A ����");
		} else if (score >= 80) {
			if (score >= 85)
				grade = "B+";
			else
				grade = "B0";
			// System.out.println("B ����");
		} else if (score >= 70) {
			if (score >= 75)
				grade = "C+";
			else
				grade = "C0";
			// System.out.println("C ����");
		} else if (score >= 60) {
			if (score >= 65)
				grade = "D+";
			else
				grade = "D0";
			// System.out.println("D ����");
		} else {
			grade = "F";
			// System.out.println("F ����");
		}
		System.out.println("����� ������ " + grade);

	}

}
