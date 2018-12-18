package chap18;
//�ڹ� API �� Runnable �������̽��� FunctionalInterface


public class LambdaEx3 {
	public static void main(String[] args) {
		// Runnable ���� Ŭ������ ���� ���� �ʿ䰡 ����.
		Runnable r = () -> {
			int sum =0;
			for(int i=1;i<=100;i++) {
				sum+=i;
			}
			try {
				Thread.sleep(1000);
				System.out.println("1���� 100������ ��:"+sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
		System.out.println("main �޼��� ����");
		

	}

}
