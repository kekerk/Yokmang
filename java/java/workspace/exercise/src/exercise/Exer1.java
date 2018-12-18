package exercise;
//1. Food, Fruit, Drink, Snack, Apple, Peach, Cock, Sidar, Biscuit, Cookie 클래스를 구현하기 
//
//모든 식료품(Food)은 가격(price)과 판매갯수(sellcnt), 보너스포인트(point)를 가지고 있습니다. 
//
//식료품 객체를 생성하기 위해서는 가격을  입력받아야 합니다. 
//
//식료품의 종류로는 과일(Fruit), 음료(Drink),과자(Snack)로 나누어 집니다. 
//
//과일은 당도(brix)를,음료는 용량(ml)를 과자는무게(gram) 정보를 가지고 있습니다.   
//
//과일에는 사과(Apple)와 복숭아(Peach)  음료에는 콜라(Cock) 사이다(Sidar)
//
//과자는   비스킷(Biscuit)과 쿠키(Cookie)가 있습니다.
//
//사과 복숭아는 가격과 당도를 입력하여 객체를 생성하고,
//
//콜라, 사이다는가격, 용량을 
//
//과자는 가격,무게를  입력하여  객체를 생성합니다. 

class food{
	int price;
	int sellcnt;
	int point;
	
	food(int price) {
		this.price = price;
	}
}

class fruit extends food{
	double brix;
	fruit(int price, double brix){
		super(price); //super를 제일 먼저 작성해야 한다.
		this.brix =brix;
	}
}
class drink extends food{
	int ml;
	drink(int price, int ml){
		super(price);
		this.ml = ml;
	}
}
class snack extends food{
	int gram;
	snack(int price, int gram){
		super(price);
		this.gram =gram;
	}
}

class apple extends fruit{
	apple(int price, double brix) {
		super(price,brix);
	}
}
class peach extends fruit{
	peach(int price, double brix) {
		super(price,brix);
	}
}

class Cock extends drink{
	Cock(int price, int ml) {
		super(price,ml);
	}
}
class Sidar extends drink{
	Sidar(int price, int ml) {
		super(price,ml);
	}
}

class biscuit extends snack {
	biscuit(int price, int gram) {
		super(price,gram);
	}
}
class cookie extends snack {
	cookie(int price, int gram) {
		super(price,gram);
	}
}
public class Exer1 {

	public static void main(String[] args) {
		apple a = new apple(1000,10.5);
		System.out.println("사과 가격: "+a.price);
		System.out.println("사과 당도: "+a.brix);
		peach p = new peach(3000,16.5);
		System.out.println("복숭아 가격: "+p.price);
		System.out.println("복숭아 당도: "+p.brix);

	}

}
