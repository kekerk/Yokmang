package chap3;
// String Ŭ���� : ���ڿ� ��ü �ǹ�
// + �����ڸ� �̿��Ҽ� �ִ� Ŭ����
//String = String + �⺻��
//�ڹٿ��� 'a' char ���� �⺻���̰�, 
//      "a" String ���� ��ü�̹Ƿ� ���� ����ȯ�� �ȵȴ�.
public class VarEx4 {

	public static void main(String[] args) {
		System.out.println("��ȣ:"+1+2+3); // ��ȣ:1 -> ��ȣ:12 -> ��ȣ:123 ���·� string = string + �⺻������ 1, 2, 3 �� �ڿ� �ٰ� �ȴ�
		System.out.println(1+2+3+"��"); // �տ������ ����.
		//String str = "a"; (o) 
		//String str = 'a'; (x)
		String str = "����"+'a';
		System.out.println("str:"+str);
	}

}
