package aes;

//AES를 이용하여 파일 암호화하기. 키값 저장하기
public class CiperEx4 {

	public static void main(String[] args) {
		String key = "abc1234567";
		CipherFileAES.getKey(key);
		CipherFileAES.encryptFile("p1.txt","c.txt");

	}

}
