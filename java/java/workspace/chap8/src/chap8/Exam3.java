package chap8;
/*
 *  ������ǰ������ ���� ������ǰ�� �����ϱ�.
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
	//cart �迭�� Product�� ���� Ŭ������ ��ü�� ���� �� �� �ִ�.
	Product[] cart = new Product[6]; //5
	int index;
	// p �Ű������� Product�� ����Ŭ������ ��ü�� ������ �� �ִ�.
	//�������� �ȵȴٸ�, buy(Tv p), buy(Computer p) ó�� ���ε��� �ؾ� �Ѵ�.
	void buy(Product p) {
		money -= p.price;
		point += p.point;
		System.out.println(p+"����"); //toString �ż��� ȣ��.
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
		System.out.println("�� ���� �ݾ�: "+sum);
		System.out.println("���� ���: "+itemlist);
	}
	
}
public class Exam3 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv t = new Tv();
		Computer c = new Computer();
		b.buy(t); b.buy(c); //Product p�� ������� t, c�� �Ǹ�. p[0] = t, p[1] = c.
		System.out.println("���� �� �ܾ�: "+b.money);
		System.out.println("���� �� ����Ʈ: "+b.point);
		b.summary();
		
	}
}
