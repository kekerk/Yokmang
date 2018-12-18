package chap7;

// 사각형 넓이 , 둘레 구하기.
// 사각형 개수는 배열 사용.

public class Exam3_1 {
	public static void main(String[] args) {
		rectangle[] R = new rectangle[3];
		for (int i = 0; i < R.length; i++) {
			R[i] = new rectangle();
			R[i].serialNo = ++rectangle.sno;
			switch (R[i].serialNo) {
			case 1:
				
				R[i].width = 10;
				R[i].height = 10;
				break;

			case 2:
				R[i].width = 5;
				R[i].height = 20;
				break;

			case 3:
				R[i].width = 15;
				R[i].height = 2;
				break;
			}
			System.out.println(R[i].serialNo + "번 사각형");
			R[i].area();
			R[i].length();
			if((R[i]).IsSquare()) {
				System.out.println(R[i].serialNo + "번 사각형은 정사각형");
			}
			else {
				System.out.println(R[i].serialNo + "번 사각형은 직사각형");
			}

		}
		System.out.println();

	}

}
