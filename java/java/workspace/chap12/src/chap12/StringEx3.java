package chap12;
/*
 * split 함수 : 원문자열을 기준문자를 중심으로 분리하는 기능
 */
public class StringEx3 {
	public static void main(String[] args) {
		String s = "HTML-CSS-javascript-Java-JSP-스프링";
		String[] subject = s.split("-");
		for(int i=0;i<subject.length;i++) {
			System.out.println((i+1)+":"+subject[i]);
		}
		//문자열 <= 기본형.
		String s2 = String.valueOf(12345); //s2="12345"
		System.out.println(s2);
		s2=""+12345;                       //s2="12345"
		System.out.println(s2);
		//기본형 <= 문자열
		int i = Integer.parseInt(s2);
		System.out.println(++i);// s2 = "12346"
		
		double d = Double.parseDouble("1234.5");
		System.out.println(++d);
		//format() : 형식문자를 사용할 수 있는 기능
		String sf = String.format("%.2f", 12.3456);   //%.2 : 소수점 이하 두번째 자리까지 표현. 세번째 자리에서 반올림.
		System.out.println(sf);//12.35
	}	

}
