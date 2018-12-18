package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //객체화 대상이 되는 클래스. executor 이름으로 컨테이너에 저장됨
public class Executor {
	@Autowired //컨테이너에 속한 객체 중 Worker 객체를 찾아서 주입. DI. 접근제어자가 private인 변수에도 주입 가능.
	private Worker worker;
	
	public void addUnit(WorkUnit workunit) {
		worker.work(workunit);
	}
	
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}
