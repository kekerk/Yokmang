package chap17;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress Ŭ����.
 * 1. IP �ּ������� �����ϴ� Ŭ����.
 * 2. �������� ���� ��� default => ���α׷��Ӵ� ��ü ���� �Ұ�.
 * 3. static �޼��带 �̿��Ͽ� ��ü ������.
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		// ������ ������ InetAddress ��ü ����.
		InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
		System.out.println("getByName() �޼��带 �̿��� InetAddress ��ü ����");
		System.out.println("hostname: " + ip.getHostName());
		// ip.getHostAddress() : Ȩ�������� ���� IP �ּҰ� ����.
		System.out.println("ip address: " + ip.getHostAddress());
		System.out.println();
		
		
		// ������ ������ InetAddress ��ü ��� ����.
		System.out.println("getAllByName() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress ips[] = InetAddress.getAllByName("www.naver.com");
		for (InetAddress i : ips) {
			System.out.println("IP �ּ�: " + i);
		}
		System.out.println();

		// ip 8bit�� �迭 ���·� ����ϴ� �޼���.
		byte[] ipAddr = ip.getAddress();
		for (byte b : ipAddr) {
			System.out.print(((b < 0) ? b + 256 : b) + ".");
		}
		System.out.println();

		// getLocalHost() : �� ��ǻ���� InetAddress ��ü ����.
		// �� �ּҸ� Ȯ���� ��.
		System.out.println("getLocalHost() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("����ǻ�� IP: " + local);
		System.out.println();
		//
		System.out.println("getByAddress() �޼��带 �̿��� InetAddress ��ü ����");
		InetAddress ip2 = InetAddress.getByAddress(ips[0].getAddress());
		System.out.println(ips[0].getHostAddress() + "�ּ� : " + ip2);
		System.out.println();

		byte[] ipbyte = { 183 - 256, 111, 161 - 256, 105 };
		InetAddress ip3 = InetAddress.getByAddress(ipbyte);
		System.out.println("183.111.161.105 �ּ�: " + ip3);
	}
}
