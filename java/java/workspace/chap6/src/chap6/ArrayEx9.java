package chap6;

import java.util.Scanner;

/*
 * �ﰢ���� ���̸� �Է¹޾� *�� �ﰢ�� �׸���.
 */
public class ArrayEx9 {
	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���");
		Scanner scan=new Scanner(System.in);
		int len = scan.nextInt();
		char[][] tri = new char[len][len];
		//���ﰢ�� ���
		for(int i=tri.length-1;i>=0;i--){
			for(int j=0;j<=i;j++) {
				tri[i][j] = '*';
			}
		}
		for(int i=tri.length-1;i>=0;i--) {
			for(int j=0; j<=i;j++) {
				System.out.print(tri[i][j]);
			}
			System.out.println();
		}
		
		
		//tri �迭�� ' ' �ʱ�ȭ
		
		for(int i=0;i<tri.length;i++) {
			for(int j =0;j<tri[i].length;j++) {
				tri[i][j]=' ';
			}
		}
		System.out.println("�ﰢ�� ���");
		//�ﰢ�� ���
		for(int i=0;i<len;i++) {
			for(int j=0;j<=i;j++) {
				tri[i][j]='*';
			}
		}
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(tri[i][j]);
			}
			System.out.println();
			
		}
	}

}
