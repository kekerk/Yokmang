package chap12;
/*
 * File(score.txt)에 있는 내용 가져오기.
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) throws IOException{
		//Scanner : 오버로딩되어 있음.
		Scanner scan = new Scanner(new File("score.txt"));
		int cnt = 0;
		int totalSum = 0;
		//scan.hasNextLine() : score.txt 내용에 조회할 데이터가 존재?(한줄)
		while(scan.hasNextLine()) {
			// line = "홍길동,4.5,3.8,4.2"
			String line = scan.nextLine();
			//new Scanner(line).useDelimiter(",") : ','를 기준으로 나눠서 읽겠다.
			Scanner scan2 = new Scanner(line).useDelimiter(",");
			double sum = 0;
			int i=0;
			//name = "홍길동"
			String name = scan2.next();
			System.out.print(name+":");
			while(scan2.hasNextDouble()){
				//score = 4.5   (4.5는 원래 문자형이나 nextDouble()로 인하여 double형으로 바뀜.
				double score = scan2.nextDouble();
				sum += score;
				System.out.print(score+", ");
				i++;
			}
			System.out.println("sum: "+String.format("%.1f", sum)+", avg: "+((int)(sum/i*100))/100.0);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("학생 인원수: "+cnt);
	}

}
