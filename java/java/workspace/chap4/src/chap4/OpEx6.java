package chap4;
/*
 * ��Ʈ ������ ���� :
 * &,|,^,~
 * & : ��� ��Ʈ�� and
 * | : ��� ��Ʈ�� or
 * ^ : ��� ��Ʈ�� xor
 * ~ : not, 0->1 , 1-> 0 ��ȯ
 */
public class OpEx6 {

	public static void main(String[] args) {
		System.out.println(6&3);
		System.out.println(6|3);
		System.out.println(6^3);
		System.out.println(~255);
/*
 *  10 : 00001010
 * ~10 : 11110101  ��ȣ ��Ʈ�� 1 : ����
 *  �ڹ��� ������ 2�� ������ ǥ��
 *  1110101 : ?�� 2�� ���� (2�Ǻ����� 1�Ǻ��� +1)
 *  ? �� 1110101�� ������ ����� 
 *  1�� ���� :0001010
 *     +1  : 0001011 1110101��  11�� 2�� ����
 *     ����� -11�� ��µ�.
 */
		
	}

}