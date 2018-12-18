package annotation;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
	private AlarmDevice alarmDevice;
	private Viewer viewer;

	// ī�޶� ��ü 4�� �ʿ�
	@Resource(name = "camera1")
	private Camera camera1; //setNumber=1
	@Resource(name = "camera2")
	private Camera camera2; //setNumber=2
	@Resource(name = "camera3")
	private Camera camera3; //setNumber=3
	@Resource(name = "camera4")
	private Camera camera4; //setNumber=4

	private List<InfraredRaySensor> sensors;
	@Autowired(required = false) // required = false : true�� ����, false��  ���Ծ���.
	private Recorder recorder;

	@Autowired
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		// alarmDevice : SnsAlarmDevice ��ü�� ����.
		// viewer : MonitorViewer ��ü�� ����.
		this.alarmDevice = alarmDevice;
		this.viewer = viewer;
	}
// ApplicationContext ctx = new ClassPathXmlApplicationContext(config); ����κ�
	//(2)
	@PostConstruct //��ü�� �� ��������� �Ǹ� init() �޼ҵ带 ȣ�� 
	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		System.out.println(recorder);
	}

	//���� ���� ����(1)
	@Autowired //�ݵ�� �־�� �ϴ� ��
	@Qualifier("intrusionDetection") // ������ ���� ��ü�� ����.
	public void setSensors(List<InfraredRaySensor> sensors) {
		// sensors : windowSensor ��ü�� doorSensor ��ü�� ����.
		this.sensors = sensors;
		for (InfraredRaySensor s : sensors) {
			System.out.println("���� ���: " + s);
		}
	}
// -----------------------------------------------------------------------------
	public void checkSensorAndAlarm() {
		for (InfraredRaySensor s : sensors) {
			if (s.isObjectFounded()) { //��� ��� ����
				alarmDevice.alarm(s.getName());
			}
		}
	}
	
	public void showCameraImage() {
		viewer.draw();
	}
}
/*
 * �⺻ ������̼�
 * 1.��ü ���� : @Component
 * 2.��ü ���� 
 * 	  @Autowired : ��ü ���� ������  Ŭ������ �ڷ���. 
 * 				   (required=false) : ��ü�� ���� ��� ���� ���ص� ��.
 * 				   (required=true)  : ��ü ���� �ݵ�� �ؾ� ��. �⺻��.
 * 	  @Required :  ��ü ���� ������  Ŭ������ �ڷ���. �ݵ�� �����ؾ���. ������ ��ü�� ������ ���� �߻�.
 *    @Resource("�̸�") : �����̳ʿ��� "�̸�"�� ���� ��ü�� ������.  
 * 3.�׿�
 *   @Qualifier("����") : ��ü�� ������ �ִ� ��� �������� ��ü�� �ν���. @Autowired�� ���ñ������� �����.   
 *   @Scope(...) : ��ȸ�� ��ü�� ������. @Component�� �Բ� �����.
 *   @PostConstruct : ��ü ���� �Ŀ� ȣ��Ǵ� �޼��带 ����.
 */
