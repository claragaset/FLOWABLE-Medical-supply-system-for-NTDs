package org.flowable;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallForForecasts {
	public static void main (String[] args) throws FileNotFoundException {
		
		ResultSet rs;
		SingletonConnection connectionClass = SingletonConnection.getInstance();
		try {
			rs = connectionClass.executeQuery("SELECT count(*) FROM public.\"Forecast\" WHERE \"forecastSubmitted\";");
			if (rs.next())
			{
				System.out.println (rs.getInt("count"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//// ENGINE CONFIGURATION
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//		FormEngine formEngine = FormEngines.getDefaultFormEngine();
		
		//// PROCESS DEPLOYMENT
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		Deployment deployment = repositoryService.createDeployment().addClasspathResource("Call_for_forecasts.bpmn20.xml").deploy();
		
//		String barFileName = "deployment/Deployment.zip";
//		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(barFileName));
//		Deployment deployment = repositoryService.createDeployment().addZipInputStream(inputStream).deploy();

		/// FORM DEPLOYMENT
//		FormRepositoryService formRepositoryService = formEngine.getFormRepositoryService();
//
//		FormDeployment formDeployment = formRepositoryService.createDeployment()
//		    .addClasspathResource("EnoughSubmissions.form")
//		    .deploy();
		
		
		/// CREATE PROCESS DEFINITION
//		ArrayList<ProcessDefinition> processDefinition = (ArrayList<ProcessDefinition>) repositoryService.createProcessDefinitionQuery().deploymentId("82501").list();
//		System.out.println ("Found process definition (name): " + processDefinition.get(1).getVersion());
//		FormDefinition formDefinition = formRepositoryService.createFormDefinitionQuery().deploymentId(formDeployment.getId()).singleResult();
//		System.out.println ("Found form definition (key): " + formDefinition.getKey());
	}
}