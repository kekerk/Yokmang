import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src/chap15/FileInputStreamEx1.java");
		int len=0;
		byte[] buf=new byte[fis.available()]; //fis.available() �б� ���� ����Ʈ ���� ����
				
				while((len=fis.read(buf))!=-1) {
					System.out.println(new String(buf,0,len));
				}
	}

}
