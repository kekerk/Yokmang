package chap5;

/*
 *  ��ø�ݸ��� �̿��Ͽ� �������� ������ ����ϱ�
 */
public class Exam7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for (int i = 2; i <= 9; i++) {
			
			System.out.print(i + "�� \t");
		
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
