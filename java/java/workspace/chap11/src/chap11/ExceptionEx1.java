package chap11;
/*
 * ����ó�� : �߻��� ���ܸ� ����
 * try catch ����
 * 		  try �� : ���ܰ� �߻� �� �� �ִ� ����.
 * 		catch �� : try ������ ���ܰ� �߻��� ��� ó�� �ϴ� ����.
 * 
 * 	�ڹٴ� ����ó���� �ʼ���.
 *  �� RuntimeException ������ ��� ����ó���� ���� ������.
 */	
public class ExceptionEx1 {
	public static void main(String[] args) {
		System.out.print(1); //�� �κп��� ���ܰ� ����� JVM���� ó����.
		
		try {
			System.out.print(2);
			System.out.print(3/0); //ArithmeticException ���� �߻�.
			System.out.print(4);
			
		} catch (ArithmeticException e) { // ������ �߻����� ���� ������ �ȴ�.
			System.out.print(5);
		}
		System.out.print(6);
	}

}
