package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam1_1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int input;
		int count = 0;
		System.out.println("Ȧ������ ���ڸ� �Է��ϼ���");
		while (true) {
			if (count % 2 != 0) {
				System.out.println("���ڸ� �� �Է��Ͻðڽ��ϱ�");
				String yn = scan.next();
				if (!yn.equals("y")) {
					break;
				}
			}
			input = scan.nextInt();
			count++;
			list.add(input);
		}
		System.out.println(list);
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			sum+= list.get(i);
			
		}
		System.out.println("��հ�: "+(double) sum/list.size());
		Collections.sort(list);
		System.out.println(list);
		System.out.println("�߰���: "+list.get(list.size()/2));
	}
}
