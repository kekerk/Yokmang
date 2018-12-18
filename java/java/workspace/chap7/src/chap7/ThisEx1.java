package chap7;

/*
 * this ����� 
 * this ������ : ���� Ŭ������ �ٸ� ������ ȣ�� �� �����
 * 			    �ݵ�� �������� ù�ٿ� �ۼ��ؾ� �Ѵ�.
 * 			  
 * this �������� : �ڱ���������. ���� ��ü�� ������ ��������.
 * 				�ν��Ͻ� �޼��忡 ���������� ������.
 * 		        �ν��Ͻ��޼��� ���ο����� ����� ������.
 */			
class Car2 {
	String color;
	int number;

	Car2(String color, int number) {
		this.color = color;
		this.number = number;
	}
	Car2(String c) {
		// this ������ �ٸ� ���� ������ this ������ �ȵ�. �ݵ�� ù�ٿ� �ۼ�.
		this(c, 1);
	}
	Car2(int n) {
		this("white", n);
	}
	Car2(Car2 c) {
		this(c.color, c.number);
	}
	Car2() {
		this("white", 1);
	}
	public String toString() {
		return color + "," + number;
	}
}

public class ThisEx1 {

	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("blue", 1234);
		Car2 c3 = new Car2("red");
		Car2 c4 = new Car2(2);
		Car2 c5 = new Car2(c1);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
	

	}

}
