package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ȭ�鿡�� �������� �ڿ����� �Է¹޾� �̵� �� Ȧ���� �ڿ������� ��� ��� �� ���� ���ϰ�, Ȧ�� �� �ִ밪�� �ּҰ��� ã�� ���α׷��� �ۼ��ϱ�.
 */
public class Exam3 {

	public static void main(String[] args) {
		int sum=0;
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>(); //ArrayList�� Vector�� ����� ����.
		System.out.println("�Է¹��� �ڿ����� ������ �����Ͻÿ�.");
		int num = scan.nextInt();
		System.out.println(num+"���� ���ڸ� �Է��Ͻÿ�.");
		for (int i = 0; i < num; i++) {
			int score = scan.nextInt();
			if (score % 2 != 0) {
				list.add(score);
				sum+=score;
			}

		}
		System.out.println("�Էµ� Ȧ��: "+list);
		
		System.out.println("Ȧ���� ���� ��: "+sum);
		
		//����Ʈ ������� ������.
//		Collections.sort(list);
		
		System.out.println("Ȧ���� ���� �� �ִ밪: "+Collections.max(list));
		System.out.println("Ȧ���� ���� �� �ִ밪�� �ε���: "+list.indexOf(Collections.max(list)));
		System.out.println("Ȧ���� ���� �� �ּҰ�: "+Collections.min(list));
		System.out.println("Ȧ���� ���� �� �ּҰ��� �ε���: "+list.indexOf(Collections.min(list)));
	}

}
