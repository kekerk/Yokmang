package chap7;

/*
 * 오버로딩 예제
 */
class Math3 {
	int a = 10;

	int add(int b) {
		System.out.print("1:");
		return a + b;
	}

	double add(double b) {
		System.out.print("2:");
		return a + b;
	}

	String add(String b) {
		System.out.print("3:");
		return a + b;
	}
}

public class OverloadingEx1 {
	public static void main(String[] args) {
		Math3 m3 = new Math3();
		System.out.println(m3.add(10));
		System.out.println(m3.add(10.0));
		System.out.println(m3.add("번"));
		
	}

}
