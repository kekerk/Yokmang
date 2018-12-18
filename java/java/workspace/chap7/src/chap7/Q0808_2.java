package chap7;

class Circle2 {
	int r, x, y, no;
	static int count;

	Circle2(int r, int x, int y) {
		this.r = r;
		this.x = x;
		this.y = y;
		this.no = ++Circle2.count;  //this가 붙지 않아도 된다.
	}

	Circle2() {
		this(1, 1, 1);
	}

	Circle2(int r) {
		this(r, 1, 1);
	}

	double area() {
		return (Math.PI * r * r);
	}

	double length() {
		return Math.PI * 2 * r;
	}

	public String toString() {
		return "반지름" + r + "인 " + no + "번째 원의 원점 좌표는 (" + x + "," + y + ") 이고 원의 넓이는 " + area() + ", 원의 둘레는 " + length()
				+ "입니다.";
	}
}

public class Q0808_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle2 c1 = new Circle2();  // new가 객체 생성 및 호출을 하고 매개변수 없는 Circle2() 생성자 호출
//		c1.no = ++Circle2.count;
		Circle2 c2 = new Circle2(50);
//		c2.no = ++Circle2.count;
		Circle2 c3 = new Circle2(100, 10, 20);
//		c3.no = ++Circle2.count;
		System.out.println(c1);

		System.out.println(c2);

		System.out.println(c3);
	}

}
