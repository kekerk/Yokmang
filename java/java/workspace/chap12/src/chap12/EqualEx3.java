package chap12;
/*
 * ���� Ŭ�������� equals �޼��带 �������̵��� �Ͽ� ����񱳷� �����.
 * equals �޼���� ����񱳷� ���Ǵ� �޼���.
 * �⺻�ڷ����� ������ ��κ��� �����ڷ����� equals��� �޼��带 overring �Ͽ� ����񱳸� �� �� �ֵ��� �Ǿ��ִ�.
 * ���� : ��ü�� ���� �񱳸� ���ؼ��� equals �޼��带 ����ؾ� ��.
 *  
 */
public class EqualEx3 {
	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		if(s1==s2) {
			System.out.println("s1���ڿ� ��ü�� s2���ڿ� ��ü�� ���� ��ü��.");
		}else {
			System.out.println("s1���ڿ� ��ü�� s2���ڿ� ��ü�� �ٸ� ��ü��."); // s1, s2�� ��ü�� �ٸ���.
		}
		
		if(s1.equals(s2)) { //.equals()�� �������̵��ؾ� �Ѵ�.
			System.out.println("s1���ڿ��� s2���ڿ��� ���� ���ڿ���.");
		} else {
			System.out.println("s1���ڿ��� s2���ڿ��� �ٸ� ���ڿ���.");
		}
		/*
		 * hashcode�� ��ü�� ������ �� �ִ� ���� ��������.
		 * hashcode���� �ٸ��� �ٸ� ��ü��.
		 * ���� ����� ���� �������̵��� ��.
		 * equals �޼��带 �������̵��ϸ�, hashCode()�� �������̵��� �ϵ��� ������.
		 * String Ŭ������ hashCode()�� �������̵���.
		 */
		System.out.println("s1.hashcode()="+s1.hashCode());
		System.out.println("s2.hashcode()="+s2.hashCode());
		System.out.println("s1 ���� �ؽ��ڵ尪="+System.identityHashCode(s1));
		System.out.println("s2 ���� �ؽ��ڵ尪="+System.identityHashCode(s2));
		
		Equal e1 = new Equal("abc");
		Equal e2 = new Equal("abc");
		System.out.println("e1.hashcode()="+e1.hashCode());
		System.out.println("e2.hashcode()="+e2.hashCode());
		System.out.println("e1 ���� �ؽ��ڵ尪="+System.identityHashCode(e1));
		System.out.println("e2 ���� �ؽ��ڵ尪="+System.identityHashCode(e2));
		
//		Wrapper class 
		
	}
}
