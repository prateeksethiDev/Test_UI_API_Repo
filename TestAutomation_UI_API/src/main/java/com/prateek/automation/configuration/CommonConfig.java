package com.prateek.automation.configuration;

public class CommonConfig {
	
private final AutomationConfig automationConfig;
private final ApplicationConfig applicationConfig;

public CommonConfig(AutomationConfig automationConfig, ApplicationConfig applicationConfig) {
	this.automationConfig = automationConfig;
	this.applicationConfig = applicationConfig;
}

public AutomationConfig getAutomationConfig() {
	return automationConfig;
}

public ApplicationConfig getApplicationConfig() {
	return 	applicationConfig;
}

}