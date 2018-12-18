package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Executor;
import annotation.HomeController;
import annotation.InfraredRaySensor;
import annotation.WorkUnit;
/*
 * 
 */
public class MainAnnotation {
	public static void main(String[] args) {
		String[] config = {"annotation.xml"};//config는 배열 객체로써 여러개의 xml파일을 사용할 수 있다. 
		/*
		 * ctx : Executor 객체 생성. Worker 객체가 주입이 완료된 상태로
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		Executor exec = ctx.getBean("executor",Executor.class);
		// exec: Executor 객체가 생성
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		//home : HomeController 객체가 저장됨.
		HomeController home = ctx.getBean("homeController",HomeController.class);
		home.checkSensorAndAlarm(); // 출력 결과 없음
		home.showCameraImage();
		InfraredRaySensor windowSensor = ctx.getBean("windowSensor",InfraredRaySensor.class);
		windowSensor.foundObject();
		InfraredRaySensor doorSensor = ctx.getBean("doorSensor",InfraredRaySensor.class);
//		InfraredRaySensor doorSensor = new InfraredRaySensor("현관센서"); -> container안에 포함되어 있지 않으므로 콘솔에 출력되지 않는다.
		doorSensor.foundObject();
		home.checkSensorAndAlarm();
		//문제 : 두명이 침입. 현관 , 창 
	}
}
