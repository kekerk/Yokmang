package chap15;
/*
 *  OutputStream > ... > PrintStream
 *  :출력 기능 보강. 보조스트림.
 *  println, print, printf 메서드 추가.
 *  => 모든 자료형을 출력하는 기능.
 *  => 예외처리 생략 가능.
 *  
 *  printf : 형식제어문자. (%d,%f,%s ...) 사용 기능.
 *  String.format() : 형식제어문자. (%d,%f,%s ...) 사용 기능.(String 타입)
 */
public class PrintStreamEx1 {

	public static void main(String[] args) {
		// char 출력 형식 지정 ; %c   , %n == \n
	System.out.printf("%c%n",'A');
	System.out.printf("%5c%n",'A');	//5자리확보. 오른쪽정렬.
	System.out.printf("%-5c%n",'A'); // 5자리 확보. 왼쪽 정렬.
	//정수 출력 : %d, %o, %x, %X
	System.out.printf("%d%n",12345); //Decimal 10진 정수.
	
	System.out.printf("%,d%n",12345);//세자리마다 , 표시.
	
	System.out.printf("%o%n",12345);//12345를 Octal 8진수로.
	
	System.out.printf("%x%n",12345);//Hexa 16진수. %x -> 10 이상을 소문자 알파벳으로.
	System.out.printf("%X%n",12345);//Hexa 16진수. %X -> 10 이상을 대문자 알파벳으로.
	
	System.out.printf("%10d%n",12345);//최소 10자리 확보. 오른쪽 정렬.
	System.out.printf("%010d%n",12345);//최소 10자리 확보 후 빈자리를 0으로 채움.
	System.out.printf("%-10d%n",12345);//최소 10자리 확보. 왼쪽 정렬.
	System.out.printf("%,10d%n",12345);
	System.out.printf("%-,10d%n",12345);
	System.out.printf("%-,10d%n",12345);
	//실수출력. %f %d
	System.out.printf("%f%n",12345.12345);//실수출력.
	System.out.printf("%g%n",12345.12345);//근사실수.
	System.out.printf("%e%n",12345.12345);//지수실수.
	System.out.printf("%.2f%n",12345.12345);//소수점 이하 세번째 자리에서 반올림됨.
	System.out.printf("%10.2f%n",12345.12345);
	System.out.printf("%,10.2f%n",12345.12345);
	System.out.printf("%-,10.2f%n",12345.12345);
	System.out.printf("%,02.20f%n",Math.PI);
	//논리형 출력. %b
	System.out.printf("%b%n",true);
	System.out.printf("%b%n",(10>5));
	//10>5=true  형식지정문자 사용하기.
	System.out.printf("%d > %d = %b%n", 10,5,(10>5));
	//문자열 : %s
	System.out.printf("%s는 %s다","연호","바보");
	System.out.println();
	//10진수 255는 8진수 377이다. : 문진영
	System.out.printf("%d진수 %d는 %d진수 %o이다. : %b",10,255,8,255,((Integer.toOctalString(255)).equals("377")));
	System.out.println();
	//홍길동의 급여는 3,000,000원이다. 
	System.out.printf("%s의 %s은(는)%,10d원이다. : %s%n","홍길동","월급",3000000,"김동진");
	System.out.println(String.format("%d진수 %d는 %d진수 %o이다.%n",10,255,8,255));
	
	}
}
