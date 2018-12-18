package chap12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

//3. 
//�޼���� : format
//��� : �־��� ���ڿ��� ������ ũ���� ���ڿ��� ��ȯ�ϰ� �������� �������� ä���
//����Ÿ�� : String
//�Ű����� : String str, int length, int alignment
//         alignment : ���� ����(0), ��� ����(1), ������ ����(2)
//[���]
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

