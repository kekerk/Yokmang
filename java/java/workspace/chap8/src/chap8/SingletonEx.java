package chap8;

class SingleObject { //생성자의 접근제어자를 이용하여 객체의 개수를 제한할 수 있다.
	private static SingleObject obj = new SingleObject();
	private SingleObject() { // 생성자. 1개
	} // private 생성자 : 객체 생성을 막는다. 객체의 개수를 제한시킨다.

	private int value = 100;

	public static SingleObject getObject() {
		return obj;
	}
	public int getValue() {
		return value;

	}
	public void setValue(int value) {
		this.value = value;
	}
}

public class SingletonEx {
	public static void main(String[] args) {
		//SingleObject s = new SingleObject();
		SingleObject obj1 = SingleObject.getObject();
		SingleObject obj2 = SingleObject.getObject();
		System.out.println("obj1.value="+obj1.getValue());
		System.out.println("obj2.value="+obj2.getValue());
		obj2.setValue(1000); //하나의 값을 바꾸면, 모든 참조변수의 값이 동일하게 다 바뀐다.
		System.out.println("obj1.value="+obj1.getValue());
		System.out.println("obj2.value="+obj2.getValue());
		if(obj1==obj2) {
			System.out.println("obj1 참조변수가 참조하는 객체와 obj2 참조변수가 참조하는 객체는 같은 객체다.");
		}
		
	}
}
