package com.bartoszko.learning.superheroes.test;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bartoszko.learning.superheroes.utils.PropertyReader;

public class PropertyReaderTest {

	@Test
	public void testReadPropertyFile(){
		// given
		
		// when
		PropertyReader.loadPropertyValues();
		
		// then
		assertThat(System.getProperty("config.superHeroBaseName"), is("Hero"));
		assertThat(System.getProperty("config.superHeroBaseHealth"), is("100"));
		assertThat(System.getProperty("config.superHeroBaseAttack"), is("100"));
		assertThat(System.getProperty("config.superHeroBaseDefense"), is("100"));
	}
}
