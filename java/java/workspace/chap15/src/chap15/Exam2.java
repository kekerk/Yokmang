package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 파일명을 입력받아서. 해당 파일이 존재하면 해당파일명.bak 파일 복사하기.
 * 					해당 파일이 없으면 "파일없음." 다시 파일명 입력받기.
 */
public class Exam2 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("파일명을 입력하세요");
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
				System.out.println("해당 파일이 없습니다.");
				continue;
			}
			System.out.println("만들어졌습니다. Package Explorer에서 새로고침 하세요.");
	    	break;
			
		}
	}
}