package com.sda.tests;

import org.junit.Test;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.teams.TeamType;

public class AbstractHeroTest {

	@Test
	public void TestCreatingHero() {
		HeroStatistics stats = new HeroStatistics(100, 50, 100);
		SuperHero batman = new SuperHero("Batman", stats, TeamType.RED);
		
	
		System.out.println(batman.getStats().getHealth());
		
		
	}
}
