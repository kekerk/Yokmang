package chap7;

public class Exam2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coin c1 = new Coin();
		Coin c2 = new Coin();
		int c1cnt = 0, c2cnt = 0;
		// c1cnt�� 3�̻��̸� c1�¸�. �ƴϸ� c2�¸�.
		while(true) {
			c1.flip();
			c2.flip();
			if(c1.side == 0) {
				System.out.print("�ո�\t");
				c1cnt++;
			}
			else {
				System.out.print("�޸�\t");
				c1cnt=0;
			}
			
			if(c2.side == 0) {
				System.out.println("�ո�\t");
				c2cnt++;
			}
			else {
				System.out.println("�޸�\t");
				c2cnt=0;
			}
			if(c1cnt==3 || c2cnt==3) {
				break;
			}
		}
		if(c1cnt > c2cnt)
			System.out.println("c1�¸�");
		else if(c1cnt < c2cnt)
			System.out.println("c2�¸�");
		else 
			System.out.println("���º�");
	}

}
