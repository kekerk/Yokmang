package annotation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class HomeController {
	private AlarmDevice alarmDevice;
	private Viewer viewer;


	private Camera camera1;

	private Camera camera2;

	private Camera camera3;

	private Camera camera4;

	private List<InfraredRaySensor> sensors;

	private Recorder recorder;


	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		// alarmDevice : SnsAlarmDevice 객체가 주입.
		// viewer : MonitorViewer 객체가 주입.
		this.alarmDevice = alarmDevice;
		this.viewer = viewer;
	}
// ApplicationContext ctx = new ClassPathXmlApplicationContext(config); 실행부분
	//(2)

	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		System.out.println(recorder);
	}

	//제일 먼저 주입(1)


	public void setSensors(List<InfraredRaySensor> sensors) {
		// sensors : windowSensor 객체와 doorSensor 객체만 주입.
		this.sensors = sensors;
		for (InfraredRaySensor s : sensors) {
			System.out.println("센서 등록: " + s);
		}
	}
// -----------------------------------------------------------------------------
	public void checkSensorAndAlarm() {
		for (InfraredRaySensor s : sensors) {
			if (s.isObjectFounded()) { //출력 결과 없음
				alarmDevice.alarm(s.getName());
			}
		}
	}
	
	public void showCameraImage() {
		viewer.draw();
	}
	
	public void setCamera1(Camera camera1) {
		this.camera1 = camera1;
	}
	public void setCamera2(Camera camera2) {
		this.camera2 = camera2;
	}
	public void setCamera3(Camera camera3) {
		this.camera3 = camera3;
	}
	public void setCamera4(Camera camera4) {
		this.camera4 = camera4;
	}
	
}
/*
 * 기본 어노테이션
 * 1.객체 생성 : @Component
 * 2.객체 주입 
 * 	  @Autowired : 객체 선택 기준이  클래스의 자료형. 
 * 				   (required=false) : 객체가 없는 경우 주입 안해도 됨.
 * 				   (required=true)  : 객체 주입 반드시 해야 함. 기본값.
 * 	  @Required :  객체 선택 기준이  클래스의 자료형. 반드시 주입해야함. 주입할 객체가 없으면 오류 발생.
 *    @Resource("이름") : 컨테이너에서 "이름"을 가진 객체를 주입함.  
 * 3.그외
 *   @Qualifier("별명") : 객체에 별명이 있는 경우 별명으로 객체를 인식함. @Autowired에 선택기준으로 사용함.   
 *   @Scope(...) : 일회용 객체를 생성함. @Component와 함께 사용함.
 *   @PostConstruct : 객체 생성 후에 호출되는 메서드를 지정.
 */
