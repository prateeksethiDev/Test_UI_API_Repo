package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.TaskPageObjects;
import testBase.TestBase;

public class TaskCreationSteps {
	
	HomePageObjects homePage= new HomePageObjects();
	TaskPageObjects taskPage=new TaskPageObjects();
	TestBase testBase = new TestBase();
	
	@Given("User clicks on Task sub menu")
	public void user_clicks_on_task_sub_menu() {
		homePage.clickOnSideSubMenu("Tasks", "Add Task");
	}

	@When("^User select project (.*)for task creation$")
	public void user_select_project_for_task_creation(String projectName) {
		taskPage.select_project_for_task_creation(projectName);
	}

	@And("^User select taskType (.*) for task  creation$")
	public void user_select_taskType_for_task_creation(String taskType) {
		taskPage.select_taskType_for_task_creation(taskType);
	}

	@And("^User provided taskName (.*)$")
	public void user_provided_taskName(String taskName) {
		taskPage.enter_taskName(taskName);
	}

	@And("^User provided taskPriority (.*)$")
	public void user_provided_priority(String priority) {
		taskPage.select_priority(priority);
	}
	
	@And("^User provided taskStatus (.*)$")
	public void user_provided_Status(String taskStatus) {
		taskPage.select_Status(taskStatus);
	}

	@And("^User provided taskLabel (.*)$")
	public void user_provided_taskLabel(String taskLabel) {
		taskPage.select_provided_taskLabel(taskLabel);
	}
	
	@And("^User provided taskCreatedBy (.*)$")
	public void user_provided_taskCreatedBy(String taskCreatedBy) {
		taskPage.select_taskCreatedBy(taskCreatedBy);
	}

	@And("User click on task save button")
	public void user_click_on_task_save_button() {
		taskPage.click_on_task_save_button();
	}

	@Then("^I validate the task (.*) from table$")
	public void User_validate_the_createdTask_from_table(String taskName){
		taskPage.validate_the_createdTask_from_table(taskName);
		testBase.tearDown();
	}
		
}