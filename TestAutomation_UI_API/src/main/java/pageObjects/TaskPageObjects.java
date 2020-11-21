package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.DriverFactory;
import testBase.TestBase;

public class TaskPageObjects extends TestBase{
	
	By btn_addTask=By.xpath("//td/button[text()='Add Task']");
	By fieldsearch=By.id("search_menu");
	By txt_search=By.id("search_keywords");
	By btn_search=By.xpath("//input[@value='Search']");
	By dd_SelectProjectForTaskCreation=By.id("form_projects_id");
	By dd_SelectTaskTypeForTaskCreation=By.id("tasks_tasks_type_id");
	By dd_TaskName=By.id("tasks_name");
	By dd_TaskStatus=By.id("tasks_tasks_status_id");
	By dd_TaskPriority=By.id("tasks_tasks_priority_id");
	By dd_TaskLabel=By.id("tasks_tasks_label_id");
	By dd_TaskCreatedBy=By.id("tasks_created_by");
	By btn_Save=By.xpath("//button[@class='btn btn-primary'][text()='Save']");
	
	
	public void select_project_for_task_creation(String projectName) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_SelectProjectForTaskCreation), "NewTaskProjectDropdown", projectName);
	}

	
	public void select_taskType_for_task_creation(String taskType) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_SelectTaskTypeForTaskCreation), "NewTaskTypeDropdown", taskType);
	}

	
	public void enter_taskName(String taskName) {
		sendKeys(DriverFactory.getInstance().getDriver().findElement(dd_TaskName), "TaskName", taskName);
	}

	
	public void select_Status(String taskStatus) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_TaskStatus), "TaskStatus", taskStatus);
	}

	
	public void select_priority(String priority) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_TaskPriority),"TaskPriority" ,priority);
	}

	
	public void select_provided_taskLabel(String taskLabel) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_TaskLabel), "TaskLabel", taskLabel); 
	}
	
	public void select_taskCreatedBy(String taskCreatedBy) {
		selectDropDownByVisibleText(DriverFactory.getInstance().getDriver().findElement(dd_TaskCreatedBy), "TaskCreatedBy", taskCreatedBy); 
	}
	
	public void click_on_task_save_button() {
		click(DriverFactory.getInstance().getDriver().findElement(btn_Save), "TaskSaveButton");
	}

	
	public void validate_the_createdTask_from_table(String taskName) {
		for(WebElement ele:getTaskCellValueByColumnIndex(5)) {
			if(ele.getText().equalsIgnoreCase(taskName)) {
				assertEqualsString(taskName, ele.getText(), "TaskNameInTable");
			}
		}	
	}
	
	private List<WebElement> getTaskCellValueByColumnIndex(int index) {
		String valueXpath="//table[starts-with(@id,'itmes_listing')]/tbody/tr/td[5]";
		return DriverFactory.getInstance().getDriver().findElements(By.xpath(valueXpath));
	}
}
