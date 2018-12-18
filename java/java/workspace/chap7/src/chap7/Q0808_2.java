package chap7;

class Circle2 {
	int r, x, y, no;
	static int count;

	Circle2(int r, int x, int y) {
		this.r = r;
		this.x = x;
		this.y = y;
		this.no = ++Circle2.count;  //this�� ���� �ʾƵ� �ȴ�.
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
		return "������" + r + "�� " + no + "��° ���� ���� ��ǥ�� (" + x + "," + y + ") �̰� ���� ���̴� " + area() + ", ���� �ѷ��� " + length()
				+ "�Դϴ�.";
	}
}

public class Q0808_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle2 c1 = new Circle2();  // new�� ��ü ���� �� ȣ���� �ϰ� �Ű����� ���� Circle2() ������ ȣ��
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
