package chap8;

import java.util.Scanner;

/*
 * �������� ���Ƹ��� �� ������, �� �ٸ����� ���� ���� ������� ����ϴ� ���α׷�.
 * 
 */
public class Qteach0810 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int acnt, lcnt;
		////////////////////////////////////////////
		while(true) {
			System.out.println("�������� ���Ƹ��� �� �Է�");
			acnt = scan.nextInt();
			System.out.println("�������� ���Ƹ��� �ٸ��� �� �Է�");
			lcnt = scan.nextInt();
			
			if((acnt>1000)||(lcnt>4000)) {
				System.out.println("INPUT ERROR");
				continue;
			}
			if((acnt==0)||(lcnt==0)) {
				System.out.println("�Է��� �����մϴ�.");
				break;
			}
			//////////////////////////////////////////
			boolean search = false;
			for(int x=0;x<=acnt;x++) {
				for(int y=0;y<=acnt;y++) {
					if((x+y==acnt)&&((4*x)+(2*y)==lcnt)) {
						System.out.println("������: "+x+"����, ���Ƹ�: "+y+"����");
						search = true;
					}
				}
			}
			if(!search) {
				System.out.println(0);
			}
		}
	}

}
