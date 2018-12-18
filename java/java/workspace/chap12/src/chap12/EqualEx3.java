package chap12;
/*
 * 많은 클래스들이 equals 메서드를 오버라이딩을 하여 내용비교로 사용함.
 * equals 메서드는 내용비교로 사용되는 메서드.
 * 기본자료형을 제외한 대부분의 참조자료형은 equals라는 메서드를 overring 하여 내용비교를 할 수 있도록 되어있다.
 * 주의 : 객체의 내부 비교를 위해서는 equals 메서드를 사용해야 함.
 *  
 */
public class EqualEx3 {
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		if(s1==s2) {
			System.out.println("s1문자열 객체와 s2문자열 객체는 같은 객체임.");
		}else {
			System.out.println("s1문자열 객체와 s2문자열 객체는 다른 객체임."); // s1, s2로 객체는 다르다.
		}
		
		if(s1.equals(s2)) { //.equals()는 오버라이딩해야 한다.
			System.out.println("s1문자열과 s2문자열은 같은 문자열임.");
		} else {
			System.out.println("s1문자열과 s2문자열은 다른 문자열임.");
		}
		/*
		 * hashcode는 객체를 구별할 수 있는 고유 정수값임.
		 * hashcode값이 다른면 다른 객체다.
		 * 논리적 동등성을 위해 오버라이딩을 함.
		 * equals 메서드를 오버라이딩하면, hashCode()도 오버라이딩을 하도록 권장함.
		 * String 클래스도 hashCode()를 오버라이딩함.
		 */
		System.out.println("s1.hashcode()="+s1.hashCode());
		System.out.println("s2.hashcode()="+s2.hashCode());
		System.out.println("s1 실제 해쉬코드값="+System.identityHashCode(s1));
		System.out.println("s2 실제 해쉬코드값="+System.identityHashCode(s2));
		
		Equal e1 = new Equal("abc");
		Equal e2 = new Equal("abc");
		System.out.println("e1.hashcode()="+e1.hashCode());
		System.out.println("e2.hashcode()="+e2.hashCode());
		System.out.println("e1 실제 해쉬코드값="+System.identityHashCode(e1));
		System.out.println("e2 실제 해쉬코드값="+System.identityHashCode(e2));
		
//		Wrapper class 
		
	}
}
