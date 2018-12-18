package chap14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * Properties Ŭ���� ����
 *  1. Hashtable �� ���� Ŭ����. Map ��ü��. Hashtable�� ����� �������ְ���. Properties is a map.
 *  2. Key�� value ��� String�� map ��ü�� => ���׸� (< >) ��� ����.
 */
public class PropertiesEx1 {
	public static void main(String[] args) throws IOException {
		
		Properties pr = new Properties();
		
		FileInputStream fis = new FileInputStream("a.properties"); // ������ �о�´�.
		//fis ������ ���� key=value �� ����.
		pr.load(fis);
		
		System.out.println(pr); //age=20���� 20�� ���ڿ�.
		
		System.out.println("�̸�:" + pr.getProperty("name"));
//		System.out.println("�̸�:" + pr.get("name")); //.get�� map ��ü�� ���.
		pr.put("subject","��ǻ�Ͱ���");
		//store : pr�� ��ü���� b.txt�� ����.
		System.out.println("subject:"+pr.get("subject"));
		pr.store(new FileOutputStream("b.txt"), "#save"); //#���ϴ� �ּ�.
		
		System.out.println(pr);
		
		
		
		
		
	}
}
