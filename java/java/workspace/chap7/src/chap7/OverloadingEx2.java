package chap7;
/*
 * �޼��� �����ε� 
 *    -> ���� Ŭ���� ���ο� ���� �̸��� ���� �޼��尡 ������ ���� ������.
 *    -> �� �Ű����� ����� �޶�� �Ѵ�.
 *     ( �������� �ƴϰ� �ڷ����� �޶���Ѵ�. ����,����, �ڷ�����ü )
 *     1. �޼��� ���� ����.
 *     2. �Ű������� �ٸ���.
 *     3. return Ÿ���̳� ���� �����ڴ� ����� ����.
 *     
 *     
 *     �����ε��� �޼����� ���� ����
 *     1.�޼���ȣ�� �� �Էµ� �Ű��������� �ڷ����� �޼����� ������� �ڷ����� ����
 *     2. 1�� ������ ���� ��� �ּҰ����� �ڵ�����ȯ�ϴ� �Ű������� ���� �޼��带 ����.
 *     ���� : ������ ���� ������ �Ǵ� �޼��尡 �������� ��� ���� �߻�.-
 */
class Math4{

	int add(int a, int b) {
		System.out.print(" int int �޼��� ���: ");
		return a+b;
	}
	long add(long a, int b) {
		System.out.print(" long int �޼��� ���: ");
		return a+b;
	}
	long add(int a, long b) {
		System.out.print(" int long �޼��� ���: ");
		return a+b;
	}
	long add(long a, long b) {
		System.out.print(" long long �޼��� ���: ");
		return a+b;
	}
	
}
public class OverloadingEx2 {

	public static void main(String[] args) {
		Math4 m4 = new Math4();
		System.out.println(m4.add(10, 10));  //int int �� �ּ�ó���ϸ� 2���� add������ �浹
		System.out.println(m4.add(10L, 10)); //long Ÿ���� int Ÿ�� ������ �� �� ����.
		System.out.println(m4.add(10, 10L));
		System.out.println(m4.add(10L, 10L));
		
	}

}
