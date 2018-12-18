package chap18;

import java.util.ArrayList;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 * Suppler �������̽� : �Ű������� ����, ���ϰ��� ����.
 */
public class LambdaEx7 {
	public static void main(String[] args) {
		// s1 : String Ÿ���� ���ϰ��� �ִ� �Լ� ��ü.
		Supplier<String> s1 = () -> {
			return "java";
		};
		System.out.println(s1.get());
		
		IntSupplier s2 = () -> {
			int num = (int)(Math.random()*10)+1;
			return num;
		};
		System.out.println("1���� 10������ ������ ��: " + s2.getAsInt());
		
		//Supplier�� �̿��Ͽ� 1���� 100������ �� ���ϱ�.
		s2 = () -> {
			int sum=0;
			for(int i=1;i<=100;i++) {
				sum+=i;
			}
			return sum;
		};
		System.out.println("1���� 100������ ��:"+ s2.getAsInt());
		// Supplier�� �̿��Ͽ� arr ����� �� ���ϱ�.
		Supplier s3 = () -> { //�Ű������� ������, ���ٽ� �ȿ��� ���� ���� �� ���ǹ�. �׸��� return������ ����.
			Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
			Integer sum= new Integer(0);
			for(int i=0;i<arr.length;i++) {
				sum+=arr[i];
			}
			return sum;
		};
		System.out.println("arr �迭 ����� ��:" + s3.get());
		
	}
}
