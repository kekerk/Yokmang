package chap12;
/*
 * split �Լ� : �����ڿ��� ���ع��ڸ� �߽����� �и��ϴ� ���
 */
public class StringEx3 {
	public static void main(String[] args) {
		String s = "HTML-CSS-javascript-Java-JSP-������";
		String[] subject = s.split("-");
		for(int i=0;i<subject.length;i++) {
			System.out.println((i+1)+":"+subject[i]);
		}
		//���ڿ� <= �⺻��.
		String s2 = String.valueOf(12345); //s2="12345"
		System.out.println(s2);
		s2=""+12345;                       //s2="12345"
		System.out.println(s2);
		//�⺻�� <= ���ڿ�
		int i = Integer.parseInt(s2);
		System.out.println(++i);// s2 = "12346"
		
		double d = Double.parseDouble("1234.5");
		System.out.println(++d);
		//format() : ���Ĺ��ڸ� ����� �� �ִ� ���
		String sf = String.format("%.2f", 12.3456);   //%.2 : �Ҽ��� ���� �ι�° �ڸ����� ǥ��. ����° �ڸ����� �ݿø�.
		System.out.println(sf);//12.35
	}	

}
