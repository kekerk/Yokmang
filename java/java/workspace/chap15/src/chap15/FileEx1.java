package chap15;

import java.io.File;

/*
 * File 클래스.
 * 	- 파일의 정보를 관리하는 클래스.
 * 	- 존재하지 않아도 관리가 가능.
 * 	- 파일의 내용 부분을 조회하거나 수정하는 것은 불가능.
 * 	- 
 */
public class FileEx1 {
	public static void main(String[] args) {
		String filepath="C:\\Windows";// c:\를 나타냄.
		//f1 : c:\ root 폴더를 지정하는 File 객체.
		File f1 = new File(filepath);
		//f1.list() : f1이라고 하는 파일의 하위 폴더 또는 파일의 목록을 리턴.
		String[] list = f1.list();
		for(String s : list) {
			// f2 : c:\20180730 
			File f2 = new File(filepath,s); 
			if(f2.isDirectory()) {//폴더냐?
				System.out.printf("%s : 디렉토리%n",s);
			}else {//파일이냐?
				//f2.length() : 파일의 Byte단위 크기.
				System.out.printf("%s : 파일(%,dbyte)%n",s,f2.length());
			}
		}
		
		
	}
}
