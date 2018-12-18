package annotation;

import org.springframework.beans.factory.annotation.Required;

public class Camera {
	private int number;
	

	public void setNumber(int number) {
		this.number=number;
	}

	@Override
	public String toString() {
		return "Camera [number=" + number + "]";
	}
	
	
}
