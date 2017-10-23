package com.bartoszko.learning.superheroes.tests;

import org.junit.BeforeClass;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;
import com.bartoszko.learning.superheroes.heroes.HeroStatistics;
import com.bartoszko.learning.superheroes.teams.InvalidHeroTeamException;
import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamControl;
import com.bartoszko.learning.superheroes.teams.TeamSide;
import com.bartoszko.learning.superheroes.teams.TeamType;
import com.bartoszko.learning.superheroes.utils.HeroCreator;

public class TeamTest {
	
	private static AbstractHero heroRED1;
	private static AbstractHero heroRED2;
	private static AbstractHero heroRED3;
	private static AbstractHero heroBLUE1;
	private static AbstractHero heroBLUE2;
	private static AbstractHero heroBLUE3;
	private static AbstractHero heroGREEN1;
	private static AbstractHero heroGREEN2;
	private static AbstractHero heroGREEN3;
	private static AbstractHero villainRED1;
	private static AbstractHero villainRED2;
	private static AbstractHero villainRED3;
	private static AbstractHero villainBLUE1;
	private static AbstractHero villainBLUE2;
	private static AbstractHero villainBLUE3;
	private static AbstractHero villainGREEN1;
	private static AbstractHero villainGREEN2;
	private static AbstractHero villainGREEN3;
	private double RED_HERO_POWER = 30000;
	private double BLUE_HERO_POWER = 25000;
	private double GREEN_HERO_POWER = 25000;
	private double RED_VILLAIN_POWER = 25000;
	private double BLUE_VILLAIN_POWER = 25000;
	private double GREEN_VILLAIN_POWER = 30000;
	
