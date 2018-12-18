package chap11;

class Outer3 {

	int value = 10;

	class Inner {

		int value = 20;

		void method1() {

			int value = 30;
			System.out.println(value); //30
			System.out.println(this.value); //20
			System.out.println(Outer3.this.value); //10
		}

	}

}

public class Q0814_3 {

	public static void main(String[] args) {
		  new Outer3().new Inner().method1();
		

	}

}
