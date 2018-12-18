package chap12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

//3. 
//메서드명 : format
//기능 : 주어진 문자열을 지정된 크기의 문자열로 변환하고 나머지는 공백으로 채우기
//리턴타입 : String
//매개변수 : String str, int length, int alignment
//         alignment : 왼쪽 정렬(0), 가운데 정렬(1), 오른쪽 정렬(2)
//[결과]
//ABC
//  ABC
//    ABC
public class Q0822_3 {
	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println(format(str, 8, 0));
		System.out.println(format(str, 8, 1));
		System.out.println(format(str, 8, 2));
	}

	public static String format(String str, int length, int alignment) {
		StringBuffer sb = new StringBuffer();
		Iterator it = null;
		for (int i = 0; i <= length; i++) {
			sb = sb.append(" ");
		}
		switch (alignment) {
		case 0:
			sb.replace(0, str.length(), str);
			break;
		case 1:
			if ((length % 2 == 1) && (str.length() % 2 == 1)) {
				sb.replace((length / 2) - (str.length() / 2), ((length / 2) - (str.length() / 2)) + 1, str);
				break;
			} else if ((length % 2 == 0) && (str.length() % 2 == 0)) {
				sb.replace((length / 2) - (str.length() / 2), ((length / 2) - (str.length() / 2)), str);
				break;
			}

		case 2:
			sb.replace(length - str.length(), length, str);
			break;
		}
		return sb.toString();
		}
	}

