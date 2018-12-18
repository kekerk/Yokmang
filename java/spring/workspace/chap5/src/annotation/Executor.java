package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Executor {

	private Worker worker;
	
	public void addUnit(WorkUnit workunit) {
		worker.work(workunit);
	}
	
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}
