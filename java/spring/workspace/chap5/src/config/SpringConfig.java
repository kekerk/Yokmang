package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import annotation.AlarmDevice;
import annotation.Camera;
import annotation.DisplayMode;
import annotation.Executor;
import annotation.HomeController;
import annotation.InfraredRaySensor;
import annotation.MonitorViewer;
import annotation.SnsAlarmDevice;
import annotation.Viewer;
import annotation.Worker;

@Configuration //�����̳ʿ� ������ ����ϴ� Ŭ���� ����, xml ���� ��ü�ϴ� �ڹټ���������.
public class SpringConfig {
	/*
	 * <bean id="executor" class="annotation.Executor" p:worker-ref = "worker" />
	 */
	@Bean //return value�� ��ü�� ����. ��ü�� �̸��� �޼����� �̸����� ����.
	public Executor executor() {
		Executor exec = new Executor();
		exec.setWorker(worker());
		return exec;
	}
	@Bean // ��üȭ�� �Ǿ� �����̳ʿ� ����
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)//��ȸ�� ��ü�� ����
	public Worker worker() {
		return new Worker();
	}
	@Bean
	public Camera camera1() { 
		Camera c = new Camera(); 
		c.setNumber(1);
		return c;
	}
	@Bean
	public Camera camera2() { 
		Camera c = new Camera(); 
		c.setNumber(2);
		return c;
	}
	@Bean
	public Camera camera3() { 
		Camera c = new Camera(); 
		c.setNumber(3);
		return c;
	}
	@Bean
	public Camera camera4() { 
		Camera c = new Camera(); 
		c.setNumber(4);
		return c;
	}
	@Bean
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("â����");
	}
	@Bean
	public InfraredRaySensor doorSensor() {
		return new InfraredRaySensor("��������");
	}
	@Bean
	public InfraredRaySensor lampSensor() {
		return new InfraredRaySensor("�����");
	}
	
	@Bean
	public AlarmDevice alarmDevice() {
		return new SnsAlarmDevice();
	}
	
	@Bean
	public Viewer viewer() {
		MonitorViewer viewer = new MonitorViewer();
		viewer.setDisplayMode(displayMode());
		return viewer;
	}
	
	@Bean
	public DisplayMode displayMode() {
		DisplayMode mode = new DisplayMode();
		mode.setType("GRID");
		return mode;
	}

	@Bean(initMethod="init") 
	public HomeController homeController() {
		HomeController homeController = new HomeController();
		List<InfraredRaySensor> sensors = new ArrayList<InfraredRaySensor>();
		sensors.add(windowSensor());
		sensors.add(doorSensor());
		
		homeController.setSensors(sensors);
		homeController.prepare(alarmDevice(), viewer());
		homeController.setCamera1(camera1());
		homeController.setCamera2(camera2());
		homeController.setCamera3(camera3());
		homeController.setCamera4(camera4());
		return homeController;
		
	}
}
