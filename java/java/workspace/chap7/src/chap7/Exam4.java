package chap7;
/*
 * ���簢��2(Rectangle2) Ŭ���� ����
 * ������� : ����(width),����(height)
 * ����޼��� :
 * 	1. int area() : �бⱸ�ϱ�
 *  2. int length() : �ѷ����ϱ�
 *  3. boolean isSquare() : ���簢�� ����
 *  4. public String toString() : ����,����,����,�ѷ�,���簢�� ���� ����ϱ�.
 *  
 *  ������ :
 * 		1.  �Ű�����() : ���� = 1, ���� = 1�� �ʱ�ȭ
 *      2.  �Ű�����(int w, int h) : ���� w ���� h�� �ʱ�ȭ
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
		
		return "���� :"+width+" ���� :"+height+" ���� :"+ area() + " �ѷ� :"+length() + " �簢�� ���:" + (isSquare()? "���簢��":"���簢��");
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
