package aes;

//AES�� �̿��Ͽ� ���� ��ȣȭ�ϱ�. Ű�� �����ϱ�
public class CiperEx4 {

	public static void main(String[] args) {
		String key = "abc1234567";
		CipherFileAES.getKey(key);
		CipherFileAES.encryptFile("p1.txt","c.txt");

	}

}
