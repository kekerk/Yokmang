package chap15;

import java.io.File;

/*
 * c:windows 폴더를 지정하여
 * 폴더의 하위 폴더 갯수와 파일의 갯수, 총 파일의 크기를 출력하는 프로그램.
 */
public class Exam3 {

	public static void main(String[] args) {
		String filepath  = "C:\\Windows";
		File f1 = new File(filepath);
		String[] list = f1.list();
		int cntdir=0,cntfile=0,bytesum=0;
		for(String s:list) {
			File f2 =new File(filepath,s);
			if(f2.isDirectory()) {
				cntdir++;
				System.out.printf("%s : 디렉토리%n",s);
			}else {
				cntfile++;
				System.out.printf("%s : 파일(%,d byte)%n",s,f2.length());
				bytesum+=f2.length();
			}
		}
		System.out.println("-----------------------------------------------------------------");
		//cmd 창에서는 상위 폴더 2개가 더해져서 나온다.
		System.out.println("폴더의 개수: "+cntdir);
		System.out.println("파일의 개수: "+cntfile);
		System.out.println("파일 전체 용량: "+String.format("%,10d byte", bytesum));
		
	}

}
