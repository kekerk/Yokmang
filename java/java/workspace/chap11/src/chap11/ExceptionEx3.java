package chap11;

/*
 * finally ���� : ���� ó�� �Ǵ� ���� �߻� �� ��� ����Ǵ� ��.
 * 				 �߰��� retrun ������ ����ǵ� finally ���� ����ȴ�.
 */

public class ExceptionEx3 {
	public static void main(String[] args) {
		try {
			System.out.println("�۾��� �����մϴ�.");
			System.out.println(args[0]);
			System.out.println("�۾� ���Դϴ�.");
			// return;
		} catch (Exception e) {
			System.out.println("�۾� �� ������ �߻��߽��ϴ�.");
			return; // �޼��� ����.

		} catch (Throwable e) {
			System.out.println("�۾� �� ������ �߻��߽��ϴ�.");
		}

		finally { // catch���� return�� ������ finally�� �ϰ� ������ �Ѵ�.
			System.out.println("�۾��� �������մϴ�.");
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
