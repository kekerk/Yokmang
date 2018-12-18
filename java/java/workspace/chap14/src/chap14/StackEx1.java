package chap14;

import java.util.Stack;

/*
 * Stack : Vector�� ���� Ŭ����.
 * LIFO(LastIn First Out)
 * 
 * push(Object) : Stack�� ��ü�� ����.
 * pop() 		: Stack���� (�ֻ�ܿ� ��ġ��)��ü�� ����. ����(���ŵ�) ��ü�� ����.
 * peek()		: �ֻ���� ��ü�� ��ȸ.
 */
public class StackEx1 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String[] cars = {"�ҳ�Ÿ","�׷���","SM5","K9"};
		for(String s:cars) {
			stack.push(s);
		}
		System.out.println(stack.peek());
		System.out.println("������ ũ��: "+stack.size());
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		System.out.println("������ ũ��: "+stack.size());
		
	}
}
