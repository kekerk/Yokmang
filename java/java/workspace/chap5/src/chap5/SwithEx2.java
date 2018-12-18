package chap5;

public class SwithEx2 {

	public static void main(String[] args) {
		/*
		 * Math.random() : 난수(임의의수)발생기 ---->> 지정 불가. 당첨 기능 등 0 <= Math.random() < 1.0 0
		 * <= Math.random()*10 < 10.0 0 <= (int)(Math.random()*10) <= 9 1 <=
		 * (int)(Math.random()*10)+1 <= 10------------------> 1 <= num <= 10
		 */
		int num = (int) (Math.random() * 10) + 1; // 랜덤수 자동 입력??
		switch (num) {
		case 1:
			System.out.println("자전거 당첨");
			break;
		case 2:
			System.out.println("인라인 당첨");
			break;
		case 3:
			System.out.println("USB 당첨");
			break;
		default:
			System.out.println("다음기회에....");
			break; // 70퍼센트의 확률
		}
		// TODO Auto-generated method stub

		// 모든 switch 구문은 if 조건절로 변경 가능
		// 모든 if 구문운 switch 구문으로 변결할 수 없다.

		if (num == 1)
			System.out.println("자전거 당첨");
		else if (num == 2)
			System.out.println("인라인 당첨");
		else if (num == 3)
			System.out.println("USB 당첨");
		else
			System.out.println("다음기회에....");

	}

}
