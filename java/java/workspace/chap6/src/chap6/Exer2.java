package chap6;

import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) {
		System.out.println("�ﰢ���� Ȧ���� ���̿� ��¹�ȣ�� �Է��ϼ���");
		Scanner scan=new Scanner(System.in);
		int len = scan.nextInt();
		int num = scan.nextInt();
		int max = (len*2) -1 ;
		char[][] tri = new char[len][len];
		char[][] trix = new char[len][max];
		switch(num) {
		
		case 1:
		// �ﰢ�� ���
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
			break;
			
		case 2:
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
			break;
		case 3:
		//�̵�ﰢ�� ���  trix �迭 ���
			for(int i=0;i<trix.length;i++) { //len = 5; [5][9]   max=9   [0 1 2 3 4 5 6 7 8]
				for(int j=0;j<trix[i].length;j++) {
					if(j>=(max/2)-i && j<=(max/2)+i) {  // i = 0�� ��, j�� max/2(4)�� ��ġ�� *
					trix[i][j]='*';						// i = 1�� ��, j�� max/2-1(3) ���� max/2+1(5) ���� *
					}
				}
			}
			
			for(int i=0;i<trix.length;i++) {
				for(int j=0;j<trix[i].length;j++) {
					System.out.print(trix[i][j]);
				}
				System.out.println();
				
			}
			break;
			
		
		}
	}

}
