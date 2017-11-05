package com.bartoszko.learning.superheroes.main;

public class AppContext {

	private String uiClassQualifiedName;
	
	
	public void setUiClassQualifiedName(String passedName) {
		this.uiClassQualifiedName = passedName;
	}
	
	public String getUiClassQualifiedName() {
		return uiClassQualifiedName;
	}
	
}
