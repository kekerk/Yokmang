package chap12;
/*
 *  wrapper class : 8���� �⺻ �ڷ����� ��üȭ�ϱ� ���� Ŭ����. �⺻�ڷ����� ������ �ִ� ������ ������ ����.
 *  
 *  �⺻�� 						wrapper Ŭ����
 *  ==============================================
 *  boolean						Boolean
 *  char						Character
 *  byte						Byte
 * 	short						Short
 *  int							Integer
 *  long						Long
 *  float						Float
 *  double						Double
 *  
 *  �⺻������ �⺻�ڷ����� �����ڷ��� ���̴� ���� ����ȯ �Ұ�.
 *  ��, �⺻�ڷ����� �����Ǵ� Wrapper Ŭ���� ���̿��� �ڵ� ����ȯ ��. (jdk5.0 ����)
 *  �⺻�� <= ������ : auto unboxing (�������� �⺻������ �ڵ� ����ȯ)
 *  ������ <= �⺻�� : auto boxing (�⺻���� ���������� �ڵ� ����ȯ) 
 *  
 *  
 */
public class WrapperEx1 {

	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println("i1==i2?"+(i1==i2)); //false
		System.out.println("i1.equals(i2)?"+(i1.equals(i2))); //���� ��. true
		System.out.println("i1==100?"+(i1==100)); //i1�� �⺻������ �ڵ�����ȯ��(100�̶�� ���ڿ� �������� ����)
		int i3 = 100;
		System.out.println("i2==i3?"+(i2==i3)); //i2�� ��ڽ�(�⺻������ ����ȯ)�� ��.
		Integer i4 =100; //boxing
		System.out.println("i1==i4?"+(i1==i4)); //false
		//��Ʈ�� 
		System.out.println("int�� bit ��:"+Integer.SIZE);
		System.out.println("byte�� bit ��:"+Byte.SIZE);
		//�ִ밪
		System.out.println("int�� �ִ밪: "+Integer.MAX_VALUE);
		//�ּҰ�
		System.out.println("int�� �ּҰ�: "+Integer.MIN_VALUE);
		//���� ǥ��
		System.out.println("8���� 12:"+Integer.parseInt("12",8)); //8���� 12�� 10������ 10
		System.out.println("16���� 12:"+Integer.parseInt("12",16)); //16���� 12�� 10������ 18
		//�������� 2����,8����,16����
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toHexString(10));
	}

}
