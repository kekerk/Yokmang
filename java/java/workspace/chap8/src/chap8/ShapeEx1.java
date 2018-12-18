package chap8;
/*
 * 추상 클래스
 * 추상 메서드를 가질 수 있는 클래스, abstract 예약어로 구현됨.
 * 객체화 불가. 객체화는 반드시 상속을 통해서 자손클래스의 객체화로 객체화가 됨.
 * 이 때 자손클래스에서는 반드시 추상메서드를 오버라이딩 해야 함.
 * 그외는 일반클래스와 같다. (생성자, 멤버 등등)
 * 업무의 표준화에 사용됨.
 * 
 * 추상메서드 : 선언부만 존재하는 메서드, 구현부가 없다.
 * 			자손클래스에서 반드시 오버라이딩해야한다.
 */
abstract class Shape{
	String type;
	Shape(String type){
		this.type =type;
	}
	
	abstract double area(); //추상 메서드 : 자손메서드에서 반드시 오버라이딩 필요
	abstract double length(); //추상 메서드
	
}
class Circle extends Shape{
	int r;
	Circle(int r){
		super("원");
		this.r =r;
		
	}
	@Override
	double area() { //강제화
		
		return Math.PI*r*r;
	}
	@Override
	double length() {
				return Math.PI*r*2;
	}
	@Override
	public String toString() {
		return "Circle [r=" + r + "]";
	}
	
}

class Rectangle extends Shape {
	int width, height;
	Rectangle(int width, int height){
		super("사각형");
		this.width =width;
		this.height = height;
	}
	@Override
	double area() {
		
		return width * height;
	}
	@Override
	double length() {
		
		return (width+height)*2;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
}
public class ShapeEx1 {

	public static void main(String[] args) {
	Shape[] shapes = new Shape[2];
	shapes[0] = new Circle(10);
	shapes[1] = new Rectangle(5,5);
	
	for(Shape s:shapes) {
		System.out.println(s);
		if(s instanceof Circle) {
			Circle c = (Circle) s; //shape 클래스를 Circle 클래스로 다형성(형변환)
			System.out.println("원의 반지름: " + c.r);
		}
		System.out.println(s.type+"의 넓이: "+s.area());
		System.out.println(s.type+"의 둘레: "+s.length());
	}
		
		

	}

}
