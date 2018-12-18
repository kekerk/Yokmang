import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src/chap15/FileInputStreamEx1.java");
		int len=0;
		byte[] buf=new byte[fis.available()]; //fis.available() 읽기 가능 바이트 수를 리턴
				
				while((len=fis.read(buf))!=-1) {
					System.out.println(new String(buf,0,len));
				}
	}

}
