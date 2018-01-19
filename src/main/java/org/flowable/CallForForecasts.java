package org.flowable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.zip.ZipInputStream;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.form.api.FormDefinition;
import org.flowable.form.api.FormDeployment;
import org.flowable.form.api.FormRepositoryService;
import org.flowable.form.engine.FormEngine;
import org.flowable.form.engine.FormEngines;

public class CallForForecasts {
	public static void main (String[] args) throws FileNotFoundException {
		//// ENGINE CONFIGURATION
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		FormEngine formEngine = FormEngines.getDefaultFormEngine();
		
		//// PROCESS DEPLOYMENT
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("Call_for_forecasts.bpmn20.xml").deploy();
		
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