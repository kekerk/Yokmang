package chap4;
/*p.46
 * ���������� ����
 * 
 */
public class OpEx1 {

	public static void main(String[] args) {
		int x=5, y=5;
		x++; //x��� ���� 1 ����. 5->6
		y--; //y��� ���� 1 ����. 5->4
		System.out.println("x="+x+",y="+y);
		x=y=5; //x��y�� 5�� �������.
		++x; //
		--y;
		System.out.println("x="+x+",y="+y);
			

	}

}
