package chap10;
/*
 * ������:
 */


public class EnumEx1 {
	public enum Car{
		AVANTE,SONATA,GRANDURE,SM3
	}
	public static void main(String[] args) {
		Car car = Car.AVANTE;
		System.out.println("My Car :"+car);
		System.out.println("�ҳ�Ÿ:"+Car.SONATA);
		car = Car.GRANDURE;
		System.out.println("My Car :"+car);
		car = Car.SM3;
		// Car ��ü��
		if(car instanceof Object) {
			System.out.println(car.toString());
			System.out.println(car.getClass().getName());
		}
		
		 Car[] cars = Car.values();  // Car ��ü���� ��� �Ѱ��ִ� ��.
		 for(Car c : cars) {
			 System.out.println(c+":"+c.ordinal());//ordinal() : ��ü�� ��� ������ ������ �ű�.
		 }
	}

}
