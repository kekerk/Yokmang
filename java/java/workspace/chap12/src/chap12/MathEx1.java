package chap12;
/*
 * math class : ��� ����� static.
 * 				math.�޼ҵ��.
 * 				math.�����.
 * 				final class -> �ٸ� Ŭ������ ��ӹ��� �� ����.
 */
public class MathEx1 {

	public static void main(String[] args) {
		//abs() : ���밪
		System.out.println(Math.abs(5));//5
		System.out.println(Math.abs(-5));//5
		//ceil(����) : ���ں��� ū �ٻ� ����
		System.out.println(Math.ceil(5.4));//6.0
		System.out.println(Math.ceil(-5.4));//-5.0
		//floor(����) : ���ں��� ���� �ٻ� ����
		System.out.println(Math.floor(5.4)); //5.0
		System.out.println(Math.floor(-5.4));//-6.0
		//rint(����) : ���ڿ� ���� ����� �ٻ� ����		
		System.out.println(Math.rint(5.4)); //5.0
		System.out.println(Math.rint(-5.4)); //-5.0
		// max: �� ���� ū ��, min: �� ���� ���� ��
		System.out.println(Math.max(5.4,5.3));//5.4
		System.out.println(Math.min(5.4,5.3));//5.3
		//round : �ݿø�. ������.
		System.out.println(Math.round(5.4)); // 5
		System.out.println(Math.round(5.5)); // 6
		//random : ������ �� 0 <= x < 1.0
		System.out.println(Math.random());//?
		//�α��Լ�
		System.out.println(Math.log(Math.E));//1.0
		//root(������)
		System.out.println(Math.sqrt(25));//5.0
		//����
		System.out.println(Math.pow(5, 4));//5*5*5*5
		//sin : radian ����.
		System.out.println(Math.sin(Math.PI/2));//1.0
		//cos : 60?
		System.out.println(Math.cos(Math.toRadians(60)));// 0.5
		//degrees  <= ����
		System.out.println(Math.toDegrees(Math.PI/2)); //90.0
		//tan 45?
		System.out.println(Math.tan(Math.PI/4)); // 0.99999999999
	}
	}
