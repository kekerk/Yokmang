package chap8;

public class BikeEx3 {

	public static void main(String[] args) {
//		Bike2 bike = new Bike2(2);
		Bike2 bike = new AutoBike2(2);
//		AutoBike2 auto = (AutoBike2)bike; //�������
//		auto.power();
//		auto.drive();
		
		
		/*
		 * instanceof ������ : ���������� ��ü���� ���踦 �˷��ִ� ������
		 */
		
		if(bike instanceof Bike2) {
			System.out.println("bike�� �����ϰ� �ִ� ��ü�� Bike2 ��ü��");
		}
		if(bike instanceof AutoBike2) {
			System.out.println("bike�� �����ϰ� �ִ� ��ü�� AutoBike2 ��ü��");
		}
		if(bike instanceof Object) {
			System.out.println("bike�� �����ϰ� �ִ� ��ü�� Object ��ü��");
		}

	}

}
