package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Executor;
import annotation.HomeController;
import annotation.InfraredRaySensor;
import annotation.WorkUnit;
import config.SpringConfig;

public class MainConfig {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		Executor exec = ctx.getBean("executor",Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		HomeController home = ctx.getBean("homeController",HomeController.class);
		home.checkSensorAndAlarm(); 
		home.showCameraImage();
		InfraredRaySensor windowSensor = ctx.getBean("windowSensor",InfraredRaySensor.class);
		windowSensor.foundObject();
		InfraredRaySensor doorSensor = ctx.getBean("doorSensor",InfraredRaySensor.class);
		doorSensor.foundObject();
		home.checkSensorAndAlarm();
	}
}
