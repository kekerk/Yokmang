package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam1_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count;
		//Ȧ���� �Է¹޴� while�� , Ȧ������ �ƴϸ� �ٽ� �Է�. Ȧ������ �ɶ����� �Է�
		while(true) {
		System.out.println("�Է��� ������ ������ Ȧ������ �Է��Ͻÿ�.");
		count = scan.nextInt();
		if(count%2==0) continue;
		else break;
		}
		//�� �Է� �� 
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0;i<count;i++) {
			int input = scan.nextInt();
			sum+= input;
			list.add(input);
		}
		//
		Collections.sort(list);
		
		System.out.println("��հ�:"+(double)sum/count);
		System.out.println("�߰���:"+list.get(count/2));
		System.out.println("�ִ밪:"+Collections.max(list));
		System.out.println("�ּҰ�:"+Collections.min(list));
	}
}
