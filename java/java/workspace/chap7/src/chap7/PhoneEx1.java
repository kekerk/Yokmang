package chap7;
class Phone{
	String color; //String�� �⺻�� null
	boolean power; // boolean�� �⺻�� false
	String no;
	/*
	 * �� ���� �������(�Ӽ�) : color, power, no //�ν��Ͻ� ����
	 * �� ���� ��� �޼���(���) �ν��Ͻ� �޼���
	 * power() : �Ŀ��� Ű�ų� ���� ����
	 * send() : 
	 * receive() :
	 */
	
	
	void power() {power = !power;}
	void send(String no) {
		// no : �Ű�����, ��������.
		//      ���������� ��������� ���� �̸��� ������.
		//      �������� �켱.
		System.out.println(no+ "�� ��ȭ �۽� ��");  
	}
	void receive(String no) {
		System.out.println(no+"�κ��� ��ȭ ���� ��");
	}
}
//���� Ŭ���� : main �޼��带 ������ �ִ� Ŭ����  ex: ���� Ŭ������ ������.
public class PhoneEx1 {
	public static void main(String[] args) {
		Phone p1 =  new Phone(); //��üȭ, �ν��Ͻ�ȭ  
		/*
		 *  new ������ : ��ü�� �Ҵ� ���
		 *  1. �������� �޸� �Ҵ�.
		 *  2. �⺻������ �ʱ�ȭ
		 *  	�������� : null
		 *   	boolean: false
		 *   	���� : 0
		 *   	���� : \u0000
		 *  3. ������ ȣ��
		 *  
		 *  p1 : ��������,  ������ �ּҿ� ����� �޸� ���� ������ �����´�.
		 */
		p1.color = "����";
		p1.power = true;
		p1.no = "01012341234";
		System.out.println(p1.color+","+p1.power+","+p1.no);
		p1.send("01012345678");
		p1.receive("01012345678");
		Phone p2 = new Phone();
		System.out.println(p1.color+","+p1.power+","+p1.no);
		System.out.println(p2.color+","+p2.power+","+p2.no);
		p2 = p1;  //2���� ���������� �ϳ��� ��ü�� ��� �ִ�.
		System.out.println(p2.color+","+p2.power+","+p2.no);
		p1.power();
		System.out.println(p2.color+","+p2.power+","+p2.no);
		System.out.println(p1.color+","+p1.power+","+p1.no);
		p2 = new Phone();
		System.out.println(p2.color+","+p2.power+","+p2.no);
	}

}
