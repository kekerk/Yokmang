package chap12;

public class Q0816_1 {

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5),!@^~() -> "

				+ delChar("(1!2@3^4~5)", "!@^~()"));

		System.out.println("(1!2@3^4~5),12345 -> "

				+ delChar("(1!2@3^4~5)", "12345"));

	}

	private static String delChar(String str1, String str2) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<str1.length();i++) {
			if(str2.indexOf(str1.charAt(i))<0) { //indexOf : Ư���� ���� Ȥ�� ���ڿ��� ��ġ�� index���� ����.
				sb.append(str1.charAt(i)); //append : str1.charAt(i)�� ���ڸ� sb ��ü�� ���ʴ�� ����.
			}
		}
		return sb.toString();
	}
	
	
	
	
	
}