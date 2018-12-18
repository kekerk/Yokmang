package chap15;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//1. Ű����κ��� �����͸� �Է¹޾� input.txt��� ���Ͽ� ����
//2. Ű���尡 exit�� �ɶ����� ������ �����ϱ�
public class Test1212 {

	public static void main(String[] args) throws IOException {
		//Ű���忡�� ������ �Է¹ޱ�
		//System.in : Ű���忡�� �Է¹ޱ�(InputStream)
		Reader sysin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sysin);

		//������ ������ ����(FileOutputStream�� ����)
//		FileOutputStream fos = new FileOutputStream("input.txt"); 
/*		while(true) { 
			String text = br.readLine();
			if(text.equalsIgnoreCase("exit")) {
				break;
			}
			fos.write((text+"\n").getBytes());
		}*/
		FileWriter fw = new FileWriter("input.txt");
		int data;
		while(true) {
			data = sysin.read();
			if(data == -1) break;
			fw.write(data);
		}
		fw.flush();
		fw.close();
		System.out.println("���� �Ϸ�");
	}
	
}
