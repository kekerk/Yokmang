package chap8;
/*
 * 1.동물 클래스 : Animal => 추상 클래스
 * 	멤버 변수 : 동물의 종류, 다리수 
 * 생성자 : 동물의 종류, 다리 수 입력
 * 멤버 메서드 : void eat() => 추상메서드
 * 		     String sound() => 추상 메서드
 * 
 * 2. 강아지 클래스 : Dog Animal 클래스의 하위 클래스
 * 				 생성자: 매개변수 필요 없음
 * 		멤버 메서드 : void eat() "주인이 주는대로 먹는다."
 * 				  String sound() "멍멍"
 * 3. 사자 클래스 : Dog Animal 클래스의 하위 클래스
 * 				 생성자: 매개변수 필요 없음
 * 		멤버 메서드 : void eat() "초식 동물을 잡아먹는다."
 * 				  String sound() "어흥"
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
		super("강아지",4);
	}
	@Override
	void eat() {
		System.out.println("주인이 주는대로 먹는다.");
	}
	@Override
	String sound() {
		return "멍멍";
	}
}
class Lion extends Animal{

	Lion() {
		super("사자",4);
	}
	@Override
	void eat() {
		System.out.println("초식 동물을 잡아먹는다.");
		
	}
	@Override
	String sound() {
		return "어흥";
	}
}
public class Exam5 {
	public static void main(String[] args) {
		Animal[] ani = new Animal[2];
		ani[0] = new Dog();
		ani[1] = new Lion();
		for(Animal s : ani) {
			System.out.println("동물 이름은 " + s.name +"이고 다리는 "+s.legs +"개이다. ");
			s.eat();
			System.out.println(s.sound());
		}
	}
}
