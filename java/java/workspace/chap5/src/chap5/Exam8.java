package chap5;

public class Exam8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//우측 삼각형 출력
		for (int i = 0; i <= 10; i++) {
			
			
			
			for (int j = 0; j <= 10; j++) {
				
				if (j>=10-i)
				System.out.print("*");
				else
				System.out.print(" ");
			}
		System.out.println();
		}
		
//우측 역삼각형 출력		
		for (int i = 0; i <= 10; i++) {
			
			
						
			for (int j = 0; j <= 10; j++) {
				
				if (i<=(j))
				System.out.print("*");
				else
				System.out.print(" ");
			}
		System.out.println();
		}
//이등변삼각형
	
		
	}

}
