package chap9;
/*
 * �������̽� Ÿ���� ���� Ÿ������ ����ϱ�
 * �������̽��� ��üȭ�� �Ұ���.
 */

class LazerZet implements Printerable {

	@Override
	public void print() {
		System.out.println("������ �����Ϳ��� �����");
	}

}

class InkZet implements Printerable {

	@Override
	public void print() {
		System.out.println("��ũ�� �����Ϳ��� �����");

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
		Printerable able = PrinterManager.getPrinter("INK");  //InkZet()�� LazerZet() �� �� Printerable �� ����ȯ ����
		//able ���������� InkZet ��ü�� ������.
		able.print();
		able = PrinterManager.getPrinter("LAZER");
		//able ���������� LazerZet ��ü�� ������.
		able.print();
		
		
	}
}
