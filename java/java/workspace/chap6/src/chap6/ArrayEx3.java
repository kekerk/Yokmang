package chap6;
/*
 * Lotto 번호 생성하기 : 1~45까지의 수중 임의의 6개 선택.
 */
public class ArrayEx3 {

	public static void main(String[] args) {
	
		int[] balls = new int[45];
		int[] lotto = new int[6];
		
		//1~45까지의 숫자를 balls 배열에 저장
		
		for(int i=0;i<balls.length;i++) {
			balls[i]=i+1;
		}
		//번호 섞기
		for(int i=0; i<1000; i++) {
			int f = (int)(Math.random()*45);
			int d = (int)(Math.random()*45);
			int tmp = balls[f];
			balls[f]=balls[d];
			balls[d]=tmp;
		}
		//0~5까지 선택하여 lotto 번호로 저장하기
		for(int i=0; i<lotto.length;i++) {
			lotto[i]=balls[i];
			System.out.print(lotto[i]+" ");
		}
		
		System.out.println(" ");
		// lotto 번호 정렬
		for(int i=0;i<lotto.length;i++) {  /// 6바퀴 돌린다.
			boolean change = false;
			for(int j=0;j<lotto.length-1-i;j++) { // -i 는 제일 큰수가 끝으로 갔기 때문에 그 전까지만 다시 한다는 뜻.
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
