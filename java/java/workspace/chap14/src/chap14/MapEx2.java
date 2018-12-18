package chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SutdaCard { //cards ���� �� ���� ����.
	int num;
	boolean isKwang;

	public SutdaCard(int num, boolean isKwaing) {
		super();
		this.num = num;
		this.isKwang = isKwang;

	}

	public String toString() {
		return num + ((isKwang) ? "K" : " ");

	}
}

class SutdaDeck {
	List<SutdaCard> cards = new ArrayList<SutdaCard>();
	Map<String, Integer> jokbo = new HashMap<String, Integer>(); //jokbo��� map ��ü ����.

	SutdaDeck() {
		for (int i = 0; i < 20 ; i++) {
			cards.add(new SutdaCard((i%10)+1, (i == 0 || i == 2 || i == 7) ? true : false)); //1,3,8�϶� K
	
		}
		
		setJokbo();
	}
	
	private void setJokbo() { //������ ���� ���� �� ���� ���� ���� ������ ����. map
		jokbo.put("KK", 4000); 
		for( int i=1;i<=10;i++) {
			jokbo.put(""+i+i, 3000+(i*10));
		}
		
		jokbo.put("12", 2060);
		jokbo.put("21", 2060);
		jokbo.put("14", 2050);
		jokbo.put("41", 2050);
		jokbo.put("19", 2040);
		jokbo.put("91", 2040);
		jokbo.put("110", 2030);
		jokbo.put("101", 2030);
		jokbo.put("104", 2020);
		jokbo.put("410", 2020);
		jokbo.put("64", 2010);
		jokbo.put("46", 2010);
	}
	
	public void Shuffle() {
		//Collections Ŭ���� : Collection�� �پ��� ����� ���� Ŭ����.
		Collections.shuffle(cards); //�˾Ƽ� cards�� ����. List ��ü�� ���� ����.
	}
	
	public SutdaCard pick() { //������ SutdaCard ���� ������ ����. 
		return cards.remove(0);  //0������ �ִ� ī�� ������.
		
	}
	
} //�÷��̾� �ο� �� ����. 2~ 10 ��.
class Player {
	String name;
	SutdaCard card[] = new SutdaCard[2];
	Player(String name, SutdaCard c1, SutdaCard c2) {
		this.name= name;
		//ī�� 2�� �Ѹ���
		card[0] = c1; 
		card[1] = c2;
		
	}
	@Override
	public String toString() {
		return name + ":"+card[0]+","+card[1];
	}
	
	public int getPoint(Map<String,Integer> jokbo) { //���� ���.
		String key = ""+card[0].num + card[1].num;
		if(card[0].isKwang && card[1].isKwang) {
			return jokbo.get("KK");
			
		}else if(jokbo.containsKey(key)) {
			return jokbo.get(key);
			
		} else {
			return (card[0].num + card[1].num)%10;
		}
	}
}
public class MapEx2 {

	public static void main(String[] args) {
		
		SutdaDeck deck  = new SutdaDeck();
		deck.Shuffle(); //���´�.
		Player p1 = new Player("ȫ�浿",deck.pick(),deck.pick()); //������ ����. deck������ �������� �÷��̾�� ��.
		Player p2 = new Player("���",deck.pick(),deck.pick()); //�� ���� ������ ����.
		System.out.println(p1+":"+p1.getPoint(deck.jokbo));
		System.out.println(p2+":"+p2.getPoint(deck.jokbo));
		if(p1.getPoint(deck.jokbo)>p2.getPoint(deck.jokbo)) {
			System.out.println(p1.name+"�¸�");
		}else if(p2.getPoint(deck.jokbo)> p1.getPoint(deck.jokbo)) {
			System.out.println(p2.name+"�¸�");
		}else {
			System.out.println(p1.name+"��"+p2.name+"���.");
		}
		
	}

}
