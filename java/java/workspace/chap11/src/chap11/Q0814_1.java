package chap11;

class Outer {

	 class Inner {

	  int iv=100;

	 }

	}
public class Q0814_1 {

	public static void main(String[] args) {
		Outer.Inner oi = new Outer().new Inner();
		System.out.println(oi.iv);

	}

}
