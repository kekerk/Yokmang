package test;

public class Test5 {

	public static void main(String[] args) {
		char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
		};
		
		char[][] star2 = new char[star[0].length][star.length];
		System.out.println("원본 배열 출력");
		for(int i=0;i<star.length;i++) {
			for(int j=0;j<star[i].length;j++) {
				System.out.print(star[i][j]);
				
			}
			System.out.println();
			
		}
		
		
		System.out.println("90도 회전된 배열");
		for(int i=0;i<star2.length;i++) {
			for(int j=0;j<star2[i].length;j++) {
				star2[i][j] = ' ';
			}
		}
		
		
		
		for(int i=0;i<star.length;i++) {
			for(int j=0;j<star[i].length;j++) {
				star2[j][star.length-1-i] = star[i][j];
				
			}
			
		}
		
		for(int i=0;i<star2.length;i++) {
			for(int j=0;j<star2[i].length;j++) {
				System.out.print(star2[i][j]);
			}
			System.out.println();
		}
		

	}

}
