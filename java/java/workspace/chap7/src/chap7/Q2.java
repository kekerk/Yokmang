package chap7;
/*
 * 2. 

1, ��(Circle) Ŭ���� ����

    1) ������� :

        ������, ����x��ǥ, ����y��ǥ, ���� ��ȣ no, 

        ���� ��ȣ�� ���������ִ� count (static����)

   2) ��� �޼ҵ�

        a. area : ���� ���̸� ����ϴ� �޼ҵ�

                 Math.PI

        b. move : ���� �̵���Ű�� �޼ҵ�  (x+ mx, y+ my)

        c. scale: ���� Ȯ�� ����ϴ� �޼ҵ� (r = r x 3)

        d. toString : ���� �߽����� �������� ����ϴ� �޼ҵ�





2. ���� Ŭ����(CircleEx) ����

    1) �� ��ü���� ������ ����

    2) �� ���� ��ȣ, ������, x��ǥ, y��ǥ�� ����ϱ�
 */

class Circle {
	int r;
	int x;
	int y;
	int n,m;
	int mul;
	int serialNo;
	static int count;
	
	void area() {
		System.out.println("�������� "+r+"�� ���� ���̴� "+ (double)Math.PI*r*r);
	}
	
	void move() {
		System.out.println("��ǥ �� ("+x+","+y+")�� ��ġ�� ���� x������ "+n+"��ŭ, y������ "+m+"��ŭ ������ ���� ��ǥ�� ("+(n+x)+","+(m+y)+")");
	}
	
	void scale() {
		System.out.println("�������� "+r+"�� ���� �������� "+ mul + "��� �ϸ� �� �������� "+(r*mul));
	}
	
	public String toString() {
		return "�������� "+r+"�̰�, �߽� ��ǥ�� ("+x+","+y+")";
	}
	
}
public class Q2 {

	public static void main(String[] args) {
		Circle[] cir = new Circle[3];
		
		for(int i=0;i<cir.length;i++) {
			cir[i] = new Circle();
			cir[i].serialNo = ++Circle.count;
			switch(cir[i].serialNo) {
			
			case 1:
				cir[i].r=(int)(Math.random()*9+1);
				cir[i].x=(int)(Math.random()*9+1);
				cir[i].y=(int)(Math.random()*9+1);
				cir[i].n=(int)(Math.random()*9)+1;
				cir[i].m=(int)(Math.random()*9+1);
				cir[i].mul=(int)(Math.random()*9+1);
				break;
			case 2:
				cir[i].r=(int)(Math.random()*9+1);
				cir[i].x=(int)(Math.random()*9+1);
				cir[i].y=(int)(Math.random()*9+1);
				cir[i].n=(int)(Math.random()*9+1);
				cir[i].m=(int)(Math.random()*9+1);
				cir[i].mul=(int)(Math.random()*9+1);
				break;
			case 3:
				cir[i].r=(int)(Math.random()*9+1);
				cir[i].x=(int)(Math.random()*9+1);
				cir[i].y=(int)(Math.random()*9+1);
				cir[i].n=(int)(Math.random()*9+1);
				cir[i].m=(int)(Math.random()*9+1);
				cir[i].mul=(int)(Math.random()*9+1);
				break;
			}
			System.out.println(cir[i].serialNo+"�� ��");
			System.out.println(cir[i]);
			cir[i].area();
			cir[i].move();
			cir[i].scale();
			System.out.println();
		}
		
	}

}
