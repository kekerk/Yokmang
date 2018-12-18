package chap12;

public class StringBufferEx2 {

	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
		sb.append("abc").append(123).append('A').append(false);
		System.out.println(sb);
		sb.delete(2, 4);
		System.out.println(sb);
		sb.deleteCharAt(4); //index�� 4�� �ڸ��� ���ڸ� �����. 
		System.out.println(sb);
		sb.insert(5, "==");// index�� 5�� �ڸ��� == ����ִ´�. (�������� �ڷ� �и�)
		System.out.println(sb);
		sb.insert(6, 1.23);// index�� 6�� �ڸ��� 1.23�� ����ִ´�. (�������� �ڷ� �и�)
		System.out.println(sb);
		
		
		sb = new StringBuffer("ABCDEFG");
		sb.replace(0, 3, "abc"); // index�� 0���� 3 �ձ����� ���ڿ��� abc�� �ٲ۴�.
		System.out.println(sb);
		sb.reverse(); // ���ڿ� ���� �ݴ��.
		System.out.println(sb);
	}

}
