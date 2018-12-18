package chap8;
/*
 * �߻� Ŭ����
 * �߻� �޼��带 ���� �� �ִ� Ŭ����, abstract ������ ������.
 * ��üȭ �Ұ�. ��üȭ�� �ݵ�� ����� ���ؼ� �ڼ�Ŭ������ ��üȭ�� ��üȭ�� ��.
 * �� �� �ڼ�Ŭ���������� �ݵ�� �߻�޼��带 �������̵� �ؾ� ��.
 * �׿ܴ� �Ϲ�Ŭ������ ����. (������, ��� ���)
 * ������ ǥ��ȭ�� ����.
 * 
 * �߻�޼��� : ����θ� �����ϴ� �޼���, �����ΰ� ����.
 * 			�ڼ�Ŭ�������� �ݵ�� �������̵��ؾ��Ѵ�.
 */
abstract class Shape{
	String type;
	Shape(String type){
		this.type =type;
	}
	
	abstract double area(); //�߻� �޼��� : �ڼո޼��忡�� �ݵ�� �������̵� �ʿ�
	abstract double length(); //�߻� �޼���
	
}
class Circle extends Shape{
	int r;
	Circle(int r){
		super("��");
		this.r =r;
		
	}
	@Override
	double area() { //����ȭ
		
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
		super("�簢��");
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
			Circle c = (Circle) s; //shape Ŭ������ Circle Ŭ������ ������(����ȯ)
			System.out.println("���� ������: " + c.r);
		}
		System.out.println(s.type+"�� ����: "+s.area());
		System.out.println(s.type+"�� �ѷ�: "+s.length());
	}
		
		

	}

}
