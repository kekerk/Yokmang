package chap7;
// ���� 7-3 : ����Լ� ����
//����Լ��� �ڽ��� �޼��带 �ٽ� ȣ���ϴ� �Լ��� ���Ѵ�.
public class FactorialEx {
	
	public static void main(String[] args) {
	System.out.println("4!="+ new FactorialEx().factorial(4));
	}
	private int factorial(int i) {
		return (i==1)? 1: factorial(i-1)*i;
	}

}
