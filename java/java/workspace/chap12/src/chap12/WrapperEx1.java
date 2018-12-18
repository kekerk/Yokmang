package chap12;
/*
 *  wrapper class : 8개의 기본 자료형을 객체화하기 위한 클래스. 기본자료형이 가지고 있는 정보를 가지고 있음.
 *  
 *  기본형 						wrapper 클래스
 *  ==============================================
 *  boolean						Boolean
 *  char						Character
 *  byte						Byte
 * 	short						Short
 *  int							Integer
 *  long						Long
 *  float						Float
 *  double						Double
 *  
 *  기본적으로 기본자료형과 참조자료형 사이는 서로 형변환 불가.
 *  단, 기본자료형과 대응되는 Wrapper 클래스 사이에는 자동 형변환 됨. (jdk5.0 이후)
 *  기본형 <= 참조형 : auto unboxing (참조형을 기본형으로 자동 형변환)
 *  참조형 <= 기본형 : auto boxing (기본형을 참조형으로 자동 형변환) 
 *  
 *  
 */
public class WrapperEx1 {

	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println("i1==i2?"+(i1==i2)); //false
		System.out.println("i1.equals(i2)?"+(i1.equals(i2))); //내용 비교. true
		System.out.println("i1==100?"+(i1==100)); //i1이 기본형으로 자동형변환됨(100이라는 숫자와 맞춰지기 위해)
		int i3 = 100;
		System.out.println("i2==i3?"+(i2==i3)); //i2는 언박싱(기본형으로 형변환)이 됨.
		Integer i4 =100; //boxing
		System.out.println("i1==i4?"+(i1==i4)); //false
		//비트수 
		System.out.println("int의 bit 수:"+Integer.SIZE);
		System.out.println("byte의 bit 수:"+Byte.SIZE);
		//최대값
		System.out.println("int의 최대값: "+Integer.MAX_VALUE);
		//최소값
		System.out.println("int의 최소값: "+Integer.MIN_VALUE);
		//진수 표시
		System.out.println("8진수 12:"+Integer.parseInt("12",8)); //8진수 12는 10진수로 10
		System.out.println("16진수 12:"+Integer.parseInt("12",16)); //16진수 12는 10진수로 18
		//십진수를 2진수,8진수,16진수
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toHexString(10));
	}

}
