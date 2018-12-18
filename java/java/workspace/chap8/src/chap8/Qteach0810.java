package chap8;

import java.util.Scanner;

/*
 * 강아지와 병아리의 총 마리수, 총 다리수를 보고 각각 몇마리인지 계산하는 프로그램.
 * 
 */
public class Qteach0810 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int acnt, lcnt;
		////////////////////////////////////////////
		while(true) {
			System.out.println("강아지와 병아리의 합 입력");
			acnt = scan.nextInt();
			System.out.println("강아지와 병아리의 다리의 합 입력");
			lcnt = scan.nextInt();
			
			if((acnt>1000)||(lcnt>4000)) {
				System.out.println("INPUT ERROR");
				continue;
			}
			if((acnt==0)||(lcnt==0)) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			//////////////////////////////////////////
			boolean search = false;
			for(int x=0;x<=acnt;x++) {
				for(int y=0;y<=acnt;y++) {
					if((x+y==acnt)&&((4*x)+(2*y)==lcnt)) {
						System.out.println("강아지: "+x+"마리, 병아리: "+y+"마리");
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
