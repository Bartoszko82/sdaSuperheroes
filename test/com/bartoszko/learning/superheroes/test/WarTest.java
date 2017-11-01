package com.bartoszko.learning.superheroes.test;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;
import com.bartoszko.learning.superheroes.heroes.HeroStatistics;
import com.bartoszko.learning.superheroes.heroes.SuperHero;
import com.bartoszko.learning.superheroes.heroes.Villain;
import com.bartoszko.learning.superheroes.teams.InvalidHeroTeamException;
import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamControl;
import com.bartoszko.learning.superheroes.teams.TeamType;
import com.bartoszko.learning.superheroes.utils.HeroCreator;
import com.bartoszko.learning.superheroes.utils.War;

//@RunWith(MockitoJUnitRunner.class)
public class WarTest {
	
	private static AbstractHero heroRED1;
	private static AbstractHero heroRED2;
	private static AbstractHero deadHeroRED1;
	private static AbstractHero deadHeroRED2;
	private static AbstractHero villainRED1;
	private static AbstractHero villainRED2;
	private static AbstractHero deadVillainRED1;
	private static AbstractHero deadVillainRED2;
	private static Team teamHeroes;
	private static Team teamVillains;
	private static Team teamWithNoHeroes;
	private static Team teamWithDeadHeroes;
	
	private Scanner scanner;
	
	
//	private double RED_HERO_POWER = 30000;
//	private double BLUE_HERO_POWER = 25000;
//	private double GREEN_HERO_POWER = 25000;
//	private double RED_VILLAIN_POWER = 25000;
//	private double BLUE_VILLAIN_POWER = 25000;
//	private double GREEN_VILLAIN_POWER = 30000;
	
	@BeforeClass
	public static void creatingHeroesAndVillains() {
		heroRED1 = HeroCreator.createHero("GoodGuyRED1", new HeroStatistics(100, 100, 100), TeamType.RED);
		heroRED2 = HeroCreator.createHero("GoodGuyRED2", new HeroStatistics(100, 100, 100), TeamType.RED);
		deadHeroRED1 = HeroCreator.createHero("GoodGuyRED3", new HeroStatistics(100, 100, 100), TeamType.RED);
		deadHeroRED2 = HeroCreator.createHero("GoodGuyRED4", new HeroStatistics(100, 100, 100), TeamType.RED);
		
		villainRED1 = HeroCreator.createVillain("BadGuyRED1", new HeroStatistics(100, 100, 100), TeamType.RED);
		villainRED2 = HeroCreator.createVillain("BadGuyRED2", new HeroStatistics(100, 100, 100), TeamType.RED);
		deadVillainRED1 = HeroCreator.createVillain("BadGuyRED3", new HeroStatistics(100, 100, 100), TeamType.RED);
		deadVillainRED2 = HeroCreator.createVillain("BadGuyRED4", new HeroStatistics(100, 100, 100), TeamType.RED);
	
		deadHeroRED1.isWounded(200);
		deadHeroRED2.isWounded(200);
		deadVillainRED1.isWounded(200);
		deadVillainRED2.isWounded(200);
	}
	
	@BeforeClass
	public static void createTeams() throws InvalidHeroTeamException {
		teamHeroes = new Team(TeamType.RED, TeamControl.CPU);
		teamVillains = new Team(TeamType.RED, TeamControl.CPU);
		teamWithNoHeroes = new Team(TeamType.RED, TeamControl.CPU);
		teamWithDeadHeroes = new Team(TeamType.RED, TeamControl.CPU);
		
		teamHeroes.addHeroToTeam(heroRED1);
		
		teamWithDeadHeroes.addHeroToTeam(deadHeroRED1);
		teamWithDeadHeroes.addHeroToTeam(deadHeroRED2);
		teamWithDeadHeroes.addHeroToTeam(deadVillainRED1);
		teamWithDeadHeroes.addHeroToTeam(deadVillainRED2);
		
	}
	
	@Test
	public void teamWithDeadHeroesShouldReallyHaveDeadHeroes() {
		//given
		//when
		//then
		assertThat(teamWithDeadHeroes.getNumberOfAlive(), is(0));
		assertThat(teamWithDeadHeroes.getNumberOfDead(), is(4));
	}
	
	@Test
	public void warShouldNoBegin() {
		//given
		War war = new War(teamHeroes, teamWithDeadHeroes);
		//when
		war.startWar(scanner);
		//then
	}
	
	@Test
	public void oneTeamShouldBeDefeatedAndHaveNoHeroesAlive() {
		
	}
}
