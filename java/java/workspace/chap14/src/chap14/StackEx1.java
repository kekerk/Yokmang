package chap14;

import java.util.Stack;

/*
 * Stack : Vector의 하위 클래스.
 * LIFO(LastIn First Out)
 * 
 * push(Object) : Stack에 객체를 저장.
 * pop() 		: Stack에서 (최상단에 위치한)객체를 꺼냄. 꺼낸(제거된) 객체를 리턴.
 * peek()		: 최상단의 객체를 조회.
 */
public class StackEx1 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String[] cars = {"소나타","그랜져","SM5","K9"};
		for(String s:cars) {
			stack.push(s);
		}
		System.out.println(stack.peek());
		System.out.println("스택의 크기: "+stack.size());
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println("스택의 크기: "+stack.size());
		
	}
}
