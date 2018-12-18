package chap12;
/*
 * String 주요 메서드
 */
public class StringEx2 {
	public static void main(String[] args) {
		String s = new String("ABCDEFGH");
		//char s.charAt(4) : s라고 하는 문자열 중 4번 index(5번쨰)문자를 리턴. 
		System.out.println(s.charAt(4));
		//int s.compareTo("abc") : s문자열과 "abc" 문자열의 차 리턴
		//								'A' - 'a' = -32
		// 정렬 시 사용되는 메서드
		System.out.println(s.compareTo("abc"));
		//compareToIgnoreCase("abc") : IgnoreCase는 대소문자 구분없이 
		System.out.println(s.compareToIgnoreCase("abc"));
		//concat : s 문자열에 "abc"를 더한다. (s+"abc")
		System.out.println(s.concat("abc"));
		//boolean s.endsWith("GH") : s문자열이 "GH" 문자열로 끝나는지 
		System.out.println(s.endsWith("GH"));
		//s.startsWith("AB") : s문자열이 "AB" 문자열로 시작하는지.
		System.out.println(s.startsWith("AB"));
		//boolean s.equalsIgnoreCase : s문자열이 대소문자 구별없이 똑같은지.
		System.out.println(s.equalsIgnoreCase("abcdefgh"));
		//
		s = new String("This is a String");
		//s.indexOf('i') : 'i'문자가 s문자열에 몇번 인덱스인지 값을 리턴.
		System.out.println(s.indexOf('i')); //2
		//s.indexOf('i',5) : 'i'문자가 5번 인덱스 이후에 S문자열에  몇번 인덱스인지 값을 리턴(5번 인덱스 포함)
		System.out.println(s.indexOf('i',5));//5
		//s.indexOf 메서드의 리턴값이 -1 : 문자가 없을 때.
		System.out.println(s.indexOf('i',15));//-1
		System.out.println(s.indexOf("is"));//2
		//s.lastIndexOf("is") : 뒤부터 "is"라고하는  문자열이 
		//                      앞부터 몇번 인덱스에 있는지 값을 리턴.(앞부터 index를 한다.)
		System.out.println(s.lastIndexOf("is"));//5
		System.out.println(s.length());//문자열의 길이 리턴.
		//s.replace("is", "QR") : s문자열에서 "is"문자열을 "QR"문자열로 변경하기.
		System.out.println(s.replace("is", "QR"));
		//s.substring(5) : s문자열 중 5번 인덱스 이후 다 가져오기.
		System.out.println(s.substring(5));
		//s.substring(5, 13) : s 문자열 중 5번 인덱스부터 12번 인덱스까지.(13번 인덱스 바로 앞에까지) 13번 인덱스 포함 안됨..
		System.out.println(s.substring(5, 13));
		//소문자로 변경
		System.out.println(s.toLowerCase());
		//대문자로 변경
		System.out.println(s.toUpperCase());
		//trim() : 양쪽 공백 제거. 
		System.out.println("  문자열 trim 메서드  ".trim());
	}
}
