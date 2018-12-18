package chap9;
/*
 * 
 */
//DanceRobot은 춤을 춥니다.
//DanceRobot은 노래를 부릅니다.
//DrawRobot은 그림을 그립니다.
interface actionable {
	void action();
}
class Robot {
	String name;
	Robot(String name) {
		this.name = name;
	}
}	
class DanceRobot extends Robot implements actionable {
	DanceRobot() {
		super("DanceRobot");
	}
	@Override
	public void action() {
		System.out.println(name + "은 춤을 춥니다.");
	}
}
class SingRobot extends Robot implements actionable {
	SingRobot() {
		super("SingRobot");
	}
	@Override
	public void action() {
		System.out.println(name + "은 노래를 부릅니다.");
	}
}
class DrawRobot extends Robot implements actionable {
	DrawRobot() {
		super("DrawRobot");
	}
	@Override
	public void action() {
		System.out.println(name + "은 그림을 그립니다.");
	}
}
public class Exam2 {
	public static void main(String[] args) {
		//인터페이스 타입의 배열 : actionable 인터페이스의 구현 클래스의 객체를 저장하는 배열
		Robot[] robot = new Robot[3];
		robot[0] = new DanceRobot();
		robot[1] = new SingRobot();
		robot[2] = new DrawRobot();
		for (Robot r : robot) {
			((actionable) r).action(); //action() 메서드는 actionable 인터페이스의 멤버임.
		}
	}
}
