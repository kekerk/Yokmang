package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 파일명과 숫자를 입력받기.
 * 해당 파일명에서 입력받은 숫자만큼만 조회하여
 * 파일명.sub 파일에 저장하기.
 * 
 * [결과]
 * 읽을 파일 명을 입력하세요.
 * a.txt 5 (없으면 다시 입력받게끔)
 * 
 * a.txt            a.txt.sub
 * aaa				aaa
 * bbb				bbb
 * ccc				ccc
 * ddd				ddd	
 * eee				eee
 * fff
 * 
 */
public class Q0823_1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("읽을 파일 명과 마지막 출력단을 입력하세요");
				String file = scan.next();
				int numl = scan.nextInt();
				int cnt = 0;
				//내 프로그램으로 파일 불러오기 및 읽기.
				FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(file + ".sub");
				Scanner scan2 = new Scanner(fis);
				byte[] buf = new byte[fis.available()];
				while (scan2.hasNextLine()) {
					String line = scan2.nextLine();
					buf = (line + "\n").getBytes();
					fis.read(buf);
					fos.write(buf);
					cnt++;
					if (cnt == numl) {
						break;
					}
				}
				fos.flush();
				fos.close();

				System.out.println("옮겨졌습니다. 확인해 보세요.");
				break;
			} catch (FileNotFoundException e) {
				System.out.println("파일이 없습니다.");
				continue;
			}

		}

	}

}
