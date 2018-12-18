package chap15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q0823_1_1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��ϼ���");
		String fileName = scan.nextLine();
		System.out.println("��ȸ�� ������ ���ڷ� �Է��ϼ���");
		int num = scan.nextInt();
		// BufferedReader br: ���� ���. ������ ����� �߰�.
		// br.readLine() : ���پ� ���� �� �ִ� �޼���.
		//������Ʈ�� : ��ü ������ �� �Ű������� �ٸ� ��Ʈ���� �Է¹޴´�.
		//			�ٸ� ����� �߰��� �� �ִ� ��Ʈ��.
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//PrintWriter : println,print,printf ����� �߰�.
		//				��� Ÿ�Կ� ������� ����� �� �ִ� ����� �߰�.
		//				����ó���� ���� �ʾƵ� ��.(���� ó���� ������ �� �ִ�.)
		PrintWriter pw = new PrintWriter(new FileWriter(fileName+".subfile"));
		String line = null;		
		for (int i=0;i<num;i++) {
			if((line=br.readLine())==null) break;
			System.out.println(line);
			//����Ϸ��� ����(fileName+".subfile")�� line ���ڿ��� ���.
			pw.println(line);
		}
		pw.close(); br.close();
	}

}
