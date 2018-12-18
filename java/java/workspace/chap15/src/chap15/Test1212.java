package chap15;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

//1. 키보드로부터 데이터를 입력받아 input.txt라는 파일에 저장
//2. 키보드가 exit가 될때까지 내용을 저장하기
public class Test1212 {

	public static void main(String[] args) throws IOException {
		//키보드에서 데이터 입력받기
		//System.in : 키보드에서 입력받기(InputStream)
		Reader sysin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sysin);

		//저장할 파일을 지정(FileOutputStream를 쓴다)
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
		System.out.println("저장 완료");
	}
	
}
