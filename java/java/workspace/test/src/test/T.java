package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class T {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  FileInputStream fis = new FileInputStream
		            ("bin/test/Test2_1.class");
		      int cnt = 0;
		      for(int i = 0; i < fis.available(); i++) {
		         System.out.printf(" %02X", fis.read());
		         cnt++;
		         if (cnt % 16 == 0) {
		            System.out.println();
		         }
		      }
	}

}
