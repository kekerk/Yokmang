package chap9;
/*
 * 
 */
//DanceRobot�� ���� ��ϴ�.
//DanceRobot�� �뷡�� �θ��ϴ�.
//DrawRobot�� �׸��� �׸��ϴ�.
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
		System.out.println(name + "�� ���� ��ϴ�.");
	}
}
class SingRobot extends Robot implements actionable {
	SingRobot() {
		super("SingRobot");
	}
	@Override
	public void action() {
		System.out.println(name + "�� �뷡�� �θ��ϴ�.");
	}
}
class DrawRobot extends Robot implements actionable {
	DrawRobot() {
		super("DrawRobot");
	}
	@Override
	public void action() {
		System.out.println(name + "�� �׸��� �׸��ϴ�.");
	}
}
public class Exam2 {
	public static void main(String[] args) {
		//�������̽� Ÿ���� �迭 : actionable �������̽��� ���� Ŭ������ ��ü�� �����ϴ� �迭
		Robot[] robot = new Robot[3];
		robot[0] = new DanceRobot();
		robot[1] = new SingRobot();
		robot[2] = new DrawRobot();
		for (Robot r : robot) {
			((actionable) r).action(); //action() �޼���� actionable �������̽��� �����.
		}
	}
}
