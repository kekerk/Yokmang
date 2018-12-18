package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * ���ϸ��� �Է¹޾Ƽ�. �ش� ������ �����ϸ� �ش����ϸ�.bak ���� �����ϱ�.
 * 					�ش� ������ ������ "���Ͼ���." �ٽ� ���ϸ� �Է¹ޱ�.
 */
public class Exam2 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("���ϸ��� �Է��ϼ���");
			String file = scan.nextLine();
			try {
				FileInputStream fis = new FileInputStream(file);
				//////////////////////////////////////////////////////////
				file = file + ".bak";
				FileOutputStream fos = new FileOutputStream(file);
                byte[] buf = new byte[fis.available()];
				
                int len = 0;
                /////////////////////////////////////////////////
//                while((len = fis.read(buf))!= -1) {
//                	fos.write((new String(buf,0,len)).getBytes());
//                }
                /////////////////////////////////////////////////
//                fis.read(buf);
//                fos.write(buf);
                /////////////////////////////////////////////////
                while((len = fis.read(buf))!= -1) {
                	fos.write(buf,0,len);
                }
                /////////////////////////////////////////////////
			   	fos.flush();
		    	fos.close();
		    	
			} catch (FileNotFoundException e) {
				System.out.println("�ش� ������ �����ϴ�.");
				continue;
			}
			System.out.println("����������ϴ�. Package Explorer���� ���ΰ�ħ �ϼ���.");
	    	break;
			
		}
	}
}