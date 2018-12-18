package chap15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

/*
 * SequenceInputStream : 여러개의 InputSTream을 모아서 하나의 InputStream으로 처리함. 연결 스트림이라고 함.
 */
public class SequenceInputStreamEx1 {

	public static void main(String[] args) throws IOException {
		
		byte[] arr1= {0,1,2};
		byte[] arr2= {3,4,5};
		SequenceInputStream in = new SequenceInputStream(new ByteArrayInputStream(arr1), new ByteArrayInputStream(arr2));
		int data=0;
		while((data=in.read())!= -1) {
			System.out.print((byte) data);
		}
		
		

	}

}
