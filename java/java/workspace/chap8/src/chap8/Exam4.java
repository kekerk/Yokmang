package chap8;
/*
 * 
 */

class Buyer2 {
	int money = 10000;
	int point;
	Food[] foods = new Food[20];
	int index;

	int fruitCnt, drinkCnt, snackCnt;

	void buy(Food f) {
		if (money < f.price) {
			System.out.println("�ܾ� ����");
			return;
		}
		money -= f.price;
		point += f.point;
		System.out.println(f + "����/����" + f.price);
		foods[index++] = f;
		f.sellcnt++;
		
	}

	void summary() {
		int sum = 0;
		String fruitList = "";
		String drinkList = "";
		String snackList = "";

		for (Food f : foods) {
			if (f == null)
				break;

			if (f instanceof Fruit) { //��ü�� ���� Ŭ������ 
				fruitCnt++;
				fruitList += f + ",";
			}
			if (f instanceof Drink) {
				drinkCnt++;
				drinkList += f + ",";
			}
			if (f instanceof Snack) {
				snackCnt++;
				snackList += f + ",";
			}

			sum += f.price;

		}
		System.out.println("�� ���� �ݾ�: " + sum);
		System.out.println("������ ����Ʈ: " + point);
		System.out.println("���� ����: " + fruitCnt);
		System.out.println("���� ���: " + fruitList);
		System.out.println("���� ����: " + drinkCnt);
		System.out.println("���� ���: " + drinkList);
		System.out.println("���� ����: " + snackCnt);
		System.out.println("���� ���: " + snackList);
		System.out.println("�ܾ�: " + money);

	}

}

public class Exam4 {

	public static void main(String[] args) {

		Buyer2 b = new Buyer2();
		Apple a1 = new Apple(1000, 10);
		Peach p1 = new Peach(3000, 15);
		Cock c = new Cock(900, 500);
		Sidar s = new Sidar(1200, 1000);
		Biscuit bis = new Biscuit(500, 50);
		Cookie coo = new Cookie(5000, 500);
//		System.out.println(a1);
//		System.out.println(p1);
//		System.out.println(c);
//		System.out.println(s);
//		System.out.println(bis);
//		System.out.println(coo);
		b.buy(a1);
		b.buy(p1);
		b.buy(bis);
		b.buy(bis);
		b.buy(bis);
		b.buy(bis);
		b.buy(coo);
		b.buy(c);
		b.buy(s);
		b.summary();

	}

}
