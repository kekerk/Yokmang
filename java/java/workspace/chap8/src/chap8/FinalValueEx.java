package chap8;
class FinalValue {
	final int num; 
	FinalValue() {
		this(100); 
	}
					     //����� �ʱ�ȭ�� ���� ���� ���¿��� �ѹ� �ʱ�ȭ ������.
	FinalValue(int NUM){ //��ü ������ �����ϴ� �޼���
		this.num = NUM; //�ѹ� �ʱ�ȭ�� ��. ��ü���� �ٸ� ������� ������.
	}
	
	public int getnum() {
		return num;
	}
}
public class FinalValueEx {

	public static void main(String[] args) {
		FinalValue v1 = new FinalValue();
		System.out.println(v1.getnum());
//		v1.num = 200; // num�� ����̹Ƿ� ���� �Ұ�. �ʱ� �����ڿ��� 100�̶�� ������ �����ϰ� final ������ �����Ͽ����Ƿ� �� ���� �Ұ�.
		FinalValue v2 = new FinalValue(120);
		System.out.println(v2.getnum());
	}

}
