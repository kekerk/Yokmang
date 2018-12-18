package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitorViewer implements Viewer{
	@Autowired
	private DisplayMode displayMode;
	@Override
	public void add(Camera camera) {
		System.out.println("����Ϳ� "+camera+" ���� �߰�"); //Camera�� toString()
	}

	@Override
	public void draw() {
	System.out.println(displayMode.getType()+" ���� ī�޶� �̹��� ��µ�");
	}

}