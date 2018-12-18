package chap7;

class Animal2 {
	String name;
	int age;
	
	Animal2(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	Animal2(String name){
		this(name, 20);
		
	}
	Animal2(int age){
		this("�⸰",age);
		
	}
	
	void info() {
		System.out.println(name+":"+age+"��");
	}
}

public class Exam6 {

	public static void main(String[] args) {
		Animal2 a1 = new Animal2("������", 26);
		Animal2 a2 = new Animal2("����");
		Animal2 a3 = new Animal2(100);
		a1.info();
		a2.info();
		a3.info();

	}

}
