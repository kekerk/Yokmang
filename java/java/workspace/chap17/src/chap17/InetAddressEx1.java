package chap17;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress 클래스.
 * 1. IP 주소정보를 관리하는 클래스.
 * 2. 생성자의 접근 제어가 default => 프로그래머는 객체 생성 불가.
 * 3. static 메서드를 이용하여 객체 생성함.
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		// 도메인 명으로 InetAddress 객체 생성.
		InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
		System.out.println("getByName() 메서드를 이용한 InetAddress 객체 생성");
		System.out.println("hostname: " + ip.getHostName());
		// ip.getHostAddress() : 홈페이지의 실제 IP 주소값 리턴.
		System.out.println("ip address: " + ip.getHostAddress());
		System.out.println();
		
		
		// 도메인 명으로 InetAddress 객체 모두 생성.
		System.out.println("getAllByName() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress ips[] = InetAddress.getAllByName("www.naver.com");
		for (InetAddress i : ips) {
			System.out.println("IP 주소: " + i);
		}
		System.out.println();

		// ip 8bit씩 배열 형태로 출력하는 메서드.
		byte[] ipAddr = ip.getAddress();
		for (byte b : ipAddr) {
			System.out.print(((b < 0) ? b + 256 : b) + ".");
		}
		System.out.println();

		// getLocalHost() : 내 컴퓨터의 InetAddress 객체 생성.
		// 내 주소를 확인할 때.
		System.out.println("getLocalHost() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내컴퓨터 IP: " + local);
		System.out.println();
		//
		System.out.println("getByAddress() 메서드를 이용한 InetAddress 객체 생성");
		InetAddress ip2 = InetAddress.getByAddress(ips[0].getAddress());
		System.out.println(ips[0].getHostAddress() + "주소 : " + ip2);
		System.out.println();

		byte[] ipbyte = { 183 - 256, 111, 161 - 256, 105 };
		InetAddress ip3 = InetAddress.getByAddress(ipbyte);
		System.out.println("183.111.161.105 주소: " + ip3);
	}
}
