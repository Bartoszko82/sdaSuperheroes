package com.bartoszko.learning.superheroes.tests;

import org.junit.Test;

import com.bartoszko.learning.superheroes.heroes.HeroStatistics;
import com.bartoszko.learning.superheroes.heroes.SuperHero;
import com.bartoszko.learning.superheroes.heroes.Villain;
import com.bartoszko.learning.superheroes.teams.InvalidHeroTeamException;
import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamControl;
import com.bartoszko.learning.superheroes.teams.TeamType;
import com.bartoszko.learning.superheroes.utils.HeroCreator;
import com.bartoszko.learning.superheroes.utils.TeamUtils;

public class TeamUtilTest {
	
	@Test
	public void TeamUtilTest() {
		
		HeroStatistics stats1 = new HeroStatistics (100, 100, 100);
		SuperHero hero1 = HeroCreator.createHero("GoodGuy1", stats1, TeamType.RED);
		HeroStatistics stats2 = new HeroStatistics (100, 100, 100);
		SuperHero hero2 = HeroCreator.createHero("GoodGuy2", stats2, TeamType.RED);
		HeroStatistics stats3 = new HeroStatistics (100, 100, 100);
		SuperHero hero3 = HeroCreator.createHero("GoodGuy3", stats3, TeamType.RED);
		HeroStatistics stats4 = new HeroStatistics (100, 150, 100);
		SuperHero hero4 = HeroCreator.createHero("GoodGuy4", stats4, TeamType.RED);
		HeroStatistics stats5 = new HeroStatistics (100, 100, 400);
		SuperHero hero5 = HeroCreator.createHero("GoodGuy5", stats5, TeamType.RED);
	
		Team teamRed = new Team(TeamType.RED, TeamControl.PLAYER_1);
		
		try {
			teamRed.addHeroToTeam(hero1);
			teamRed.addHeroToTeam(hero2);
			teamRed.addHeroToTeam(hero3);
			teamRed.addHeroToTeam(hero4);
			teamRed.addHeroToTeam(hero5);
		} catch (InvalidHeroTeamException e) {
			System.out.println(e.getMessage());
			System.out.println("Hero doesn`t match team type (RED should go to RED etc.)");
		}
		
		
//		assertTrue(teamRed.addHeroToTeam(hero));
		
		
		HeroStatistics statsv1 = new HeroStatistics (100, 100, 100);
		Villain villain1 = HeroCreator.createVillain("Joker", statsv1, TeamType.BLUE);
		HeroStatistics statsv2 = new HeroStatistics (100, 100, 100);
		Villain villain2 = HeroCreator.createVillain("BadGuy1", statsv2, TeamType.RED);
		HeroStatistics statsv3 = new HeroStatistics (100, 100, 100);
		Villain villain3 = HeroCreator.createVillain("BadGuy3", statsv3, TeamType.BLUE);
		HeroStatistics statsv4 = new HeroStatistics (100, 100, 100);
		SuperHero heroBlue1 = HeroCreator.createHero("BadGuy4", statsv4, TeamType.BLUE);
		HeroStatistics statsv5 = new HeroStatistics (100, 100, 200);
		SuperHero heroBlue2 = HeroCreator.createHero("BadGuy5", statsv5, TeamType.BLUE);
		HeroStatistics statsv6 = new HeroStatistics (100, 100, 200);
		SuperHero heroBlue3 = HeroCreator.createHero("BadGuy5", statsv6, TeamType.BLUE);
		

		Team teamBlue = new Team(TeamType.BLUE, TeamControl.CPU);

		try {
			teamBlue.addHeroToTeam(villain1);
			teamBlue.addHeroToTeam(villain2);
			teamBlue.addHeroToTeam(villain3);
			teamBlue.addHeroToTeam(heroBlue1);
			teamBlue.addHeroToTeam(heroBlue2);
			teamBlue.addHeroToTeam(heroBlue3);
		} catch (InvalidHeroTeamException ex) {
			System.out.println(ex.getMessage());
		}
			
		System.out.println("Red team power " + teamRed.getTeamPower());
		System.out.println("Blue team power " + teamBlue.getTeamPower());
		System.out.println(teamRed.getSide());
		System.out.println(teamBlue.getSide());
		
		TeamUtils fight = new TeamUtils();
		System.out.println("First team is stronger?: " + fight.isFirstTeamStrongerThanSecond(teamRed, teamBlue));

		
		
	}
}
