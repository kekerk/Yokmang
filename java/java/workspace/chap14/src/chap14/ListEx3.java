package chap14;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
	int x, y;

	Shape() {
		this(0, 0);
	}

	Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract double area();
	abstract double length();
	public String getLocation() {
		return "x:"+x+",y:"+y;
	}
	
}

class Circle extends Shape{
	double r;
	Circle() {
		this(1);
	}
	
	Circle(double r) {
		this.r=r;
	}
	@Override
	double area() {
		return (r*r)*Math.PI;
	}
	@Override
	double length() {
		return (2*r)*Math.PI;
	}
}

class Rectangle extends Shape {
	int w, h;
	Rectangle() {
		this(1,1);
	}
	
	Rectangle(int w, int h){
		this.w =w;
		this.h = h;
	}

	@Override
	double area() {
		return (w*h);
	}

	@Override
	double length() {
		return (w+h)*2;
	}
	
}
public class ListEx3 {
	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>() ;
		//Shape 클래스의 하위 클래스이므로 자동 형변환 
		list.add(new Circle(5.0));
		list.add(new Rectangle(3,4));
		list.add(new Circle());
		list.add(new Circle(10));
		//list에 있는 모든 Shape 객체의 면적과 둘레 구하기.
		for(Shape s : list) {
			System.out.println(s.area());
			System.out.println(s.length());
		}
     	//출력 : 소수점이하 두자리.
		System.out.println("전체 도형의 면적의 합:"+String.format("%.2f", sumArea(list)));
		System.out.println("전체 도형의 둘레의 합:"+String.format("%.2f", sumLength(list)));
		
	}

	private static double sumLength(List<Shape> list) {
		double sumlength = 0;
		for(Shape s : list) sumlength += s.length();
		return sumlength;
	}

	private static double sumArea(List<Shape> list) {
		double sumarea=0;
		for(Shape s : list) sumarea += s.area();
		return sumarea;
	}
}
