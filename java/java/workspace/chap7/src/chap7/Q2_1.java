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


public class Q2_1 {

	public static void main(String[] args) {
		int t = (int)((Math.random()*9)+1);
		Circle[] cir = new Circle[t];
		
		for(int i=0;i<cir.length;i++) {
			cir[i] = new Circle();
			cir[i].serialNo = ++Circle.count;
				cir[i].r=(int)(Math.random()*9+1);
				cir[i].x=(int)(Math.random()*9+1);
				cir[i].y=(int)(Math.random()*9+1);
				cir[i].n=(int)(Math.random()*9+1);
				cir[i].m=(int)(Math.random()*9+1);
				cir[i].mul=(int)(Math.random()*9+1);
				System.out.println(cir[i].serialNo+"�� ��");
				System.out.println(cir[i]);
				cir[i].area();
				cir[i].move();
				cir[i].scale();
				System.out.println();
			}
			
		}
		
	}


