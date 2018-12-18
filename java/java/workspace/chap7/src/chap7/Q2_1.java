package chap7;
/*
 * 2. 

1, 원(Circle) 클래스 구현

    1) 멤버변수 :

        반지름, 원점x좌표, 원점y좌표, 원의 번호 no, 

        원의 번호를 생성시켜주는 count (static으로)

   2) 멤버 메소드

        a. area : 원의 넓이를 계산하는 메소드

                 Math.PI

        b. move : 원을 이동시키는 메소드  (x+ mx, y+ my)

        c. scale: 원을 확대 축소하는 메소드 (r = r x 3)

        d. toString : 현재 중심점과 반지름을 출력하는 메소드





2. 구동 클래스(CircleEx) 구현

    1) 원 객체들을 여러개 생성

    2) 각 원의 번호, 반지름, x좌표, y좌표를 출력하기
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
				System.out.println(cir[i].serialNo+"번 원");
				System.out.println(cir[i]);
				cir[i].area();
				cir[i].move();
				cir[i].scale();
				System.out.println();
			}
			
		}
		
	}


