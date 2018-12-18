package chap12;

/*

다음의 결과가 나오도록  프로그램을 완성하시오.

[결과]

(1!2@3^4~5),!@^~() -> 12345

(1!2@3^4~5),12345 -> (!@^~)

*/
public class Q0816 {

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5),!@^~() -> "

				+ delChar("(1!2@3^4~5)", "!@^~()"));

		System.out.println("(1!2@3^4~5),12345 -> "

				+ delChar("(1!2@3^4~5)", "12345"));

	}

	private static StringBuffer delChar(String str1, String str2) {
		StringBuffer str = new StringBuffer(str1);
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str2.charAt(j) == str.charAt(i)) {

					str.deleteCharAt(i);

				}
			}
		}
		return str;

	}

}
