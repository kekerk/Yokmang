package chap6;

//������ ����� �������� ���α׷� �ۼ��ϱ� (1)+(1+2)+(1+2+3)+......+(1+2+3+....+10)=220
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=10;i++) {
			System.err.print("(");
			for(int j=1;j<=i;j++) {
				sum+=j;
				System.out.print(j);
			
			}
			System.err.print(")"+((i==10)?"=":"+"));
		}
		System.out.print(sum);	
	
	}

}

