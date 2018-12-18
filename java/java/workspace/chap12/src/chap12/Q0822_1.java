package chap12;

/*
 * 1. * ������ ���� ���� ����� �򵵷� Point3DŬ������ �ϼ��Ͻÿ�.
 * 
 * main �޼���� ���� ����� ����� �ش� �޼��带 �������̵� �Ͻÿ�
 * 
 * [������]
 * 
 * [1,2,3]
 * 
 * [1,2,3]
 * 
 * p1==p2?false
 * 
 * p1.equals(p2)?true
 * 
 */
class Point3D {
	int x, y, z;
	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public String toString() {
		return "[" + x + "," + y + "," + z + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point3D) {
			Point3D p = (Point3D) obj;
			return (x == p.x && y == p.y && z == p.z);

		} else {
			return false;
		}
	}
}

public class Q0822_1 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(1, 2, 3);
		System.out.println(p1.toString());
		System.out.println(p2);
		System.out.println("p1==p2?" + (p1 == p2));
		System.out.println("p1.equals(p2)?" + (p1.equals(p2)));
	}
}
