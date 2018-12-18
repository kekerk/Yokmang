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
		//Shape Ŭ������ ���� Ŭ�����̹Ƿ� �ڵ� ����ȯ 
		list.add(new Circle(5.0));
		list.add(new Rectangle(3,4));
		list.add(new Circle());
		list.add(new Circle(10));
		//list�� �ִ� ��� Shape ��ü�� ������ �ѷ� ���ϱ�.
		for(Shape s : list) {
			System.out.println(s.area());
			System.out.println(s.length());
		}
     	//��� : �Ҽ������� ���ڸ�.
		System.out.println("��ü ������ ������ ��:"+String.format("%.2f", sumArea(list)));
		System.out.println("��ü ������ �ѷ��� ��:"+String.format("%.2f", sumLength(list)));
		
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
