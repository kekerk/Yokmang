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
		String[] config = {"annotation.xml"};//config�� �迭 ��ü�ν� �������� xml������ ����� �� �ִ�. 
		/*
		 * ctx : Executor ��ü ����. Worker ��ü�� ������ �Ϸ�� ���·�
		 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		Executor exec = ctx.getBean("executor",Executor.class);
		// exec: Executor ��ü�� ����
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		//home : HomeController ��ü�� �����.
		HomeController home = ctx.getBean("homeController",HomeController.class);
		home.checkSensorAndAlarm(); // ��� ��� ����
		home.showCameraImage();
		InfraredRaySensor windowSensor = ctx.getBean("windowSensor",InfraredRaySensor.class);
		windowSensor.foundObject();
		InfraredRaySensor doorSensor = ctx.getBean("doorSensor",InfraredRaySensor.class);
//		InfraredRaySensor doorSensor = new InfraredRaySensor("��������"); -> container�ȿ� ���ԵǾ� ���� �����Ƿ� �ֿܼ� ��µ��� �ʴ´�.
		doorSensor.foundObject();
		home.checkSensorAndAlarm();
		//���� : �θ��� ħ��. ���� , â 
	}
}
