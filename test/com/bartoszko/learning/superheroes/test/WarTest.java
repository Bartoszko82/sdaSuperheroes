package com.bartoszko.learning.superheroes.test;

import org.junit.Test;

import com.bartoszko.learning.superheroes.heroes.HeroStatistics;
import com.bartoszko.learning.superheroes.heroes.SuperHero;
import com.bartoszko.learning.superheroes.heroes.Villain;
import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamControl;
import com.bartoszko.learning.superheroes.teams.TeamType;
import com.bartoszko.learning.superheroes.utils.HeroCreator;

public class WarTest {
	
	
	
	@Test
	public void AddingToTeamTest() {
		
		HeroStatistics stats = new HeroStatistics (100, 100, 100);
		SuperHero hero = HeroCreator.createHero("GoodGuy1", stats, TeamType.RED);
		stats = new HeroStatistics (100, 100, 100);
		hero = HeroCreator.createHero("GoodGuy2", stats, TeamType.RED);
		stats = new HeroStatistics (100, 100, 100);
		hero = HeroCreator.createHero("GoodGuy3", stats, TeamType.RED);
		stats = new HeroStatistics (100, 150, 100);
		hero = HeroCreator.createHero("GoodGuy4", stats, TeamType.RED);
		stats = new HeroStatistics (100, 100, 100);
		hero = HeroCreator.createHero("GoodGuy5", stats, TeamType.RED);
	
		Team teamRed = new Team(TeamType.RED, TeamControl.PLAYER_1);
//		teamRed.addHeroToTeam(hero);
//		teamRed.addHeroToTeam(hero);
		System.out.println("Red team power " + teamRed.getTeamPower());
		
		stats = new HeroStatistics (100, 100, 100);
		Villain villain = HeroCreator.createVillain("Joker", stats, TeamType.BLUE);
		stats = new HeroStatistics (100, 100, 100);
		villain = HeroCreator.createVillain("BadGuy1", stats, TeamType.BLUE);
		stats = new HeroStatistics (100, 100, 100);
		villain = HeroCreator.createVillain("BadGuy3", stats, TeamType.BLUE);
		stats = new HeroStatistics (100, 100, 100);
		villain = HeroCreator.createVillain("BadGuy4", stats, TeamType.BLUE);
		stats = new HeroStatistics (100, 100, 200);
		villain = HeroCreator.createVillain("BadGuy5", stats, TeamType.BLUE);
		

		Team teamBlue = new Team(TeamType.BLUE, TeamControl.CPU);
//		teamBlue.addHeroToTeam(villain);
//		teamBlue.addHeroToTeam(villain);
		System.out.println("Blue team power " + teamBlue.getTeamPower());
	}
}
