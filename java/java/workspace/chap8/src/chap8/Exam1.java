package chap8;

/*
 * SutdaCard 20장으로 이루어진 SutdaDeck 클래스 구현하기.
 * 1. 멤버변수
 * 	SutdaCard 20장을 가지고 있다. 
 * 	SutdaCard는 같은 수의 카드가 2장씩 총 20장으로 이루어져있다.
 * 	그 중 1,3,8 번호의 카드는 두장 중 한장이 광인 카드다.
 * 2. 생성자
 * 	SutdaCard 20장을 생성하여 멤버 변수인 배열에 저장하기.
 * 3. 메서드
 * 	a. void shuffle()
 *     기능 : 카드의 위치를 뒤섞는다.
 *     
 *  b. SutdaCard pick(int index)
 *  	기능 : index에 해당하는 카드를 반환한다.
 *  c. SutdaCard pick()
 *  	기능 : 임의의 카드 한장을 반환한다.
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
//SutdaCard 의 기능을 이용하기 위해. SutdaCard 객체 생성.
	SutdaCard[] cards = new SutdaCard[20];

	SutdaDeck() { //생성자
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new SutdaCard((i % 10 + 1), ((i == 0 || i == 2 || i == 7) ? true : false));
		}
	}

	// 카드 섞기.
	void shuffle() { 
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random() * 20);
			int b = (int) (Math.random() * 20);
			SutdaCard tmp = cards[a];
			cards[a] = cards[b];
			cards[b] = tmp;
		}
	}
	//index번지의 카드 불러오기
	SutdaCard pick(int index) {
		return cards[index];
		
	}
	//임의의 카드 선택
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
		System.out.println(deck.toString()); // 섞기 전 순서대로
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pick(0).info());
		System.out.println(deck.pick().info());
	}

}
