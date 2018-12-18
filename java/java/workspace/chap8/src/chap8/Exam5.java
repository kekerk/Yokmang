package chap8;
/*
 * 1.���� Ŭ���� : Animal => �߻� Ŭ����
 * 	��� ���� : ������ ����, �ٸ��� 
 * ������ : ������ ����, �ٸ� �� �Է�
 * ��� �޼��� : void eat() => �߻�޼���
 * 		     String sound() => �߻� �޼���
 * 
 * 2. ������ Ŭ���� : Dog Animal Ŭ������ ���� Ŭ����
 * 				 ������: �Ű����� �ʿ� ����
 * 		��� �޼��� : void eat() "������ �ִ´�� �Դ´�."
 * 				  String sound() "�۸�"
 * 3. ���� Ŭ���� : Dog Animal Ŭ������ ���� Ŭ����
 * 				 ������: �Ű����� �ʿ� ����
 * 		��� �޼��� : void eat() "�ʽ� ������ ��ƸԴ´�."
 * 				  String sound() "����"
 * 				
 */

abstract class Animal {
	String name;
	int legs,num;
		Animal(String name, int legs){
			this.name = name;
			this.legs = legs;
		}
		abstract void eat();
		abstract String sound();
}
class Dog extends Animal{
	Dog(){
		super("������",4);
	}
	@Override
	void eat() {
		System.out.println("������ �ִ´�� �Դ´�.");
	}
	@Override
	String sound() {
		return "�۸�";
	}
}
class Lion extends Animal{

	Lion() {
		super("����",4);
	}
	@Override
	void eat() {
		System.out.println("�ʽ� ������ ��ƸԴ´�.");
		
	}
	@Override
	String sound() {
		return "����";
	}
}
public class Exam5 {
	public static void main(String[] args) {
		Animal[] ani = new Animal[2];
		ani[0] = new Dog();
		ani[1] = new Lion();
		for(Animal s : ani) {
			System.out.println("���� �̸��� " + s.name +"�̰� �ٸ��� "+s.legs +"���̴�. ");
			s.eat();
			System.out.println(s.sound());
		}
	}
}
