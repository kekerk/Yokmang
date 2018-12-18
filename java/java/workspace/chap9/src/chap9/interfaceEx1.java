package chap9;
/*
 * �������̽� ����
 * 1. �������̽��� ����� ���, �߻� �޼���, default �޼���, static �޼���θ� �̷������.
 * 2. ��üȭ �Ұ� => ���� Ŭ������ ���� ��üȭ �ȴ�.
 * 3. Ŭ���� ���� ���, Ŭ������ �������̽� ���� ����(implements)�̶� �Ѵ�.
 * 4. Ŭ������ �������̽� ���� ���� ������ �����ϴ�.
 * 5. �������̽� ������ ����� �����ϴ�. �������̽� ���� ����� ���� ����� �����ϴ�.
 */
interface Movable{
	// public static final �� ������ ������ ������. ��� ���� �����ڴ� public 
	public static final int MAX = 100;
	// public abstract ���� ����.
	public abstract void move(int x, int y);
}

interface Attackable {
	public abstract void attack(Unit u);
	
}
// �������̽� ���� ���. ���� ����� ������.
interface Fightable extends Movable, Attackable {}
class Unit {
	int currentHP, x, y;
}
	
// ���� Ŭ���� : �������̽��� ������ Ŭ����
// Ŭ������ �������̽� ���� ������ ���� ������ �ȴ�.
class Fighter extends Unit implements Fightable { //����Ŭ����
		@Override
		// ���� ���̵� : �ٸ� Ŭ����
	public void move(int x, int y) {
		System.out.println(x+","+y+" ��ǥ�� �̵���");
	}
		@Override
		public void attack(Unit u) {
			System.out.println(u+"�� �ο��");
		}
}

public class interfaceEx1 {

public static void main ( String[] args) {
	Fighter f = new Fighter();
	System.out.println(Movable.MAX);
	System.out.println(Fighter.MAX); //Movable ���� MAX�� ����´�.
	System.out.println(Fightable.MAX);
//	Fighter.MAX=0; //����� ���� �Ұ�.
	f.move(20, 30);
	f.attack(f);
	Unit u= f; //�ڵ� ����ȯ ��.
	Fightable fa =(Fightable) u;
//	u.move(40,50); //UnitŬ������ ����� �ƴ�. ���� �� �� ����.
//	u.attack(u);
	fa = f; //Fighter Ŭ������ Fightable �������̽��� ���� Ŭ������.
			//���� Ŭ����Ÿ���� ���������� ���� �������̽��� �ڷ�������
			// �ڵ� ����ȯ ��.
	fa.move(10, 20);
	fa.attack(u);
	Movable m =fa;
	m.move(1, 1);
	System.out.println(m.MAX);
	//m.attack(f); error
	//m.currentHP = 100; error
	Attackable a =fa;
	
}
}
