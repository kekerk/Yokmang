package chap15;

import java.io.File;

/*
 * c:windows ������ �����Ͽ�
 * ������ ���� ���� ������ ������ ����, �� ������ ũ�⸦ ����ϴ� ���α׷�.
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
				System.out.printf("%s : ���丮%n",s);
			}else {
				cntfile++;
				System.out.printf("%s : ����(%,d byte)%n",s,f2.length());
				bytesum+=f2.length();
			}
		}
		System.out.println("-----------------------------------------------------------------");
		//cmd â������ ���� ���� 2���� �������� ���´�.
		System.out.println("������ ����: "+cntdir);
		System.out.println("������ ����: "+cntfile);
		System.out.println("���� ��ü �뷮: "+String.format("%,10d byte", bytesum));
		
	}

}
