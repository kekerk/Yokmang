package chap6;

import java.util.Scanner;

/*
 * 10������ 2������ �����ϱ�. 
 */
public class ArrayEx4 {
	public static void main(String[] args) {
	int num[] = new int[32];
	System.out.println("2������ ������ 10������ �Է��ϼ���.");
	Scanner scan = new Scanner(System.in);
	int b = scan.nextInt();
	int divnum = b; 
	int index = 0;
	while(divnum!=0) {
		num[index++]=divnum%2; //index�� 0�� �����ϰ� ���� ����ǰ� 1�� ī��Ʈ
		divnum/=2;			   // 
		
	}
	System.out.print(b+"�� 2����:");
	for(int i= index -1; i>=0;i--) {
		System.out.print(num[i]);
	}
		System.out.println();
	}
}
