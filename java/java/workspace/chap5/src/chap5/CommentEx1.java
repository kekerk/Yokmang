package chap5;
/*
 * 
 *  자바 주석 : 주석이란 목적파일의 대상이 아님. 프로그램의 설명 등을 자유롭게 작성 가능
 *  1. // : 한줄 주석. // 이후가 주석임.
 *  2. /* ..... * / : 여러줄 주석. /* 이후부터 * / 까지 주석임.
 *  3. /** .... * / : 여러줄 주석 + 문서화 기능을 가짐
 *                     클래스 외부나, 메서드 외부에서 지정된 주석을 문서화 시킴.
 */
public class CommentEx1 {
/**
 * 주석 예제의 main 메서드임.
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100; //변수 선언. 한줄 주석
		/*
		 * 여러줄 주석
		 */
		/**
		 * 문서화 주석
		 */
	}

}
