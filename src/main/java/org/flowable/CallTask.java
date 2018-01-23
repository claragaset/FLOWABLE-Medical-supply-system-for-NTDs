package org.flowable;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CallTask implements JavaDelegate {

	ResultSet rs;
	
	public void execute(DelegateExecution execution) {
			
		if (execution.getCurrentActivityId().equals("serviceTask1")) { // task id
			System.out.println("Task id EXECUTION");
			SingletonConnection connectionClass = SingletonConnection.getInstance();
			ResultSet rs;
			execution.setVariable("test", 0);
			try {
				rs = connectionClass.executeQuery("SELECT count(*) FROM public.\"Forecast\" WHERE \"forecastSubmitted\";");
				if (rs.next()) { execution.setVariable("test", rs.getInt("count"));	}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
//		if (execution.getProcessDefinitionId().split(":")[0].equals("CallforforecastsHTTP")) { //process id
//			System.out.println("Process id EXECUTION");
//			execution.setVariable("test", "Hi, if you are reading this Clara will be happy");
//		}
		
		// both options work
	}

}
