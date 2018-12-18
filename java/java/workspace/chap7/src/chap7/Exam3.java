package chap7;

/*
 * 직사각형 클래스 구현하기.
 * Rectangle 클래스
 *  멤버변수: width, height, serialNo, static int sno
 *  멤버메서드 : void area() ,void length()
 *  
 *  구동 클래스 
 *    사각형 객체를 생성하기. 3개  : 배열 이용하기.
 *    1번 사각형은 가로  10 세로 10
 *    2번 사각형은 가로  5 세로 20
 *    3번 사각형은 가로 15 세로 2
 *    
 *    3개의 사각형 각각의 넓이 둘레 구하기.
 *    
 */
class rectangle {
	int width;
	int height;
	int serialNo;
	static int sno;

	void area() {
		System.out.println("가로가 " + width + "이고 세로가 " + height + "인 사각형의 넓이는 " + (width * height));
	}

	void length() {
		System.out.println("가로가 " + width + "이고 세로가 " + height + "인 사각형의 둘레는 " + (2 * (width + height)));
	}

	boolean IsSquare() {
		return width == height;
	}

}

public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = (int)((Math.random()*9)+1);
		rectangle[] a = new rectangle[3];

		for (int i = 0; i < a.length; i++) {
			a[i] = new rectangle();
		}

		a[0].width = 10;
		a[0].height = 10;
		a[0].serialNo = ++rectangle.sno;
		System.out.println(a[0].serialNo + "번 사각형");
		a[0].area();
		a[0].length();
		System.out.println();
		a[1].width = 5;
		a[1].height = 20;
		a[1].serialNo = ++rectangle.sno;
		System.out.println(a[1].serialNo + "번 사각형");
		a[1].area();
		a[1].length();
		System.out.println();
		a[2].width = 15;
		a[2].height = 2;
		a[2].serialNo = ++rectangle.sno;
		System.out.println(a[2].serialNo + "번 사각형");
		a[2].area();
		a[2].length();
		System.out.println();

	}

}
