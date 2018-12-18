package chap6;

/*
 * 5명 학생의 국어 영어 수학 점수를 학생별 총점, 평균을 출력하고
 * 과목별 총점을 출력하는 프로그램 구현하기.
 */
public class Exam9 {
	public static void main(String[] args) {
		int[][] score = { { 100, 90, 80 }, { 80, 95, 100 }, { 80, 65, 90 }, { 90, 75, 90 }, { 100, 60, 70 } };
		int sum1 = 0;//학생별 총점
		
		int j = 0;
		int i = 0;
		int[] total = new int[3];//국어 , 영어, 수학의 총점 저장 배열 선언
		System.out.println("\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
		for (i = 0; i < score.length; i++) {
			System.out.print(i + 1 + "번 학생: ");
			sum1 = 0; // 학생별 총점 저장
			
			for (j = 0; j < score[i].length; j++) {

				System.out.print(score[i][j] + "\t");

				sum1 += score[i][j];
				
				total[j] += score[i][j];  //열의 총합을 구하는 식
				
			}
			
			System.out.print(sum1 + "\t");
			System.out.println((double) sum1 / score[i].length);
			

		}	
		
//			System.out.println("과목별 합:\t"+total[0]+"\t"+total[1]+"\t"+total[2]+"\t"+(total[0]+total[1]+total[2])+"\t"+(total[0]+total[1]+total[2])/total.length);

		System.out.print("과목별 합:\t");
		for(int s=0;s<total.length;s++) {
			
			System.out.print(total[s] + ((s==total.length-1)?"\t메롱":"\t"));
		}
		
	
	
	}
}