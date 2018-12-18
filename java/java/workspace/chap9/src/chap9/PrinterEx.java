package chap9;
/*
 * 인터페이스 타입을 리턴 타입으로 사용하기
 * 인터페이스는 객체화가 불가능.
 */

class LazerZet implements Printerable {

	@Override
	public void print() {
		System.out.println("레이저 프린터에서 출력함");
	}

}

class InkZet implements Printerable {

	@Override
	public void print() {
		System.out.println("잉크젯 프린터에서 출력함");

	}

}

class PrinterManager {
	public static Printerable getPrinter(String type) {
		if(type.equals("INK"))
			return new InkZet();
		else
			return new LazerZet();
	}
}
public class PrinterEx {
	public static void main(String[] args) {
		Printerable able = PrinterManager.getPrinter("INK");  //InkZet()과 LazerZet() 둘 다 Printerable 로 형변환 가능
		//able 참조변수는 InkZet 객체를 참조함.
		able.print();
		able = PrinterManager.getPrinter("LAZER");
		//able 참조변수는 LazerZet 객체를 참조함.
		able.print();
		
		
	}
}
