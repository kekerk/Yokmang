package chap15;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileEx2 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		// c드라이브에 없는 폴더 써놨음.
		File f1 = new File("c:/temp1");
		// 폴더 생성 과정.
		// f1.getAbsolutePath() : 절대 경로
		// f1.mkdir() : 폴더 생성. 생성 완료 : true, 생성 실패 : false
		System.out.printf("%s 폴더 생성 : %b%n", f1.getAbsolutePath(), f1.mkdir());
		File f2 = new File("c:/temp1/text2.txt");
		System.out.printf("%s 파일 생성 : %b%n", f2.getAbsolutePath(), f2.createNewFile());
		System.out.printf("파일이름:%s, 파일크기:%,d byte%n", f2.getName(), f2.length());
		FileOutputStream file = new FileOutputStream(f2);
		System.out.println("아무거나 써 넣으시오.");
		byte[] buf = new byte[1000];
		while (true) {
			String write = scan.nextLine();
			if (write.equals("end")) {
				break;
			}
			buf =(write+"\n").getBytes();
			file.write(buf);
		}
		file.flush();
		file.close();
		int len = 0;
		File f3 = new File("c:/temp1/text3.txt");
		System.out.printf("%s -> %s 이름변경: %b%n", f2.getName(), f3.getName(), f2.renameTo(f3));
		System.out.printf("%s 파일 수정일시: %s%n", f3.getName(), new Date(f3.lastModified()));
		FileInputStream fis = new FileInputStream(f3);
		while((len=fis.read(buf))!= -1) {
		System.out.println(new String(buf,0,len));
		}
		// f3.lastModified() : 1970 ~ 현재까지를 밀리초로 return
		// System.out.printf("%s 파일 삭제: %b%n", f3.getName(), f3.delete());
		// 자동으로 toString 메서드 return
	}
}
