package chap6;

import java.util.Scanner;

/*
 * 삼각형의 높이를 입력받아 *로 삼각형 그리기.
 */
public class ArrayEx9 {
	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요");
		Scanner scan=new Scanner(System.in);
		int len = scan.nextInt();
		char[][] tri = new char[len][len];
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
		
		
		//tri 배열을 ' ' 초기화
		
		for(int i=0;i<tri.length;i++) {
			for(int j =0;j<tri[i].length;j++) {
				tri[i][j]=' ';
			}
		}
		System.out.println("삼각형 출력");
		//삼각형 출력
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
