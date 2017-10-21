package com.sda.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;


public class HeroCreatorTest {
	
	@Test
	public void shouldCreateHeroWithTeamTypeRed() {
		//given
		String name = "HeroName";
		TeamType teamType = TeamType.RED;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero hero = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(health+50));
		assertThat(hero.getStats().getAttack(), is(attack));
		assertThat(hero.getStats().getDefense(), is(defense));
	}

	@Test
	public void shouldCreateHeroWithTeamTypeBlue() {
		//given
		String name = "HeroName";
		TeamType teamType = TeamType.BLUE;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero hero = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(health));
		assertThat(hero.getStats().getAttack(), is(attack+50));
		assertThat(hero.getStats().getDefense(), is(defense));
	}

	@Test
	public void shouldCreateHeroWithTeamTypeGreen() {
		//given
		String name = "HeroName";
		TeamType teamType = TeamType.GREEN;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero hero = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(health));
		assertThat(hero.getStats().getAttack(), is(attack));
		assertThat(hero.getStats().getDefense(), is(defense+50));
	}
		
	@Test
	public void shouldCreateVillainWithTeamTypeRed() {
		//given
		String name = "VillainName";
		TeamType teamType = TeamType.RED;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero villain = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(health+50));
		assertThat(villain.getStats().getAttack(), is(attack));
		assertThat(villain.getStats().getDefense(), is(defense));
	}
	
	@Test
	public void shouldCreateVillainWithTeamTypeBlue() {
		//given
		String name = "VillainName";
		TeamType teamType = TeamType.BLUE;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero villain = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(health));
		assertThat(villain.getStats().getAttack(), is(attack+50));
		assertThat(villain.getStats().getDefense(), is(defense));
	}
	
	@Test
	public void shouldCreateVillainWithTeamTypeGreen() {
		//given
		String name = "VillainName";
		TeamType teamType = TeamType.GREEN;
		int health = 100;
		int attack = 100;
		int defense = 100;
		
		//when
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
		SuperHero villain = HeroCreator.createHero(name, stats, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(health));
		assertThat(villain.getStats().getAttack(), is(attack));
		assertThat(villain.getStats().getDefense(), is(defense+50));
	}
	
	@Test
	public void shouldCreateHeroWIthDefaultStatsAndTeamTypeRed() {
		//given
		String name = "Batman";
		TeamType teamType = TeamType.RED;
		
		//when
		SuperHero hero = HeroCreator.createHeroWithDefaultStats(name, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(100+50));
		assertThat(hero.getStats().getAttack(), is(100));
		assertThat(hero.getStats().getDefense(), is(100));
	}
	
	@Test
	public void shouldCreateHeroWIthDefaultStatsAndTeamTypeBlue() {
		//given
		String name = "Batman";
		TeamType teamType = TeamType.BLUE;
		
		//when
		SuperHero hero = HeroCreator.createHeroWithDefaultStats(name, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(100));
		assertThat(hero.getStats().getAttack(), is(100+50));
		assertThat(hero.getStats().getDefense(), is(100));
	}
	
	@Test
	public void shouldCreateHeroWIthDefaultStatsAndTeamTypeGreen() {
		//given
		String name = "Batman";
		TeamType teamType = TeamType.GREEN;
		
		//when
		SuperHero hero = HeroCreator.createHeroWithDefaultStats(name, teamType);
		
		//then
		assertThat(hero.getName(), is(name));
		assertThat(hero.getTeam(), is(teamType));
		assertThat(hero.getStats().getHealth(), is(100));
		assertThat(hero.getStats().getAttack(), is(100));
		assertThat(hero.getStats().getDefense(), is(100+50));
	}
	
	@Test
	public void shouldCreateVillainWIthDefaultStatsAndTeamTypeRed() {
		//given
		String name = "Joker";
		TeamType teamType = TeamType.RED;
		
		//when
		Villain villain = HeroCreator.createVillainWithDefaultStats(name, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(100+50));
		assertThat(villain.getStats().getAttack(), is(100));
		assertThat(villain.getStats().getDefense(), is(100));
	}
	
	@Test
	public void shouldCreateVillainWIthDefaultStatsAndTeamTypeBlue() {
		//given
		String name = "Joker";
		TeamType teamType = TeamType.BLUE;
		
		//when
		Villain villain = HeroCreator.createVillainWithDefaultStats(name, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(100));
		assertThat(villain.getStats().getAttack(), is(100+50));
		assertThat(villain.getStats().getDefense(), is(100));
	}
	
	@Test
	public void shouldCreateVillainWIthDefaultStatsAndTeamTypeGreen() {
		//given
		String name = "Joker";
		TeamType teamType = TeamType.GREEN;
		
		//when
		Villain villain = HeroCreator.createVillainWithDefaultStats(name, teamType);
		
		//then
		assertThat(villain.getName(), is(name));
		assertThat(villain.getTeam(), is(teamType));
		assertThat(villain.getStats().getHealth(), is(100));
		assertThat(villain.getStats().getAttack(), is(100));
		assertThat(villain.getStats().getDefense(), is(100+50));
	}
}
