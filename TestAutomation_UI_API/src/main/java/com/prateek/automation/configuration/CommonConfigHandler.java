package com.prateek.automation.configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.files.FilesConfigurationSource;

public class CommonConfigHandler {
	
	private static final String CONFIG_PATH=System.getProperty("user.dir")+"/src/test/resources/";
		
	public static String getConfig(String fileName) {
		return CONFIG_PATH+fileName;
	}
	
	private static Path getPathToConfig(String fileName) {
		return Paths.get(new File(getConfig(fileName)).toURI());
	}
	
	public static CommonConfig buildConfig(String fileName) {
		ConfigurationSource configurationSource =new FilesConfigurationSource(()->Collections.singletonList(getPathToConfig(fileName)));
		ConfigurationProvider configProvider = new ConfigurationProviderBuilder().withConfigurationSource(configurationSource).build();
		AutomationConfig automationConfig=configProvider.bind("automation", AutomationConfig.class);
		ApplicationConfig applicationConfig=configProvider.bind("application", ApplicationConfig.class);		
		return new CommonConfig(automationConfig,applicationConfig);		
	}
}
