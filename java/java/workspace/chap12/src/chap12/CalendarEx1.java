package chap12;

import java.util.Calendar;

/*
 * 
 */
public class CalendarEx1 {
	public static void main(String[] args) {
		//Calendar.getInstance() : 실행되는 시점의 날짜로 객체 생성. 
		Calendar today = Calendar.getInstance();
		//today.get(Calendar.YEAR) : Calendar.YEAR 에 해당하는 날짜를 get.
		System.out.println("올해 년도: "+today.get(Calendar.YEAR));
		//이번 달을 표현할 때는 (today.get(Calendar.MONTH)+1)처럼 +1을 해주어야 
		System.out.println("이번 달: "+(today.get(Calendar.MONTH)+1));
		//
		System.out.println("년도 기준 몇째 주: "+today.get(Calendar.WEEK_OF_YEAR));
		//
		System.out.println("월 기준 몇째 주: "+today.get(Calendar.WEEK_OF_MONTH));
		// 오늘이 몇일인지.
		System.out.println("일자: "+today.get(Calendar.DATE));
		//
		System.out.println("월 기준 날짜: "+today.get(Calendar.DAY_OF_MONTH));
		//365일 중 몇번쨰 날인지.
		System.out.println("년도 기준 날짜: "+today.get(Calendar.DAY_OF_YEAR));
		//이번주에서 오늘이 무슨 요일인지.
		System.out.println("요일(1:일 ~ 7:토): "+today.get(Calendar.DAY_OF_WEEK));
		//월 기준 몇번째 수요일인지. 4째 주 수요일이니까. 4
		System.out.println("월 기준 몇째 요일: "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println();
		//시간정보
		System.out.println("시간 정보");
		System.out.println("오전(0),오후(1): " +today.get(Calendar.AM_PM));
		System.out.println("시간(0~11): " +today.get(Calendar.HOUR));
		System.out.println("시간(0~23): " +today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59):"+today.get(Calendar.MINUTE));
		System.out.println("초(0~59):"+today.get(Calendar.SECOND));
		System.out.println("밀리초(0~999):"+today.get(Calendar.MILLISECOND));
		//Calendar.ZONE_OFFSET : 표준시(hour)를 msec로 표현
		System.out.println("Timezone(-12 ~ 12):"+today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
	
		
		System.out.println("이번 달의 마지막 일자: "+today.getActualMaximum(Calendar.DATE));
		
		
		Calendar cal = Calendar.getInstance();
		//
		cal.set(2018,(7-1), 17);
		System.out.print(cal.get(Calendar.YEAR)+"년");
		System.out.print(cal.get(Calendar.MONTH)+1+"월");
		System.out.print(cal.get(Calendar.DATE)+"일 ");
		String week = (cal.get(Calendar.DAY_OF_WEEK)==1)? "일" :
			(cal.get(Calendar.DAY_OF_WEEK)==2)? "월" :
				(cal.get(Calendar.DAY_OF_WEEK)==3)? "화" :
					(cal.get(Calendar.DAY_OF_WEEK)==4)? "수" :
						(cal.get(Calendar.DAY_OF_WEEK)==5)? "목" :
							(cal.get(Calendar.DAY_OF_WEEK)==6)? "금" : "토" ;
		System.out.println(week+"요일");
								
	}
}
