package chap7;
/*
 *  ������ ����
 *  �����ڶ� ��ü ���� �� ȣ��Ǵ� Ư���� �޼���.
 *  ������ ���� ��ü ������ �Ұ�.
 *  �ֿ� ����� �޸� ������ �ƴϰ�, �ν��Ͻ������� �ʱ�ȭ�� ����Ѵ�.
 *  �����ڴ� Ŭ������ �̸��� ����, ����Ÿ���� ����. void�� �ƴϰ� ������� �ʴ´�.
 *  �����ڴ� �����ε��� �����ϴ�.
 *  
 *  �⺻������ : �����ڰ� �����ڸ� �������� ������ �����Ϸ��� �߰��ϴ� �⺻������.
 *  		 public Ŭ������() {            }
 */

class Number1{ //�⺻�����ڰ� ������.
	int num;
}
class Number2{
	int num;
	Number2(int x) {
		num = 'x';  //������
	} //returnŸ�� ����.
}
public class ConstructorEx1 {
	public static void main(String[] args) {
		Number1 n1 = new Number1(); //new ������ �ִ� Number1()�� ������.
		/*
		 *  new ����� ���
		 *  1. �� ������ �޸� �Ҵ�
		 *  2. ��������� �ʱ�ȭ
		 *  3. ������ (Number1())ȣ��
		 */
		n1.num = 10;
		Number2 n2 = new Number2(20);
		System.out.println("n1 ��ü�� num = " + n1.num);
		System.out.println("n2 ��ü�� num = " + n2.num);
		
	}

}
