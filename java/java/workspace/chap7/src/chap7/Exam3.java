package chap7;

/*
 * ���簢�� Ŭ���� �����ϱ�.
 * Rectangle Ŭ����
 *  �������: width, height, serialNo, static int sno
 *  ����޼��� : void area() ,void length()
 *  
 *  ���� Ŭ���� 
 *    �簢�� ��ü�� �����ϱ�. 3��  : �迭 �̿��ϱ�.
 *    1�� �簢���� ����  10 ���� 10
 *    2�� �簢���� ����  5 ���� 20
 *    3�� �簢���� ���� 15 ���� 2
 *    
 *    3���� �簢�� ������ ���� �ѷ� ���ϱ�.
 *    
 */
class rectangle {
	int width;
	int height;
	int serialNo;
	static int sno;

	void area() {
		System.out.println("���ΰ� " + width + "�̰� ���ΰ� " + height + "�� �簢���� ���̴� " + (width * height));
	}

	void length() {
		System.out.println("���ΰ� " + width + "�̰� ���ΰ� " + height + "�� �簢���� �ѷ��� " + (2 * (width + height)));
	}

	boolean IsSquare() {
		return width == height;
	}

}

public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = (int)((Math.random()*9)+1);
		rectangle[] a = new rectangle[3];

		for (int i = 0; i < a.length; i++) {
			a[i] = new rectangle();
		}

		a[0].width = 10;
		a[0].height = 10;
		a[0].serialNo = ++rectangle.sno;
		System.out.println(a[0].serialNo + "�� �簢��");
		a[0].area();
		a[0].length();
		System.out.println();
		a[1].width = 5;
		a[1].height = 20;
		a[1].serialNo = ++rectangle.sno;
		System.out.println(a[1].serialNo + "�� �簢��");
		a[1].area();
		a[1].length();
		System.out.println();
		a[2].width = 15;
		a[2].height = 2;
		a[2].serialNo = ++rectangle.sno;
		System.out.println(a[2].serialNo + "�� �簢��");
		a[2].area();
		a[2].length();
		System.out.println();

	}

}
