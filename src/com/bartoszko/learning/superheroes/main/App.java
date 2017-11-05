package com.bartoszko.learning.superheroes.main;

import com.bartoszko.learning.superheroes.ui.UserInterface;
import com.bartoszko.learning.superheroes.utils.MyScanner;

public class App {

	UserInterface UI; 
	
	public void initialize(AppContext appContext) {
		String uiClassQualifiedName = appContext.getUiClassQualifiedName(); 
		try {
			UI = (UserInterface) Class.forName(uiClassQualifiedName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyScanner.getScanner();
	}	
		
	public void run() {
		System.out.println(UI);
		

	}
	
	public void shutdown() {
		System.out.println("app shutdown");
		MyScanner.closeScanner();
	}
}