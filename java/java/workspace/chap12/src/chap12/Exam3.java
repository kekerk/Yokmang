package chap12;

public class Exam3 {

	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));

	}
//String��
//	private static String round(double s, int i) {
//
//		return String.format(("%."+i+"f"), s);
//		
//	}
	
//double��
	private static double round(double s, int i) {
		String sf = String.format(("%."+i+"f"), s);
		return Double.parseDouble(sf);  //Double.parseDouble(sf) : String���� double������ �ٲ��ִ� ���.
	}

}
