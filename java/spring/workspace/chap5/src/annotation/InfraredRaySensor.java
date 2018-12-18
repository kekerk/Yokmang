package annotation;

public class InfraredRaySensor {
	private String name;
	private boolean objectFounded;
	public InfraredRaySensor(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public boolean isObjectFounded() { //ObjectFounded : getProperty°¡ µÈ´Ù.
		return objectFounded;
	}
	
	public void foundObject() {
		this.objectFounded = true;
	}
	
	@Override
	public String toString() {
		return "InfraredRaySensor [name=" + name + ", objectFounded=" + objectFounded + "]";
	}

}
