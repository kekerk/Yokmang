package chap11;

/*
 * ���� catch ���� ����
 * �߻��� ���� ���� �ٸ� ���� ó���� �� �� �ִ�. (�ϳ��� Try �ȿ� ���� catch ����)
 * 
 * catch ������ ��ġ : �ڼ� exception - > �θ� exception ������ ��ġ�ؾ� ��. => ������ �ֻ��� Ŭ������ ExceptionŸ���� catch ������ �ݵ�� ���ϴܿ� ��ġ�ؾ� �Ѵ�.
 * 
 *   
 */
public class ExceptionEx2 {
	public static void main(String[] args) {
		try {
			System.out.println(args[0]); //���� 0������ �ƹ��͵� ����.
			//args[0]�� ȫ�浿 �Է���. -> NumberFormatException e ����.
			//args[0] �� 0���� ����. -> Arr
			System.out.println(Integer.parseInt(args[0]));
			System.out.println(2 / Integer.parseInt(args[0]));
			// ���� args[0]�� 1
			String str = null;
			System.out.println(str.trim());
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} catch (ArrayIndexOutOfBoundsException e) { //0�� ÷�ڸ� ���� ������ ���� �� ����.
			System.out.println("��� ����� �Ķ���͸� �Է��ϼ���.");
		} catch (NumberFormatException e) { //���ڰ� �ƴ� �� ����.
			System.out.println("���ڸ� �����մϴ�.");
		} catch (Exception e) {
			System.out.println("����η� �����ϼ���(��ȭ:1234)");
		}
	}
}
