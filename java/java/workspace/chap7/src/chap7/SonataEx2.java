package chap7;

// ���� 7-6 : Ŭ���� ���� ��� ����
class Sonata2 {
	String color;
	int number;
	int serialNo;
	static int sno;  //�⺻�� 1?   
	static int width = 250;
	static int height = 150;
	//��ü�� ���ڿ�ȭ�ϴ� �޼�����.
	public String toString() { //main������ syso(������);
		return "�ڵ��� ������ȣ:" + serialNo + "," + color + ":" + number + "(" + width + "," + height + ":�ڵ��� �����ȣ=" + sno
				+ ")";
	}
}

public class SonataEx2 {

	public static void main(String[] args) {
		Sonata2 car1 = new Sonata2();
		car1.color = "white";
		car1.number = 1234;
		car1.serialNo = ++car1.sno;   //Sonata2 Ŭ�������� int sno�� �����ϸ� 
 		Sonata2 car2 = new Sonata2();
		car2.color = "black";
		car2.number =2345;
		car2.serialNo = ++car2.sno;
		System.out.println(car1); // car1.toString() �� ȣ���.
		System.out.println(car2);
		Sonata2 car3 = new Sonata2();
		car3.color = "red";
		car3.number =3456;
		car3.serialNo = ++car3.sno;
		Sonata2 car4 = car3;
		System.out.println(car3);
		System.out.println(car4);
	}

}
