package chap3;
// String 클래스 : 문자열 객체 의미
// + 연산자를 이용할수 있는 클래스
//String = String + 기본형
//자바에서 'a' char 형인 기본형이고, 
//      "a" String 형인 객체이므로 서로 형변환이 안된다.
public class VarEx4 {

	public static void main(String[] args) {
		System.out.println("번호:"+1+2+3); // 번호:1 -> 번호:12 -> 번호:123 형태로 string = string + 기본형으로 1, 2, 3 이 뒤에 붙게 된다
		System.out.println(1+2+3+"번"); // 합연산부터 시작.
		//String str = "a"; (o) 
		//String str = 'a'; (x)
		String str = "오름"+'a';
		System.out.println("str:"+str);
	}

}
