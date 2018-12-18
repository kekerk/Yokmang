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
		// c����̺꿡 ���� ���� �����.
		File f1 = new File("c:/temp1");
		// ���� ���� ����.
		// f1.getAbsolutePath() : ���� ���
		// f1.mkdir() : ���� ����. ���� �Ϸ� : true, ���� ���� : false
		System.out.printf("%s ���� ���� : %b%n", f1.getAbsolutePath(), f1.mkdir());
		File f2 = new File("c:/temp1/text2.txt");
		System.out.printf("%s ���� ���� : %b%n", f2.getAbsolutePath(), f2.createNewFile());
		System.out.printf("�����̸�:%s, ����ũ��:%,d byte%n", f2.getName(), f2.length());
		FileOutputStream file = new FileOutputStream(f2);
		System.out.println("�ƹ��ų� �� �����ÿ�.");
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
		System.out.printf("%s -> %s �̸�����: %b%n", f2.getName(), f3.getName(), f2.renameTo(f3));
		System.out.printf("%s ���� �����Ͻ�: %s%n", f3.getName(), new Date(f3.lastModified()));
		FileInputStream fis = new FileInputStream(f3);
		while((len=fis.read(buf))!= -1) {
		System.out.println(new String(buf,0,len));
		}
		// f3.lastModified() : 1970 ~ ��������� �и��ʷ� return
		// System.out.printf("%s ���� ����: %b%n", f3.getName(), f3.delete());
		// �ڵ����� toString �޼��� return
	}
}
