package chap6;

import java.util.Scanner;

public class Exam5 {
	public static void main(String[] args) {
		int octal[] = new int[32];
		System.out.println("8������ ������ 10������ �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int divnum = num; 
		int index = 0;
		while(divnum!=0) {
			octal[index++]=divnum%8; //index�� 0�� �����ϰ� ���� ����ǰ� 1�� ī��Ʈ
			divnum/=8;			   // 
			
		}
		System.out.print(num+"�� 8����:");
		for(int i= index -1; i>=0;i--) {
			System.out.print(octal[i]);
		}
			System.out.println();

	}

}
