package chap7;

public class Exam2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coin c1 = new Coin();
		Coin c2 = new Coin();
		int c1cnt = 0, c2cnt = 0;
		// c1cnt°¡ 3ÀÌ»óÀÌ¸é c1½Â¸®. ¾Æ´Ï¸é c2½Â¸®.
		while(true) {
			c1.flip();
			c2.flip();
			if(c1.side == 0) {
				System.out.print("¾Õ¸é\t");
				c1cnt++;
			}
			else {
				System.out.print("µÞ¸é\t");
				c1cnt=0;
			}
			
			if(c2.side == 0) {
				System.out.println("¾Õ¸é\t");
				c2cnt++;
			}
			else {
				System.out.println("µÞ¸é\t");
				c2cnt=0;
			}
			if(c1cnt==3 || c2cnt==3) {
				break;
			}
		}
		if(c1cnt > c2cnt)
			System.out.println("c1½Â¸®");
		else if(c1cnt < c2cnt)
			System.out.println("c2½Â¸®");
		else 
			System.out.println("¹«½ÂºÎ");
	}

}
