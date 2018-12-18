package chap14;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue : �������̽�(jdk 5.0 ����)
 * ���� Ŭ���� : LinkedList
 * FIFO
 * 
 * offer(Object) : Queue�� ��ü ����.
 * poll() 		 : Queue���� ��ü�� ������ ����.
 * peek() 		 : Queue���� ��ü�� ��ȸ.
 */
public class QueueEx1 {

	public static void main(String[] args) {
		String[] cars = {"�ҳ�Ÿ","�׷���","SM5","K9"};
		//LinkedList : ��������. new LinkedList<String>(); �� ��ü����.
		Queue<String> queue = new LinkedList<String>();
		for(String s : cars) {
			queue.offer(s);
		}
		System.out.println("ť�� ũ��:"+queue.size());
		
		String data = null;
		
		System.out.println(data=queue.peek());
		System.out.println(data=queue.peek());
		while((data=queue.poll())!= null) {
			System.out.println(data+"�� queue���� ������");
		}
		System.out.println("ť�� ũ��:"+queue.size());
	}

}
