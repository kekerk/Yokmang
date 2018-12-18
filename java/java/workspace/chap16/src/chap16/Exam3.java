package chap16;

public class Exam3 {
	public static void main(String[] args) throws InterruptedException {
		Thread[] t = new Thread[10];
		Runnable2[] r = new Runnable2[10];
		int total = 0;
		for(int i=0;i<t.length;i++) {
			r[i] = new Runnable2(i*100+1,(i+1)*100);
			t[i] = new Thread(r[i]);
			t[i].start();
			t[i].join();
			Thread.sleep(1000);
			System.out.println((i+1)+":"+r[i].sum);
			total += r[i].sum;
		}
		System.out.println("1부터 1000까지의 합: "+ total);
		
		
	}
}
