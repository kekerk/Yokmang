package chap7;
/*	���� ��ġ�� ���� ������ ����
 *   		  ������ġ		  ������			�޸��Ҵ���ġ       �޸𸮻����ñ�
 * Ŭ���� ����   Ŭ���� ����  static int cv		 Ŭ��������          Ŭ�������� �ε� ��
 *   ->  ��üȭ �ʿ� ����, Ŭ�������� �ε�� Ŭ���� ������ �޸� �Ҵ�.
 *   	 Ŭ������.������ ���.   ex) Sonata.width
 *  	 �ش� Ŭ������ ��� ��ü�� ���� ������ ���.
 * �ν��Ͻ� ���� Ŭ���� ����        int iv			 ������               ��üȭ ��
 *   ->  ��üȭ�� �� ������ �޸� �Ҵ�.
 * 		 ����������.������ ����.
 * 		 ��ü���� �ٸ� �޸𸮿������� �Ҵ��. ex) car1.color, car2.color 
 * ��������       �޼��� ����	 int ��v  		 ���ÿ���  		  ���𹮽����     (�Ű����� ����)
 *   ->  �Ű������� ����������.
 * 		 ����� �޼��忡���� ����� �����ϴ�.
 * 		 �޼��� ����� �Բ� ���������� �Ҹ��.
 * 		 �ݵ�� �ʱ�ȭ �Ǿ�� ��.
 */
class Sonata {
	String color; //�ν��Ͻ� ����
	int number; //�ν��Ͻ� ����
	static int width = 250; //Ŭ���� ����
	static int height = 150; //Ŭ���� ����
	public String toString() {
		return color + ":" + number + "(" + width + "," + height+")";
	}
}
public class SonataEx1 {

	public static void main(String[] args) {
		System.out.println("�ڵ����� ũ��: "+ Sonata.width + ","+ Sonata.height);
		Sonata car1 = new Sonata(); //
		car1.color = "white";
		car1.number = 1234;
		System.out.println("car1="+car1);
		Sonata car2 = new Sonata();
		car2.color = "black";
		car2.number = 3456;
		System.out.println("car2="+car2);
		
//		car1.width = 50;
//		car1.height = 30;
		Sonata.width = 50;
		Sonata.height = 30;  // ��� Sonata ��ü�� ������ �޴´�.
		System.out.println("car1="+car1);
		System.out.println("car2="+car2);

	}

}
