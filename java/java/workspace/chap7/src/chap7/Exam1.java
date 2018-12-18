package chap7;

class Coin{
	int side;
	void flip() {
		side = (int)(Math.random()*2);
	}
	
	

}

public class Exam1 {

	public static void main(String[] args) {
		Coin coin = new Coin();
		
		coin.flip();
		switch(coin.side ) {
		case 0: System.out.println("¾Õ¸é"); break;
		case 1: System.out.println("µÞ¸é"); break;
		}

	}

}
