package chap6;

import java.util.Scanner;

//Ű����κ��� 1���� 9������ ���� �Է¹�� �迭 answer�� �����ϰ� �����͸� �о� �� ������ ������ŭ *�� ��� ���α׷��� �ۼ�
public class Q2 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("���� 10���� �Է��Ͻÿ�.");
		//�迭 ���� ����
		int[] score = new int[10];
		int[] t =new int[10];
		for (int i = 0; i < score.length; i++) {	//���ھ� �迭�� ���� 10�� �Է�.
//			
				// 1<=a<=10
				int a=(int)(Math.random()*9 +1);
				
				t[i] =  a;
				
		}
		
		//'*' ����ϱ�		
//		for(int i : t) {
//			System.out.print(i);
//			System.out.print(":");
//			for(int j=1;j<=i;j++) {
//				
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		for(int i=0;i<t.length;i++) {
		System.out.print(t[i]);
		System.out.print(":");
		for(int j=1;j<=t[i];j++) {
			
			System.out.print("*");
		}
		System.out.println();
	}
	}

}
