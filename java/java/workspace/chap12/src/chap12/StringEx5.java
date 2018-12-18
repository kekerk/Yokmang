package chap12;
/*
 * String 클래스는 정적 문자열임.
 */
public class StringEx5 {
	public static void main(String[] args) {
	String str = "ABC123";
	System.out.println("main: "+str);
	change(str);
	System.out.println("change() 이후 main: " + str);
	}

	private static void change(String str) {

		str+="456";
		System.out.println("change(): "+str);
	}

}
