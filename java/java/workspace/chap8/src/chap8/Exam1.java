package chap8;

/*
 * SutdaCard 20������ �̷���� SutdaDeck Ŭ���� �����ϱ�.
 * 1. �������
 * 	SutdaCard 20���� ������ �ִ�. 
 * 	SutdaCard�� ���� ���� ī�尡 2�徿 �� 20������ �̷�����ִ�.
 * 	�� �� 1,3,8 ��ȣ�� ī��� ���� �� ������ ���� ī���.
 * 2. ������
 * 	SutdaCard 20���� �����Ͽ� ��� ������ �迭�� �����ϱ�.
 * 3. �޼���
 * 	a. void shuffle()
 *     ��� : ī���� ��ġ�� �ڼ��´�.
 *     
 *  b. SutdaCard pick(int index)
 *  	��� : index�� �ش��ϴ� ī�带 ��ȯ�Ѵ�.
 *  c. SutdaCard pick()
 *  	��� : ������ ī�� ������ ��ȯ�Ѵ�.
 */
class SutdaCard {
	int number;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int number, boolean isKwang) {
		this.number = number;
		this.isKwang = isKwang;
	}

	String info() {
		return number + (isKwang ? "K" : " ");
	}

}

class SutdaDeck {
//SutdaCard �� ����� �̿��ϱ� ����. SutdaCard ��ü ����.
	SutdaCard[] cards = new SutdaCard[20];

	SutdaDeck() { //������
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new SutdaCard((i % 10 + 1), ((i == 0 || i == 2 || i == 7) ? true : false));
		}
	}

	// ī�� ����.
	void shuffle() { 
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random() * 20);
			int b = (int) (Math.random() * 20);
			SutdaCard tmp = cards[a];
			cards[a] = cards[b];
			cards[b] = tmp;
		}
	}
	//index������ ī�� �ҷ�����
	SutdaCard pick(int index) {
		return cards[index];
		
	}
	//������ ī�� ����
	SutdaCard pick(){
		return cards[(int) (Math.random() * 20)];
	}
	
	public String toString() {
		String s = " ";
		for (int i = 0; i < cards.length; i++) {
			s += cards[i].info() + ",";

		}
		return s;
//		for (SutdaCard c : cards) {
//			s += c.info() + ",";
//
//		}
//		return s;

	}

}

public class Exam1 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		System.out.println(deck.toString()); // ���� �� �������
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pick(0).info());
		System.out.println(deck.pick().info());
	}

}
