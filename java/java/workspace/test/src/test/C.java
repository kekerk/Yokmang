package test;

import java.util.ArrayList;
import java.util.List;

public class C {

	public static void main(String[] args) throws Exception {
		System.out.print("�����");
		char a1 = (char)('��'-1);
		while (true) {
			
			for (int i = 1; i <= 4; i++) {
				Thread.sleep(1000);
				System.out.print('.');
				if(i==4) break;
			}
		}
	}



}
