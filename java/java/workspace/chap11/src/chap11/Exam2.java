package chap11;

public class Exam2 {
	public static void main(String[] args) {
		
	try {
		badmethod();
	} catch (Exception e) {
		System.out.println("main ���� ���� ó����");
		e.printStackTrace();
	}
		
		
	}

	private static void badmethod() throws Exception {
		//badmethod() �� main���� �ι� ����ó���� �ϱ�.
	try {
		throw new Exception("���� ó�� ����");
	} catch (Exception e) {
		System.out.println("badmethod ���� ���� ó����");
		e.printStackTrace();
		throw e;
	}
		
	}

}
