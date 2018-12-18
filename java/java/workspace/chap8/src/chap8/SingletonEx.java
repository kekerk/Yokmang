package chap8;

class SingleObject { //�������� ���������ڸ� �̿��Ͽ� ��ü�� ������ ������ �� �ִ�.
	private static SingleObject obj = new SingleObject();
	private SingleObject() { // ������. 1��
	} // private ������ : ��ü ������ ���´�. ��ü�� ������ ���ѽ�Ų��.

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
		obj2.setValue(1000); //�ϳ��� ���� �ٲٸ�, ��� ���������� ���� �����ϰ� �� �ٲ��.
		System.out.println("obj1.value="+obj1.getValue());
		System.out.println("obj2.value="+obj2.getValue());
		if(obj1==obj2) {
			System.out.println("obj1 ���������� �����ϴ� ��ü�� obj2 ���������� �����ϴ� ��ü�� ���� ��ü��.");
		}
		
	}
}
