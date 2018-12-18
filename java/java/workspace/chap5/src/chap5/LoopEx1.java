package chap5;

public class LoopEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(1);// print : 옆으로 찍힘
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5); // println : 다음 줄에 찍힘
		System.out.println("for문으로 1~5 출력");

		int i = 0;
		for (i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("i=" + i);

		System.out.println("\n while문으로 1~5출력");
		int l = 1;
		while (l <= 5) { // 조건식이 참일 시 실행문이 진행되고, 거짓일 시 루프 탈출
			System.out.println(l);
			l++;
		}
		System.out.println("l=" + l);

		System.out.println("\n do while문으로 1~5 출력");
		int s = 1;
		do { // do while문은 while(조건문) 끝낼 때 세미콜론으로 마무리 해야한다.(;)
			System.out.println(s);
			s++;
		} while (s <= 5); // 실행문이 먼저 진행되고 조건문에서 참일 시 다시 반복, 거짓일 시 루프 탈출 (무조건 한번은 실행됨)
		System.out.println("s=" + s);
	}

}
