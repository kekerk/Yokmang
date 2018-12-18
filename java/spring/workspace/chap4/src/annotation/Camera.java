package annotation;

import org.springframework.beans.factory.annotation.Required;

public class Camera {
	private int number;
	
	@Required//반드시 집어넣어야 하는 부분 (반드시 실행)?
	public void setNumber(int number) {
		this.number=number;
	}

	@Override
	public String toString() {
		return "Camera [number=" + number + "]";
	}
	
	
}
