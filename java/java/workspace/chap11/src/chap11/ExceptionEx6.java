package chap11;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			throw new Exception("���� ���� �߻�"); // ���� ��ü ����. JVM�� �߻��� �˷��ִ� ��.
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("���α׷� ���� ����");
	}

}
