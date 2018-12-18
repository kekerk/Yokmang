package chap12;
/*
 * File(score.txt)�� �ִ� ���� ��������.
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) throws IOException{
		//Scanner : �����ε��Ǿ� ����.
		Scanner scan = new Scanner(new File("score.txt"));
		int cnt = 0;
		int totalSum = 0;
		//scan.hasNextLine() : score.txt ���뿡 ��ȸ�� �����Ͱ� ����?(����)
		while(scan.hasNextLine()) {
			// line = "ȫ�浿,4.5,3.8,4.2"
			String line = scan.nextLine();
			//new Scanner(line).useDelimiter(",") : ','�� �������� ������ �аڴ�.
			Scanner scan2 = new Scanner(line).useDelimiter(",");
			double sum = 0;
			int i=0;
			//name = "ȫ�浿"
			String name = scan2.next();
			System.out.print(name+":");
			while(scan2.hasNextDouble()){
				//score = 4.5   (4.5�� ���� �������̳� nextDouble()�� ���Ͽ� double������ �ٲ�.
				double score = scan2.nextDouble();
				sum += score;
				System.out.print(score+", ");
				i++;
			}
			System.out.println("sum: "+String.format("%.1f", sum)+", avg: "+((int)(sum/i*100))/100.0);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("�л� �ο���: "+cnt);
	}

}