	@BeforeClass
	public static void creatingHeroesAndVillains() {
		heroRED1 = HeroCreator.createHero("GoodGuyRED1", new HeroStatistics(100, 100, 100), TeamType.RED);
		heroRED2 = HeroCreator.createHero("GoodGuyRED2", new HeroStatistics(100, 100, 100), TeamType.RED);
		heroRED3 = HeroCreator.createHero("GoodGuyRED3", new HeroStatistics(100, 100, 100), TeamType.RED);
		
		heroBLUE1 = HeroCreator.createHero("GoodGuyBLUE1", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		heroBLUE2 = HeroCreator.createHero("GoodGuyBLUE2", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		heroBLUE3 = HeroCreator.createHero("GoodGuyBLUE3", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		
		heroGREEN1 = HeroCreator.createHero("GoodGuyGREEN1", new HeroStatistics(100, 100, 100), TeamType.GREEN);
		heroGREEN2 = HeroCreator.createHero("GoodGuyGREEN2", new HeroStatistics(100, 100, 100), TeamType.GREEN);
		heroGREEN3 = HeroCreator.createHero("GoodGuyGREEN3", new HeroStatistics(100, 100, 100), TeamType.GREEN);
		
		villainRED1 = HeroCreator.createVillain("BadGuyRED1", new HeroStatistics(100, 100, 100), TeamType.RED);
		villainRED2 = HeroCreator.createVillain("BadGuyRED2", new HeroStatistics(100, 100, 100), TeamType.RED);
		villainRED3 = HeroCreator.createVillain("BadGuyRED3", new HeroStatistics(100, 100, 100), TeamType.RED);
		
		villainBLUE1 = HeroCreator.createVillain("BadGuyBLUE1", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		villainBLUE2 = HeroCreator.createVillain("BadGuyBLUE2", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		villainBLUE3 = HeroCreator.createVillain("BadGuyBLUE3", new HeroStatistics(100, 100, 100), TeamType.BLUE);
		
		villainGREEN1 = HeroCreator.createVillain("BadGuyGREEN1", new HeroStatistics(100, 100, 100), TeamType.GREEN);
		villainGREEN2 = HeroCreator.createVillain("BadGuyGREEN2", new HeroStatistics(100, 100, 100), TeamType.GREEN);
		villainGREEN3 = HeroCreator.createVillain("BadGuyGREEN3", new HeroStatistics(100, 100, 100), TeamType.GREEN);
	}
	
	@Test
	public void RedPlayerControledUnknownEmptyTeamShouldBeCreated() {
		// given
			TeamType teamType = TeamType.RED;
			TeamControl teamControl = TeamControl.PLAYER_1;
		// when
		Team redP1UnknownEmptyTeam = new Team(teamType, teamControl);
		
		// then		
		assertThat(redP1UnknownEmptyTeam.getTeamType(), is(TeamType.RED));
		assertThat(redP1UnknownEmptyTeam.getTypeOfControl(), is(TeamControl.PLAYER_1));
		assertThat(redP1UnknownEmptyTeam.getSide(), is(TeamSide.UNKNOWN));
		assertThat(redP1UnknownEmptyTeam.getListOfHeroes().size(), is(0));
		assertThat(redP1UnknownEmptyTeam.getNumberOfAlive(), is(0));
		assertThat(redP1UnknownEmptyTeam.getNumberOfDead(), is(0));
		assertThat(redP1UnknownEmptyTeam.getTeamPower(), is(0.0));
	}
	
	@Test
	public void BlueCoomputerControledUnknownEmptyTeamShouldBeCreated() {
		// given
		TeamType teamType = TeamType.BLUE;
		TeamControl teamControl = TeamControl.CPU;
		// when
		Team blueCpuUnknownEmptyTeam = new Team(teamType, teamControl);
				
		// then		
		assertThat(blueCpuUnknownEmptyTeam.getTeamType(), is(TeamType.BLUE));
		assertThat(blueCpuUnknownEmptyTeam.getTypeOfControl(), is(TeamControl.CPU));
		assertThat(blueCpuUnknownEmptyTeam.getSide(), is(TeamSide.UNKNOWN));
		assertThat(blueCpuUnknownEmptyTeam.getListOfHeroes().size(), is(0));
		assertThat(blueCpuUnknownEmptyTeam.getNumberOfAlive(), is(0));
		assertThat(blueCpuUnknownEmptyTeam.getNumberOfDead(), is(0));
		assertThat(blueCpuUnknownEmptyTeam.getTeamPower(), is(0.0));
	}
	
	@Test (expected = InvalidHeroTeamException.class)
	public void InvalidHeroTeamExceptionShouldBeThrown() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.RED;
		TeamControl teamControl = TeamControl.PLAYER_1;
		// when
		Team invalidTeam = new Team(teamType, teamControl);
		invalidTeam.addHeroToTeam(heroBLUE1);
		
		// then		
		// exception is thrown
	}
	
	public void InvalidHeroTeamExceptionShouldBeThrownMoreSophisticatedTest() throws InvalidHeroTeamException {
			//TODO
	}
	
	@Test
	public void RedPlayerControledUnknownTeamShouldBeCreated() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.RED;
		TeamControl teamControl = TeamControl.PLAYER_1;
		// when
		Team redP1UnknownTeam = new Team(teamType, teamControl);
		redP1UnknownTeam.addHeroToTeam(heroRED1);
		redP1UnknownTeam.addHeroToTeam(heroRED2);
		redP1UnknownTeam.addHeroToTeam(villainRED1);
		redP1UnknownTeam.addHeroToTeam(villainRED2);
		
		// then		
		assertThat(redP1UnknownTeam.getTeamType(), is(TeamType.RED));
		assertThat(redP1UnknownTeam.getTypeOfControl(), is(TeamControl.PLAYER_1));
		assertThat(redP1UnknownTeam.getSide(), is(TeamSide.UNKNOWN));
		assertThat(redP1UnknownTeam.getListOfHeroes().size(), is(4));
		assertThat(redP1UnknownTeam.getNumberOfAlive(), is(4));
		assertThat(redP1UnknownTeam.getNumberOfDead(), is(0));
		assertThat(redP1UnknownTeam.getTeamPower(), is(2*RED_HERO_POWER+2*RED_VILLAIN_POWER));
	}
	
	@Test
	public void GreenCPUControledGoodTeamShouldBeCreated() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.GREEN;
		TeamControl teamControl = TeamControl.CPU;
		// when
		Team greenCpuGoodTeam = new Team(teamType, teamControl);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN1);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN2);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN3);
		greenCpuGoodTeam.addHeroToTeam(villainGREEN1);
		
