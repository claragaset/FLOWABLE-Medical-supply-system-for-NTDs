package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CallTask implements JavaDelegate {

	public void execute(DelegateExecution execution) {
		if (execution.getCurrentActivityId().equals("serviceTask1")) { // task id
			System.out.println("Task id EXECUTION");
			execution.setVariable("test", "Hi, if you are reading this Clara will be happy");
		}
		
		if (execution.getProcessDefinitionId().split(":")[0].equals("CallforforecastsHTTP")) { //process id
			System.out.println("Process id EXECUTION");
			execution.setVariable("test", "Hi, if you are reading this Clara will be happy");
		}
		
		// both options work
	}

}
