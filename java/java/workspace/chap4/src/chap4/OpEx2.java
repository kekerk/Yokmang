package chap4;

public class OpEx2 {

	public static void main(String[] args) {
		int x=5, y=5;
		x++; //x��� ���� 1 ����. 5->6
		y--; //y��� ���� 1 ����. 5->4
		System.out.println("x="+x+",y="+y);
		x=y=5; //x��y�� 5�� �������.
		++x; //
		--y;
		System.out.println("x="+x+",y="+y);
		x=5;
		y=x++; //���Կ����� ���� ����ǰ� x++�� ����
		System.out.println("x="+x+",y="+y); //x=6, y=5 
		x=5;
		y=++x;
		System.out.println("x="+x+",y="+y); //x=6, y=6 ++x�� ���� ����ǰ� �״��� ���Կ��� ����, 
		System.out.println("x="+ x++); //6�� ���� ������� ����, �״��� �ڱⰡ �ϳ� ����, 7�� ����
		System.out.println("x="+ ++x); // ���� 7�� 8�� �ϳ� ����, �״��� 8�� ���.
		System.out.println("x="+ --x +",y=" + y--);
		System.out.println("x="+x+",y="+y);
	}

}
