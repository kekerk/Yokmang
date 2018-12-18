/*
   첫번째 자바 프로그램:HelloWorld.java
  
   1.public class 이름과 파일의 이름은 같아야 된다.
   2.자바는 대소문자를 구분한다.
   3.main 메서드를 실행한다.
   4.실행과정
    -javac HelloWorld.java
     자바컴파일러:javac
     실행(목적)파일: HelloWorld.class 파일이 생성된다.
                        바이트코드라 한다.
    -java HelloWorld
     자바인터프리터:java
     
     컴퓨터 언어중 컴파일과 인터프리터 동시에 갖고 있는 것은 java

    java 인터프리터의 기능
   1.JVM 환경 생성
   2.CLASS파일 로드,검증
   3.main 메서드를 실행

*/

public class HelloWorld {
    public static void main (String[] args){ //프로그램의 시작....
      System.out.println("Hello,World");
   }
}