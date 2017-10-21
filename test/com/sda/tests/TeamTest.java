package com.sda.tests;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.Team;
import com.sda.teams.TeamControl;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;

public class TeamTest {
	
	private AbstractHero heroRED1;
	private AbstractHero heroRED2;
	private AbstractHero heroRED3;
	private AbstractHero heroBLUE1;
	private AbstractHero heroBLUE2;
	private AbstractHero heroBLUE3;
	private AbstractHero heroGREEN1;
	private AbstractHero heroGREEN2;
	private AbstractHero heroGREEN3;
	private AbstractHero villainRED1;
	private AbstractHero villainRED2;
	private AbstractHero villainRED3;
	private AbstractHero villainBLUE1;
	private AbstractHero villainGREEN1;
	
	
	@BeforeClass
	public void creatingHeroesAndVillains() {
		HeroStatistics stats = new HeroStatistics (100, 100, 100);
		heroRED1 = HeroCreator.createHero("GoodGuyRED1", stats, TeamType.RED);
		heroRED2 = HeroCreator.createHero("GoodGuyRED2", stats, TeamType.RED);
		heroRED3 = HeroCreator.createHero("GoodGuyRED3", stats, TeamType.RED);
		
		heroBLUE1 = HeroCreator.createHero("GoodGuyBLUE1", stats, TeamType.BLUE);
		heroBLUE2 = HeroCreator.createHero("GoodGuyBLUE2", stats, TeamType.BLUE);
		heroBLUE3 = HeroCreator.createHero("GoodGuyBLUE3", stats, TeamType.BLUE);
		
		heroGREEN1 = HeroCreator.createHero("GoodGuyGREEN1", stats, TeamType.GREEN);
		heroGREEN2 = HeroCreator.createHero("GoodGuyGREEN2", stats, TeamType.GREEN);
		heroGREEN3 = HeroCreator.createHero("GoodGuyGREEN3", stats, TeamType.GREEN);
		
		villain = HeroCreator.createVillain("Joker", stats, TeamType.BLUE);
		villain = HeroCreator.createVillain("BadGuy1", stats, TeamType.BLUE);
		villain = HeroCreator.createVillain("BadGuy3", stats, TeamType.BLUE);
		
		villain = HeroCreator.createVillain("BadGuy4", stats, TeamType.BLUE);
		villain = HeroCreator.createVillain("BadGuy5", stats, TeamType.BLUE);
		

		Team teamBlue = new Team(TeamType.BLUE, TeamControl.CPU);
//		teamBlue.addHeroToTeam(villain);
//		teamBlue.addHeroToTeam(villain);
		System.out.println("Blue team power " + teamBlue.getTeamPower());
	}
	
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
