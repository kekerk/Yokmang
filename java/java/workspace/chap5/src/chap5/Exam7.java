package chap5;

/*
 *  중첩반목문을 이용하여 구구단을 옆으로 출력하기
 */
public class Exam7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for (int i = 2; i <= 9; i++) {
			
			System.out.print(i + "단 \t");
		
		}
		System.out.println("\n");
		
		for (int j = 1; j <= 9; j++) {
			
			
						
			for (int i = 2; i <= 9; i++) {
				
				System.out.print(i + "*" + j + "=" + (j * i)+"\t");
			
			}
			System.out.println("\n");
		}
		
	}

}
