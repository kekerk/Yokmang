package exercise;
//1. Food, Fruit, Drink, Snack, Apple, Peach, Cock, Sidar, Biscuit, Cookie Ŭ������ �����ϱ� 
//
//��� �ķ�ǰ(Food)�� ����(price)�� �ǸŰ���(sellcnt), ���ʽ�����Ʈ(point)�� ������ �ֽ��ϴ�. 
//
//�ķ�ǰ ��ü�� �����ϱ� ���ؼ��� ������  �Է¹޾ƾ� �մϴ�. 
//
//�ķ�ǰ�� �����δ� ����(Fruit), ����(Drink),����(Snack)�� ������ ���ϴ�. 
//
//������ �絵(brix)��,����� �뷮(ml)�� ���ڴ¹���(gram) ������ ������ �ֽ��ϴ�.   
//
//���Ͽ��� ���(Apple)�� ������(Peach)  ���ῡ�� �ݶ�(Cock) ���̴�(Sidar)
//
//���ڴ�   ��Ŷ(Biscuit)�� ��Ű(Cookie)�� �ֽ��ϴ�.
//
//��� �����ƴ� ���ݰ� �絵�� �Է��Ͽ� ��ü�� �����ϰ�,
//
//�ݶ�, ���̴ٴ°���, �뷮�� 
//
//���ڴ� ����,���Ը�  �Է��Ͽ�  ��ü�� �����մϴ�. 

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
		super(price); //super�� ���� ���� �ۼ��ؾ� �Ѵ�.
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
		System.out.println("��� ����: "+a.price);
		System.out.println("��� �絵: "+a.brix);
		peach p = new peach(3000,16.5);
		System.out.println("������ ����: "+p.price);
		System.out.println("������ �絵: "+p.brix);

	}

}
