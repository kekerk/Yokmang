package chap6;

public class Q1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=10;i++) {
			System.out.print("(");
			for(int j=1;j<=i;j++) {
				sum+=j;
				System.out.print(j+((j!=i)?"+":""));  //조건문을 활용하자.
			}
			System.out.print(")"+((i==10)?"=":"+"));
		}
		System.out.println(sum);	
	
	}

}
