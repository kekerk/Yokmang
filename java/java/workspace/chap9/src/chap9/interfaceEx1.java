package chap9;
/*
 * 인터페이스 예제
 * 1. 인터페이스의 멤버는 상수, 추상 메서드, default 메서드, static 메서드로만 이루어진다.
 * 2. 객체화 불가 => 구현 클래스를 통해 객체화 된다.
 * 3. 클래스 간은 상속, 클래스와 인터페이스 간은 구현(implements)이라 한다.
 * 4. 클래스와 인터페이스 간은 다중 구현이 가능하다.
 * 5. 인터페이스 간에도 상속이 가능하다. 인터페이스 간의 상속은 다중 상속이 가능하다.
 */
interface Movable{
	// public static final 이 세개는 생략이 가능함. 모든 접근 제어자는 public 
	public static final int MAX = 100;
	// public abstract 생략 가능.
	public abstract void move(int x, int y);
}

interface Attackable {
	public abstract void attack(Unit u);
	
}
// 인터페이스 간의 상속. 다중 상속이 가능함.
interface Fightable extends Movable, Attackable {}
class Unit {
	int currentHP, x, y;
}
	
// 궇녀 클래스 : 인터페이스를 구현한 클래스
// 클래스와 인터페이스 간의 구현은 다중 구현이 된다.
class Fighter extends Unit implements Fightable { //구현클래스
		@Override
		// 오버 라이딩 : 다른 클래스
	public void move(int x, int y) {
		System.out.println(x+","+y+" 좌표로 이동중");
	}
		@Override
		public void attack(Unit u) {
			System.out.println(u+"와 싸우기");
		}
}

public class interfaceEx1 {

public static void main ( String[] args) {
	Fighter f = new Fighter();
	System.out.println(Movable.MAX);
	System.out.println(Fighter.MAX); //Movable 안의 MAX를 끌고온다.
	System.out.println(Fightable.MAX);
//	Fighter.MAX=0; //상수는 변경 불가.
	f.move(20, 30);
	f.attack(f);
	Unit u= f; //자동 형변환 됨.
	Fightable fa =(Fightable) u;
//	u.move(40,50); //Unit클래스의 멤버가 아님. 접근 할 수 없음.
//	u.attack(u);
	fa = f; //Fighter 클래스는 Fightable 인터페이스의 구현 클래스임.
			//구현 클래스타입의 참조변수는 구현 인터페이스의 자료형으로
			// 자동 형변환 됨.
	fa.move(10, 20);
	fa.attack(u);
	Movable m =fa;
	m.move(1, 1);
	System.out.println(m.MAX);
	//m.attack(f); error
	//m.currentHP = 100; error
	Attackable a =fa;
	
}
}
