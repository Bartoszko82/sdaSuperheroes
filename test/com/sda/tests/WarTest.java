package com.sda.tests;

import org.junit.Test;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.Team;
import com.sda.teams.TeamControl;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;

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
