package chap4;

import java.util.Scanner;

/*한박스에 10개
 * 10개 미만의 갯수도 1박스 포장.
 */
public class Exam8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("오렌지 갯수");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		
		int b = a/10 ; 
		int d = a%10 ;
		int c = (a>(a/10)*10)? b+1 : b ;
		// int b = a/10 + ((a%10==0)?0:1);
		// System.out.println("오렌지 "+ a +"개를 담는데 필요한 박스 수는 "+b+"박스입니다.")
		System.out.println("나머지 개수: "+d);
		System.out.println("오렌지 "+ a +"개를 담는데 필요한 박스 수는 "+c+"박스입니다.");
	}

}
