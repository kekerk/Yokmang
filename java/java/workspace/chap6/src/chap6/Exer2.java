package chap6;

import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) {
		System.out.println("삼각형의 홀수인 높이와 출력번호를 입력하세요");
		Scanner scan=new Scanner(System.in);
		int len = scan.nextInt();
		int num = scan.nextInt();
		int max = (len*2) -1 ;
		char[][] tri = new char[len][len];
		char[][] trix = new char[len][max];
		switch(num) {
		
		case 1:
		// 삼각형 출력
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
		//역삼각형 출력	
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
		//이등변삼각형 출력  trix 배열 사용
			for(int i=0;i<trix.length;i++) { //len = 5; [5][9]   max=9   [0 1 2 3 4 5 6 7 8]
				for(int j=0;j<trix[i].length;j++) {
					if(j>=(max/2)-i && j<=(max/2)+i) {  // i = 0일 때, j는 max/2(4)의 위치에 *
					trix[i][j]='*';						// i = 1일 때, j는 max/2-1(3) 부터 max/2+1(5) 까지 *
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
