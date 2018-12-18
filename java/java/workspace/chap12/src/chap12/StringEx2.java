package chap12;
/*
 * String �ֿ� �޼���
 */
public class StringEx2 {
	public static void main(String[] args) {
		String s = new String("ABCDEFGH");
		//char s.charAt(4) : s��� �ϴ� ���ڿ� �� 4�� index(5����)���ڸ� ����. 
		System.out.println(s.charAt(4));
		//int s.compareTo("abc") : s���ڿ��� "abc" ���ڿ��� �� ����
		//								'A' - 'a' = -32
		// ���� �� ���Ǵ� �޼���
		System.out.println(s.compareTo("abc"));
		//compareToIgnoreCase("abc") : IgnoreCase�� ��ҹ��� ���о��� 
		System.out.println(s.compareToIgnoreCase("abc"));
		//concat : s ���ڿ��� "abc"�� ���Ѵ�. (s+"abc")
		System.out.println(s.concat("abc"));
		//boolean s.endsWith("GH") : s���ڿ��� "GH" ���ڿ��� �������� 
		System.out.println(s.endsWith("GH"));
		//s.startsWith("AB") : s���ڿ��� "AB" ���ڿ��� �����ϴ���.
		System.out.println(s.startsWith("AB"));
		//boolean s.equalsIgnoreCase : s���ڿ��� ��ҹ��� �������� �Ȱ�����.
		System.out.println(s.equalsIgnoreCase("abcdefgh"));
		//
		s = new String("This is a String");
		//s.indexOf('i') : 'i'���ڰ� s���ڿ��� ��� �ε������� ���� ����.
		System.out.println(s.indexOf('i')); //2
		//s.indexOf('i',5) : 'i'���ڰ� 5�� �ε��� ���Ŀ� S���ڿ���  ��� �ε������� ���� ����(5�� �ε��� ����)
		System.out.println(s.indexOf('i',5));//5
		//s.indexOf �޼����� ���ϰ��� -1 : ���ڰ� ���� ��.
		System.out.println(s.indexOf('i',15));//-1
		System.out.println(s.indexOf("is"));//2
		//s.lastIndexOf("is") : �ں��� "is"����ϴ�  ���ڿ��� 
		//                      �պ��� ��� �ε����� �ִ��� ���� ����.(�պ��� index�� �Ѵ�.)
		System.out.println(s.lastIndexOf("is"));//5
		System.out.println(s.length());//���ڿ��� ���� ����.
		//s.replace("is", "QR") : s���ڿ����� "is"���ڿ��� "QR"���ڿ��� �����ϱ�.
		System.out.println(s.replace("is", "QR"));
		//s.substring(5) : s���ڿ� �� 5�� �ε��� ���� �� ��������.
		System.out.println(s.substring(5));
		//s.substring(5, 13) : s ���ڿ� �� 5�� �ε������� 12�� �ε�������.(13�� �ε��� �ٷ� �տ�����) 13�� �ε��� ���� �ȵ�..
		System.out.println(s.substring(5, 13));
		//�ҹ��ڷ� ����
		System.out.println(s.toLowerCase());
		//�빮�ڷ� ����
		System.out.println(s.toUpperCase());
		//trim() : ���� ���� ����. 
		System.out.println("  ���ڿ� trim �޼���  ".trim());
	}
}
