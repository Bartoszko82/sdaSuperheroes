package com.bartoszko.learning.superheroes.tests;

import org.junit.Test;

import com.bartoszko.learning.superheroes.utils.PropertyReader;

public class PropertyReaderTest {

	@Test
	public void testReadPropertyFile(){
		PropertyReader.loadPropertyValues();
		System.out.println("Hero base name is: "+System.getProperty("config.superHeroBaseName"));
	}
}
