package chap6;
///////////진수 변경 코딩
import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		char hex[] = new char[32];
		System.out.println("16진수로 변경할 10진수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		char data[] = {'0','1','2','3','4','5','6','7','8','9','A','B','X','D','E','F'};
		
		int divnum = num; 
		int index = 0;
		while(divnum!=0) {
			
			
			hex[index++]=data[divnum%16]; //나눈 나머지의 값을 data에서 꺼내와야한다.
			divnum/=16;			   // 
			
		}
		System.out.print(num+"의 16진수:");
		for(int i= index -1; i>=0;i--) {
			System.out.print(hex[i]);
		}
			System.out.println();

	}

}
