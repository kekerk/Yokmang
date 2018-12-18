package chap8;
/*
 *  전자제품상점에 고객이 전자제품을 구매하기.
 */
class Product {
	int price;
	int point;
	Product(int price){
		this.price = price;
		this.point = price / 10;
		
	}
}	
class Tv extends Product {
	Tv() { super(100); }
	public String toString() {
		return "Tv";
	}
}
class Computer extends Product {
	Computer() {super(200); }
	public String toString() {
		return "Computer";
	}
}

class Buyer{
	int money = 20000;
	int point;
	//cart 배열은 Product의 하위 클래스의 객체를 저장 할 수 있다.
	Product[] cart = new Product[6]; //5
	int index;
	// p 매개변수가 Product의 하위클래스의 객체를 참조할 수 있다.
	//다형성이 안된다면, buy(Tv p), buy(Computer p) 처럼 따로따로 해야 한다.
	void buy(Product p) {
		money -= p.price;
		point += p.point;
		System.out.println(p+"구입"); //toString 매서드 호출.
		cart[index++] = p; 
		
	}
	void summary() {
		int sum = 0;
		String itemlist = " ";
		for(Product p : cart) {
//			if(p==null) break;
			sum += p.price;
			itemlist += p+",";
			
		}
		System.out.println("총 구매 금액: "+sum);
		System.out.println("구매 목록: "+itemlist);
	}
	
}
public class Exam3 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		b.buy(t); b.buy(c); //Product p에 순서대로 t, c가 실림. p[0] = t, p[1] = c.
		System.out.println("구매 후 잔액: "+b.money);
		System.out.println("구매 후 포인트: "+b.point);
		b.summary();
		
	}
}
