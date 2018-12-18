package chap12;

import java.util.Calendar;

/*
 * 
 */
public class CalendarEx1 {
	public static void main(String[] args) {
		//Calendar.getInstance() : ����Ǵ� ������ ��¥�� ��ü ����. 
		Calendar today = Calendar.getInstance();
		//today.get(Calendar.YEAR) : Calendar.YEAR �� �ش��ϴ� ��¥�� get.
		System.out.println("���� �⵵: "+today.get(Calendar.YEAR));
		//�̹� ���� ǥ���� ���� (today.get(Calendar.MONTH)+1)ó�� +1�� ���־�� 
		System.out.println("�̹� ��: "+(today.get(Calendar.MONTH)+1));
		//
		System.out.println("�⵵ ���� ��° ��: "+today.get(Calendar.WEEK_OF_YEAR));
		//
		System.out.println("�� ���� ��° ��: "+today.get(Calendar.WEEK_OF_MONTH));
		// ������ ��������.
		System.out.println("����: "+today.get(Calendar.DATE));
		//
		System.out.println("�� ���� ��¥: "+today.get(Calendar.DAY_OF_MONTH));
		//365�� �� ����� ������.
		System.out.println("�⵵ ���� ��¥: "+today.get(Calendar.DAY_OF_YEAR));
		//�̹��ֿ��� ������ ���� ��������.
		System.out.println("����(1:�� ~ 7:��): "+today.get(Calendar.DAY_OF_WEEK));
		//�� ���� ���° ����������. 4° �� �������̴ϱ�. 4
		System.out.println("�� ���� ��° ����: "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println();
		//�ð�����
		System.out.println("�ð� ����");
		System.out.println("����(0),����(1): " +today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11): " +today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23): " +today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59):"+today.get(Calendar.MINUTE));
		System.out.println("��(0~59):"+today.get(Calendar.SECOND));
		System.out.println("�и���(0~999):"+today.get(Calendar.MILLISECOND));
		//Calendar.ZONE_OFFSET : ǥ�ؽ�(hour)�� msec�� ǥ��
		System.out.println("Timezone(-12 ~ 12):"+today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
	
		
		System.out.println("�̹� ���� ������ ����: "+today.getActualMaximum(Calendar.DATE));
		
		
		Calendar cal = Calendar.getInstance();
		//
		cal.set(2018,(7-1), 17);
		System.out.print(cal.get(Calendar.YEAR)+"��");
		System.out.print(cal.get(Calendar.MONTH)+1+"��");
		System.out.print(cal.get(Calendar.DATE)+"�� ");
		String week = (cal.get(Calendar.DAY_OF_WEEK)==1)? "��" :
			(cal.get(Calendar.DAY_OF_WEEK)==2)? "��" :
				(cal.get(Calendar.DAY_OF_WEEK)==3)? "ȭ" :
					(cal.get(Calendar.DAY_OF_WEEK)==4)? "��" :
						(cal.get(Calendar.DAY_OF_WEEK)==5)? "��" :
							(cal.get(Calendar.DAY_OF_WEEK)==6)? "��" : "��" ;
		System.out.println(week+"����");
								
	}
}
