package chap7;
class Circle1{
	int r,x,y,no;
	static int count;
	void area() {
		System.out.println(no+"번 원의 넓이: "+(Math.PI*r*r));
	}
	void move(int n, int m) {
		x+=n;
		y+=m;
	}
	
	void scale(int mul) {
		r*=mul;
	}
	public String toString() {
		return "반지름이 " + r +"인 원의 중심 좌표는 ("+x+","+y+")";
	}
}
public class Exer1 {

	public static void main(String[] args) {
		int t = (int)(Math.random()*9+1);
		Circle1[] cir = new Circle1[t];
		
		for(int i=0;i<cir.length;i++) {
			cir[i] = new Circle1();
			cir[i].r = (int)(Math.random()*9+1);
			cir[i].x = (int)(Math.random()*9+1);
			cir[i].y = (int)(Math.random()*9+1);
			cir[i].no = ++Circle1.count;
			System.out.println(cir[i]);
			cir[i].area();
			cir[i].move((int)(Math.random()*9+1), (int)(Math.random()*9+1));
			
			cir[i].scale((int)(Math.random()*9+1));
			
			
		}

	}

}
