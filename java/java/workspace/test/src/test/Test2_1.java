package test;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("��ǻ�Ͱ� ���Ŵ�"+comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("����(1), ����(2), ��(3) �� �ϰ� �� ����?");
		int num = scan.nextInt();
		switch (num) {
		case 1:
			switch(comn) {
			case 1: System.out.println("���"); break;
			case 2: System.out.println("��ǻ�� �̱�"); break;
			case 3: System.out.println("���� �̱�"); break;
			}
			break;
		case 2:
			switch(comn) {
			case 1: System.out.println("���� �̱�"); break;
			case 2: System.out.println("���"); break;
			case 3: System.out.println("��ǻ�� �̱�"); break;
			}
			break;
			
		case 3:
			switch(comn) {
			case 1: System.out.println("��ǻ�� �̱�"); break;
			case 2: System.out.println("���� �̱�"); break;
			case 3: System.out.println("���"); break;
			}
			break;
			
		}


	}

}
