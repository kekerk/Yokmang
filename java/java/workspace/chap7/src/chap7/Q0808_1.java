package chap7;

class SutdaCard {
	int number;
	boolean isKwang;
	
	SutdaCard(){
//		number=1;
//		isKwang = true;
		this(1,true);
	}
	
	SutdaCard(int number, boolean isKwang){
	
		this.number=number;
		this.isKwang = isKwang;
	}
	
//	boolean t() {
//		return isKwang;
//	}
	String info() {
		return number+(isKwang? "K":" ") ;
	}
	
}
public class Q0808_1 {

	public static void main(String[] args) {
		
		
		SutdaCard card1 = new SutdaCard(3,false);

		  SutdaCard card2 = new SutdaCard();

		  System.out.println(card1.info());//3

		  System.out.println(card2.info());//1K

	}

}
