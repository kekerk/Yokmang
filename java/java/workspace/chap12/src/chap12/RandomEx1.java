package chap12;
import java.util.Random;
/*
 * Random Ŭ���� : ���� �߻� Ŭ����.
 * 			1. �ڷ��� ���� ���� �߻�.
 * 				nextInt()     : ������ ���� ����
 * 				nextInt(n)    : 0 <= x < n ������ ���� ����.
 * 				nextDouble()  : �Ǽ��� ���� ����. (0 <= x < 1.0)
 * 				nextBoolean() : true, false �� �� �ϳ� ����.
 * 			2. seed ���� ����.
 * 				
 */
public class RandomEx1 {
	public static void main(String[] args) {
		Random rand = new Random();
		//setSeed(long):seed ����.
		//System.currentTimeMillis() : 1970����� ���ݱ����� �ð��� �и��ʷ� ����.
		//                             ���� ������ ǥ���� �� ����. ���� ����.
		rand.setSeed(System.currentTimeMillis());
		//
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand.nextInt(1000));
		}
		
		Random rand1 = new Random();
		Random rand2 = new Random();
		//seed���� ���� ������ ������ �����ȴ�.
		//seed���� ������ �ٸ� ��ü�� ���� �������� ǥ����.
		//.setSeed(long l);
		rand1.setSeed(0L); rand2.setSeed(0L);
		System.out.println("rand1 ���� ==>");
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand1.nextInt(10));
		}
		System.out.println("rand2 ���� ==>");
		for(int i=0;i<5;i++) {
			System.out.println(i+":"+rand2.nextInt(10));
		}
		
		
	}
}
