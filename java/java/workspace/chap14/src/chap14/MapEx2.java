package chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SutdaCard { //cards 생성 및 숫자 지정.
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
	Map<String, Integer> jokbo = new HashMap<String, Integer>(); //jokbo라는 map 객체 생성.

	SutdaDeck() {
		for (int i = 0; i < 20 ; i++) {
			cards.add(new SutdaCard((i%10)+1, (i == 0 || i == 2 || i == 7) ? true : false)); //1,3,8일때 K
	
		}
		
		setJokbo();
	}
	
	private void setJokbo() { //족보에 패의 수와 그 수에 대한 점수 쌍으로 저장. map
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
		//Collections 클래스 : Collection의 다양한 기능을 가진 클래스.
		Collections.shuffle(cards); //알아서 cards를 섞음. List 객체의 순서 섞기.
	}
	
	public SutdaCard pick() { //위에서 SutdaCard 한장 빼내서 리턴. 
		return cards.remove(0);  //0번지에 있는 카드 없어짐.
		
	}
	
} //플레이어 인원 수 설정. 2~ 10 명.
class Player {
	String name;
	SutdaCard card[] = new SutdaCard[2];
	Player(String name, SutdaCard c1, SutdaCard c2) {
		this.name= name;
		//카드 2장 뿌리기
		card[0] = c1; 
		card[1] = c2;
		
	}
	@Override
	public String toString() {
		return name + ":"+card[0]+","+card[1];
	}
	
	public int getPoint(Map<String,Integer> jokbo) { //점수 출력.
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
		deck.Shuffle(); //섞는다.
		Player p1 = new Player("홍길동",deck.pick(),deck.pick()); //위에서 두장. deck에서는 없어지고 플레이어에게 들어감.
		Player p2 = new Player("김삿갓",deck.pick(),deck.pick()); //그 다음 위에서 두장.
		System.out.println(p1+":"+p1.getPoint(deck.jokbo));
		System.out.println(p2+":"+p2.getPoint(deck.jokbo));
		if(p1.getPoint(deck.jokbo)>p2.getPoint(deck.jokbo)) {
			System.out.println(p1.name+"승리");
		}else if(p2.getPoint(deck.jokbo)> p1.getPoint(deck.jokbo)) {
			System.out.println(p2.name+"승리");
		}else {
			System.out.println(p1.name+"과"+p2.name+"비김.");
		}
		
	}

}
