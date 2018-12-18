package chap14;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue : 인터페이스(jdk 5.0 이후)
 * 구현 클래스 : LinkedList
 * FIFO
 * 
 * offer(Object) : Queue에 객체 저장.
 * poll() 		 : Queue에서 객체를 꺼내서 리턴.
 * peek() 		 : Queue에서 객체를 조회.
 */
public class QueueEx1 {

	public static void main(String[] args) {
		String[] cars = {"소나타","그랜져","SM5","K9"};
		//LinkedList : 순서유지. new LinkedList<String>(); 는 객체생성.
		Queue<String> queue = new LinkedList<String>();
		for(String s : cars) {
			queue.offer(s);
		}
		System.out.println("큐의 크기:"+queue.size());
		
		String data = null;
		
		System.out.println(data=queue.peek());
		System.out.println(data=queue.peek());
		while((data=queue.poll())!= null) {
			System.out.println(data+"가 queue에서 삭제됨");
		}
		System.out.println("큐의 크기:"+queue.size());
	}

}
