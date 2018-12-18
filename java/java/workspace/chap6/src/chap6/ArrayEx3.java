package chap6;
/*
 * Lotto ��ȣ �����ϱ� : 1~45������ ���� ������ 6�� ����.
 */
public class ArrayEx3 {

	public static void main(String[] args) {
	
		int[] balls = new int[45];
		int[] lotto = new int[6];
		
		//1~45������ ���ڸ� balls �迭�� ����
		
		for(int i=0;i<balls.length;i++) {
			balls[i]=i+1;
		}
		//��ȣ ����
		for(int i=0; i<1000; i++) {
			int f = (int)(Math.random()*45);
			int d = (int)(Math.random()*45);
			int tmp = balls[f];
			balls[f]=balls[d];
			balls[d]=tmp;
		}
		//0~5���� �����Ͽ� lotto ��ȣ�� �����ϱ�
		for(int i=0; i<lotto.length;i++) {
			lotto[i]=balls[i];
			System.out.print(lotto[i]+" ");
		}
		
		System.out.println(" ");
		// lotto ��ȣ ����
		for(int i=0;i<lotto.length;i++) {  /// 6���� ������.
			boolean change = false;
			for(int j=0;j<lotto.length-1-i;j++) { // -i �� ���� ū���� ������ ���� ������ �� �������� �ٽ� �Ѵٴ� ��.
				if(lotto[j]>lotto[j+1]) {
					int tmp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1]=tmp;
					change = true;
				}
			}
			if (!change) break;
			
		}
		
		for(int n : lotto) {
			System.out.print(n+" ");
		}
	}

}
