package chap16;
/*
 * Runtime(����Ÿ��) Runtime.getRuntime(): OS�κ��� ���� ������ ���.
 * Process         Runtime.exec(..)    : ���� ���� ���� ���μ���.
 *   
 */
import java.io.IOException;

public class ProcessEx1 {
	public static void main(String[] args) throws Exception {
		//���� 3���� ���μ��� ������ : mspaint.exe, notepad.exe, ProcessEx1.java
		Process p1 = Runtime.getRuntime().exec("mspaint.exe");
		Process p2 = Runtime.getRuntime().exec("notepad.exe");
		//���� �� �޸����� �����ϸ� �׸����� ����������, �׸����� �����ϸ� �޸��嵵 ���� �����.
		p1.waitFor(); // p1 ���μ����� ������ ������ ���.
		p2.destroy(); // p2 ���μ����� ���� ����.
	}
}
