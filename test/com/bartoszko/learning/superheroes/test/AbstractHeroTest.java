package com.bartoszko.learning.superheroes.test;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bartoszko.learning.superheroes.heroes.HeroStatistics;
import com.bartoszko.learning.superheroes.heroes.SuperHero;
import com.bartoszko.learning.superheroes.teams.TeamType;

public class AbstractHeroTest {

	@Test
	public void TestCreatingHeroInTeamRED() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.RED);
		
		//then
		assertThat(testHero.getStats().getAttack(), is(100));
		assertThat(testHero.getStats().getDefense(), is(100));
		assertThat(testHero.getStats().getHealth(), is(150));
	}
	
	@Test
	public void TestCreatingHeroInTeamGREEN() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.GREEN);
		
//		then
		Assert.assertEquals(100, testHero.getStats().getAttack(), 0);
		Assert.assertEquals(150, testHero.getStats().getDefense(), 0);
		Assert.assertEquals(100, testHero.getStats().getHealth(), 0);
	}

	@Test
	public void TestCreatingHeroInTeamBLUE() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		
		//then
		Assert.assertEquals(150, testHero.getStats().getAttack(), 0);
		Assert.assertEquals(100, testHero.getStats().getDefense(), 0);
		Assert.assertEquals(100, testHero.getStats().getHealth(), 0);
	}
	
	@Test
	public void CreatedHeroShouldReturnProperTeamTepe() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		
		//then
		Assert.assertEquals(TeamType.BLUE, testHero.getTeam());
	}
	
	@Test
	public void CreatedHeroShouldBeAlive() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		
		//then
		Assert.assertEquals(true, testHero.isAlive());
		Assert.assertEquals(100, testHero.getStats().getHealth());
	}
	
	@Test
	public void CreatedHeroShouldBeKilled() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		testHero.isKilled();
		
		//then
		Assert.assertEquals(false, testHero.isAlive());
		Assert.assertEquals(0, testHero.getStats().getHealth());
	}

	@Test
	public void CreatedHeroShouldBeWoundedButAlive() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		int attackStrength = (stats.getHealth()-10);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		testHero.isWounded(attackStrength);
		
		//then
		Assert.assertEquals(true, testHero.isAlive());
		Assert.assertEquals(10, testHero.getStats().getHealth(), 0);
	}
	
	@Test
	public void CreatedHeroShouldBeWoundedAndKilled() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		int attackStrength = (1200);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		testHero.isWounded(attackStrength);
		
		//then
		Assert.assertEquals(false, testHero.isAlive());
		Assert.assertEquals(0, testHero.getStats().getHealth(), 0); //why 0, not -something??
	}
	
	@Test
	public void CreatedHeroStatusShouldBeSetToAlive() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		testHero.isKilled();
		testHero.setAliveToTrue();
		
		//then
		Assert.assertEquals(true, testHero.isAlive());
		Assert.assertEquals(0, testHero.getStats().getHealth(), 0);
	}
	
	@Test
	public void CreatedHeroStatusShouldBeRessurected() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.BLUE);
		testHero.isKilled();
		testHero.isResurrected();
		
		//then
		Assert.assertEquals(true, testHero.isAlive());
		Assert.assertEquals(100, testHero.getStats().getHealth(), 0);
	}
	
	@Test
	public void CreatedHeroInTeamREDStatusShouldBeRessurected() {
		//given
		HeroStatistics stats = new HeroStatistics(100, 100, 100);
		
		//when
		SuperHero testHero = new SuperHero("testHero", stats, TeamType.RED);
		testHero.isKilled();
		testHero.isResurrected();
		
		//then
		Assert.assertEquals(true, testHero.isAlive());
		Assert.assertEquals(150, testHero.getStats().getHealth(), 0);
	}
}
