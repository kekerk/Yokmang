package chap7;
/*
 * 직사각형2(Rectangle2) 클래스 구현
 * 멤버변수 : 가로(width),세로(height)
 * 멤버메서드 :
 * 	1. int area() : 넓기구하기
 *  2. int length() : 둘레구하기
 *  3. boolean isSquare() : 정사각형 여부
 *  4. public String toString() : 가로,세로,넓이,둘레,정사각형 여부 출력하기.
 *  
 *  생성자 :
 * 		1.  매개변수() : 가로 = 1, 세로 = 1로 초기화
 *      2.  매개변수(int w, int h) : 가로 w 세로 h로 초기화
 */

class Rectangle2{
	int width;
	int height;
	int area() {
		return	width*height;
	}
	int length() {
		return (width+height)*2;
	}
	
	boolean isSquare() {
		return width==height;
		
		
	}
	
	public String toString() {
		
		return "가로 :"+width+" 세로 :"+height+" 넓이 :"+ area() + " 둘레 :"+length() + " 사각형 모양:" + (isSquare()? "정사각형":"직사각형");
	}
	Rectangle2() {
		width =(int)(Math.random()*9 +1); //1
		height = (int)(Math.random()*9 +1);//1
		
	}
	
	Rectangle2(int w, int h) {
		width = w;
		height = h;
	}
}
public class Exam4 {

	public static void main(String[] args) {
		Rectangle2 rec2 = new Rectangle2();
		Rectangle2 rec3 = new Rectangle2(10,5);
		System.out.println(rec2);
		System.out.println(rec3);

	}

}
