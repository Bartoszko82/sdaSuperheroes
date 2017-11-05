package com.bartoszko.learning.superheroes.main;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	static List<String> validArgsList;

	public static void main(String[] args) {
		App app = new App();	
		AppContext appContext = new AppContext();	
		
		validArgsList = validateArgs(args);
		
		appContext.setUiClassQualifiedName(selectUIClassQualifiedName());
		//place for more arguments 
		
		app.initialize(appContext);
		app.run();
		app.shutdown();
	}
	
	private static List<String> validateArgs(String[] args) {
		List<String> validArgsList = Arrays.asList(args);
		//TODO
		return validArgsList;
	}
	
	private static String selectUIClassQualifiedName() {
		boolean isTextUIrequired =  validArgsList.stream()
					.anyMatch(s -> s.contains("--txt"));
		String uiClassQualifiedName = isTextUIrequired ? "com.bartoszko.learning.superheroes.ui.TextUI" : "com.bartoszko.learning.superheroes.ui.GraphicUI";
		return uiClassQualifiedName;
	}
}
