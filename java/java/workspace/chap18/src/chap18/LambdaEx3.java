package chap18;
//자바 API 중 Runnable 인터페이스는 FunctionalInterface


public class LambdaEx3 {
	public static void main(String[] args) {
		// Runnable 구현 클래스를 따로 만들 필요가 없다.
		Runnable r = () -> {
			int sum =0;
			for(int i=1;i<=100;i++) {
				sum+=i;
			}
			try {
				Thread.sleep(1000);
				System.out.println("1부터 100까지의 합:"+sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
		System.out.println("main 메서드 종료");
		

	}

}