		// then		
		assertThat(greenCpuGoodTeam.getTeamType(), is(TeamType.GREEN));
		assertThat(greenCpuGoodTeam.getTypeOfControl(), is(TeamControl.CPU));
		assertThat(greenCpuGoodTeam.getSide(), is(TeamSide.GOOD));
		assertThat(greenCpuGoodTeam.getListOfHeroes().size(), is(4));
		assertThat(greenCpuGoodTeam.getNumberOfAlive(), is(4));
		assertThat(greenCpuGoodTeam.getNumberOfDead(), is(0));
		assertThat(greenCpuGoodTeam.getTeamPower(), is(3*GREEN_HERO_POWER+1*GREEN_VILLAIN_POWER));
	}
	
	@Test
	public void BlueCPUControledEvilTeamShouldBeCreated() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.BLUE;
		TeamControl teamControl = TeamControl.CPU;
		// when
		Team blueCpuEvilTeam = new Team(teamType, teamControl);
		blueCpuEvilTeam.addHeroToTeam(heroBLUE2);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE1);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE2);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE3);
		
		// then		
		assertThat(blueCpuEvilTeam.getTeamType(), is(TeamType.BLUE));
		assertThat(blueCpuEvilTeam.getTypeOfControl(), is(TeamControl.CPU));
		assertThat(blueCpuEvilTeam.getSide(), is(TeamSide.EVIL));
		assertThat(blueCpuEvilTeam.getListOfHeroes().size(), is(4));
		assertThat(blueCpuEvilTeam.getNumberOfAlive(), is(4));
		assertThat(blueCpuEvilTeam.getNumberOfDead(), is(0));
		assertThat(blueCpuEvilTeam.getTeamPower(), is(1*BLUE_HERO_POWER+3*BLUE_VILLAIN_POWER));
	}
	
	@Test
	public void BlueCPUControledEvilTeamShouldBecomeTeamWithDeadHeroes() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.BLUE;
		TeamControl teamControl = TeamControl.CPU;
		// when
		Team blueCpuEvilTeam = new Team(teamType, teamControl);
		blueCpuEvilTeam.addHeroToTeam(heroBLUE2);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE1);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE2);
		blueCpuEvilTeam.addHeroToTeam(villainBLUE3);
		
		villainBLUE3.isKilled();
		
		// then		
		assertThat(blueCpuEvilTeam.getTeamType(), is(TeamType.BLUE));
		assertThat(blueCpuEvilTeam.getTypeOfControl(), is(TeamControl.CPU));
		assertThat(blueCpuEvilTeam.getSide(), is(TeamSide.EVIL));
		assertThat(blueCpuEvilTeam.getListOfHeroes().size(), is(4));
		assertThat(blueCpuEvilTeam.getNumberOfAlive(), is(3));
		assertThat(blueCpuEvilTeam.getNumberOfDead(), is(1));
//		assertThat(blueCpuEvilTeam.getTeamPower(), is(1*BLUE_HERO_POWER+3*BLUE_VILLAIN_POWER));
	}
	
	@Test
	public void GreenCPUControledGoodTeamShouldBecomeTeamWithDeadHeroes() throws InvalidHeroTeamException {
		// given
		TeamType teamType = TeamType.GREEN;
		TeamControl teamControl = TeamControl.CPU;
		// when
		Team greenCpuGoodTeam = new Team(teamType, teamControl);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN1);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN2);
		greenCpuGoodTeam.addHeroToTeam(heroGREEN3);
		greenCpuGoodTeam.addHeroToTeam(villainGREEN1);
			
		heroGREEN2.isWounded(150);
		
		// then		
		assertThat(greenCpuGoodTeam.getTeamType(), is(TeamType.GREEN));
		assertThat(greenCpuGoodTeam.getTypeOfControl(), is(TeamControl.CPU));
		assertThat(greenCpuGoodTeam.getSide(), is(TeamSide.GOOD));
		assertThat(greenCpuGoodTeam.getListOfHeroes().size(), is(4));
		assertThat(greenCpuGoodTeam.getNumberOfAlive(), is(3));
		assertThat(greenCpuGoodTeam.getNumberOfDead(), is(1));
//		assertThat(greenCpuGoodTeam.getTeamPower(), is(3*GREEN_HERO_POWER+1*GREEN_VILLAIN_POWER));
	}
}
