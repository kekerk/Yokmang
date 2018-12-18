package chap6;

//두 수의 공약수를 전부 구하는 프로그램
import java.util.Scanner;

public class Exam8 {

	public static void main(String[] args) {

		System.out.println("두개의 수를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		// 두 수중 작은 수를 최소값 선정
		int min = (a < b) ? a : b;
		// 공약수를 집어넣을 배열 선정
		int[] gcd = new int[30]; /// 중요
		int index = 0; /// 중요
		// 한 수를 두 입력된 수와 나누어서 둘다 나머지가 0이 될 경우 그 수를 gcd에 입력
		for (int i = 1; i <= min; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd[index++] = i;
			}
		}
		System.out.print(a + "와 " + b + "의 공약수 : ");
		for (int i = 0; i < index; i++) {
			System.out.print(gcd[i] + ((i == index - 1) ? " " : ",")); // i가 수의 끝에 도달하면 공백, 아니면 쉼표
		}
		System.out.println();
	}

}
