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

class Circle {
	int r;
	int x;
	int y;
	int n,m;
	int mul;
	int serialNo;
	static int count;
	
	void area() {
		System.out.println("반지름이 "+r+"인 원의 넓이는 "+ (double)Math.PI*r*r);
	}
	
	void move() {
		System.out.println("좌표 상 ("+x+","+y+")에 위치한 원을 x축으로 "+n+"만큼, y축으로 "+m+"만큼 움직인 원의 좌표는 ("+(n+x)+","+(m+y)+")");
	}
	
	void scale() {
		System.out.println("반지름이 "+r+"인 원의 반지름을 "+ mul + "배로 하면 그 반지름은 "+(r*mul));
	}
	
	public String toString() {
		return "반지름은 "+r+"이고, 중심 좌표는 ("+x+","+y+")";
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
			System.out.println(cir[i].serialNo+"번 원");
			System.out.println(cir[i]);
			cir[i].area();
			cir[i].move();
			cir[i].scale();
			System.out.println();
		}
		
	}

}
