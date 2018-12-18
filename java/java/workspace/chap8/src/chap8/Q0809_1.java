package chap8;
//1. Food, Fruit, Drink, Snack, Apple, Peach, Cock, Sidar, Biscuit, Cookie Ŭ������ �����ϱ� 

//
//��� �ķ�ǰ(Food)�� ����(price)�� �ǸŰ���(sellcnt), ���ʽ�����Ʈ(point)�� ������ �ֽ��ϴ�. 
//
//�ķ�ǰ ��ü�� �����ϱ� ���ؼ��� ������  �Է¹޾ƾ� �մϴ�. 
//
//�ķ�ǰ�� �����δ� ����(Fruit), ����(Drink),����(Snack)�� ������ ���ϴ�. 
//
//  ������ �絵(brix)��,����� �뷮(ml)�� ���ڴ¹���(gram) ������ ������ �ֽ��ϴ�.   
//
//  ���Ͽ��� ���(Apple)�� ������(Peach)  ���ῡ�� �ݶ�(Cock) ���̴�(Sidar)
//
//  ���ڴ�   ��Ŷ(Biscuit)�� ��Ű(Cookie)�� �ֽ��ϴ�.
//
//  ��� �����ƴ� ���ݰ� �絵�� �Է��Ͽ� ��ü�� �����ϰ�,
//
//  �ݶ�, ���̴ٴ°���, �뷮�� 
//
//  ���ڴ� ����,���Ը�  �Է��Ͽ�  ��ü�� �����մϴ�.  

class Food {
	int price;
	int sellcnt;
	int point;
	

	Food(int price) {
		this.price = price;
		this.point = price/10;
	}
}

class Fruit extends Food {
	int brix;

	Fruit(int price, int brix) {
		super(price);
		this.brix = brix;
	}

}

class Drink extends Food {
	int ml;

	Drink(int price, int ml) {
		super(price);
		this.ml = ml;
	}

}

class Snack extends Food {
	int gram;

	Snack(int price, int gram) {
		super(price);
		this.gram = gram;
	}

}

class Apple extends Fruit {
	Apple(int price, int brix) {
		super(price, brix);
	}
	
	public String toString() {
		return "���" ;
	}
	
	
}

class Peach extends Fruit {
	Peach(int price, int brix) {
		super(price, brix);
	}

	public String toString() {
		return "������" ;
	}

}

class Cock extends Drink {
	Cock(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "�ݶ�" ;
	}
	

}

class Sidar extends Drink {
	Sidar(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "���̴�" ;
	}
	
}

class Biscuit extends Snack {
	Biscuit(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "��Ŷ";
	}
	

}

class Cookie extends Snack {
	Cookie(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "��Ű" ;
	}
	
}

public class Q0809_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a = new Apple(3500, 5);
		Peach p = new Peach(2500, 3);
		Cock c = new Cock(1200, 350);
		Sidar s = new Sidar(950, 250);
		Biscuit b = new Biscuit(400, 70);
		Cookie co = new Cookie(550, 80);
		
		System.out.println(a);
		
		System.out.println(p);
		
		System.out.println(c);
		
		System.out.println(s);
	
		System.out.println(b);
	
		System.out.println(co);

	}

}
