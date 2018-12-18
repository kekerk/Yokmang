package chap15;

import java.io.File;

/*
 * File Ŭ����.
 * 	- ������ ������ �����ϴ� Ŭ����.
 * 	- �������� �ʾƵ� ������ ����.
 * 	- ������ ���� �κ��� ��ȸ�ϰų� �����ϴ� ���� �Ұ���.
 * 	- 
 */
public class FileEx1 {
	public static void main(String[] args) {
		String filepath="C:\\Windows";// c:\�� ��Ÿ��.
		//f1 : c:\ root ������ �����ϴ� File ��ü.
		File f1 = new File(filepath);
		//f1.list() : f1�̶�� �ϴ� ������ ���� ���� �Ǵ� ������ ����� ����.
		String[] list = f1.list();
		for(String s : list) {
			// f2 : c:\20180730 
			File f2 = new File(filepath,s); 
			if(f2.isDirectory()) {//������?
				System.out.printf("%s : ���丮%n",s);
			}else {//�����̳�?
				//f2.length() : ������ Byte���� ũ��.
				System.out.printf("%s : ����(%,dbyte)%n",s,f2.length());
			}
		}
		
		
	}
}
