package chap6;

/*
 * 5�� �л��� ���� ���� ���� ������ �л��� ����, ����� ����ϰ�
 * ���� ������ ����ϴ� ���α׷� �����ϱ�.
 */
public class Exam9 {
	public static void main(String[] args) {
		int[][] score = { { 100, 90, 80 }, { 80, 95, 100 }, { 80, 65, 90 }, { 90, 75, 90 }, { 100, 60, 70 } };
		int sum1 = 0;//�л��� ����
		
		int j = 0;
		int i = 0;
		int[] total = new int[3];//���� , ����, ������ ���� ���� �迭 ����
		System.out.println("\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "����" + "\t" + "���");
		for (i = 0; i < score.length; i++) {
			System.out.print(i + 1 + "�� �л�: ");
			sum1 = 0; // �л��� ���� ����
			
			for (j = 0; j < score[i].length; j++) {

				System.out.print(score[i][j] + "\t");

				sum1 += score[i][j];
				
				total[j] += score[i][j];  //���� ������ ���ϴ� ��
				
			}
			
			System.out.print(sum1 + "\t");
			System.out.println((double) sum1 / score[i].length);
			

		}	
		
//			System.out.println("���� ��:\t"+total[0]+"\t"+total[1]+"\t"+total[2]+"\t"+(total[0]+total[1]+total[2])+"\t"+(total[0]+total[1]+total[2])/total.length);

		System.out.print("���� ��:\t");
		for(int s=0;s<total.length;s++) {
			
			System.out.print(total[s] + ((s==total.length-1)?"\t�޷�":"\t"));
		}
		
	
	
	}
}