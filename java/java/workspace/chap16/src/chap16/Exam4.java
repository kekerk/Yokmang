package chap16;
/*
 * SumThread�� �̿��Ͽ� 1���� 1000������ ���� ���ϱ�. �迭 ���.
 */


public class Exam4 {
	public static void main(String[] args) throws Exception {
		sumThread[] st = new sumThread[10];
		int tsum = 0;
		for(int i=0;i<st.length;i++) {
			st[i] = new sumThread(i*100+1,(i+1)*100);
			st[i].start();
			st[i].join();
			tsum+=st[i].sum;
		}
		System.out.println("�����");
		Thread.sleep(1000);
		System.out.println("1���� 1000������ ��: "+tsum);
	}
}
