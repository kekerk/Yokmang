package chap18;


@FunctionalInterface
interface LambdaInterface2{
	void method(int x); //����Ÿ�� ����, �Ű����� ����.
	
}
public class LambdaEx2 {
	public static void main(String[] args) {
		LambdaInterface2 f2;
		// ���� Ÿ���� ������ �Ű������� �ִ� ���.
		f2 = (x) -> {
			System.out.println(x);
		};
		f2.method(2);
		f2.method(20);
		// �Ű������� 1���� ��� () ���� ����.
		// �Ű������� ���� ��� () ���� �Ұ���.
		// ���� �� ������ �Ѱ��� ��� {} ���� ����.
		f2 = x -> System.out.println(x*100);
		f2.method(2); // 200
		f2.method(20); // 2000
		System.out.println();
		//���ٽ��� �̿��Ͽ� �Ű������� ��(����)������ ���� ���ϱ�.
		f2 = x -> {
			int sum = 0;
			for(int i=0;i<=x;i++) {
				sum+=i;
			}
			System.out.println(sum);
		};
		f2.method(100); // 1~100������ ��.
		f2.method(10); // 1~10������ ��
		
		
	}
}
