package chap8;
//1. Food, Fruit, Drink, Snack, Apple, Peach, Cock, Sidar, Biscuit, Cookie 클래스를 구현하기 

//
//모든 식료품(Food)은 가격(price)과 판매갯수(sellcnt), 보너스포인트(point)를 가지고 있습니다. 
//
//식료품 객체를 생성하기 위해서는 가격을  입력받아야 합니다. 
//
//식료품의 종류로는 과일(Fruit), 음료(Drink),과자(Snack)로 나누어 집니다. 
//
//  과일은 당도(brix)를,음료는 용량(ml)를 과자는무게(gram) 정보를 가지고 있습니다.   
//
//  과일에는 사과(Apple)와 복숭아(Peach)  음료에는 콜라(Cock) 사이다(Sidar)
//
//  과자는   비스킷(Biscuit)과 쿠키(Cookie)가 있습니다.
//
//  사과 복숭아는 가격과 당도를 입력하여 객체를 생성하고,
//
//  콜라, 사이다는가격, 용량을 
//
//  과자는 가격,무게를  입력하여  객체를 생성합니다.  

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
		return "사과" ;
	}
	
	
}

class Peach extends Fruit {
	Peach(int price, int brix) {
		super(price, brix);
	}

	public String toString() {
		return "복숭아" ;
	}

}

class Cock extends Drink {
	Cock(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "콜라" ;
	}
	

}

class Sidar extends Drink {
	Sidar(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "사이다" ;
	}
	
}

class Biscuit extends Snack {
	Biscuit(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "비스킷";
	}
	

}

class Cookie extends Snack {
	Cookie(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "쿠키" ;
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
