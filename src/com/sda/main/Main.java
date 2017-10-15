package com.sda.main;

import java.util.Scanner;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.KamikadzeCleric;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Team;
import com.sda.teams.TeamControl;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import com.sda.utils.War;

public class Main {
	
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		HeroStatistics statsh1 = new HeroStatistics(200, 120, 200);
		SuperHero hero1 = HeroCreator.createHero("Spiderman", statsh1, TeamType.RED);
		HeroStatistics statsh2 = new HeroStatistics(300, 400, 50);
		SuperHero hero2 = HeroCreator.createHero("Superman", statsh2, TeamType.RED);
		HeroStatistics statsh3 = new HeroStatistics(100, 250, 250);
		SuperHero hero3 = HeroCreator.createHero("Batman", statsh3, TeamType.RED);
		HeroStatistics statsh4 = new HeroStatistics(100, 100, 250);
		KamikadzeCleric hero4 = HeroCreator.createCleric("Cleric", statsh4, TeamType.RED);
		
		HeroStatistics statsv1 = new HeroStatistics(100, 400, 200); 
		Villain villain1 = HeroCreator.createVillain("Wilk z Pana Kleksa", statsv1, TeamType.GREEN);
		HeroStatistics statsv2 = new HeroStatistics(300, 100, 100);
		Villain villain2 = HeroCreator.createVillain("Buka", statsv2, TeamType.GREEN);
		HeroStatistics statsv3 = new HeroStatistics(500, 20, 300);
		Villain villain3 = HeroCreator.createVillain("Nadepniety Klocek Lego", statsv3, TeamType.GREEN);

		Team teamSH = new Team(TeamType.RED, TeamControl.PLAYER_1);
		Team teamV = new Team(TeamType.GREEN, TeamControl.CPU);
		Team teamTest = new Team(TeamType.BLUE, TeamControl.PLAYER_2);

		try {
			teamSH.addHeroToTeam(hero1);
			teamSH.addHeroToTeam(hero2);
			teamSH.addHeroToTeam(hero3);
			teamSH.addHeroToTeam(hero4);
			teamV.addHeroToTeam(villain1);
			teamV.addHeroToTeam(villain2);
			teamV.addHeroToTeam(villain3);
		} catch (InvalidHeroTeamException e) {
			e.getMessage();
		}
		
		
		War firstEncounter = new War(teamSH, teamV);
		War secondEncounter = new War(teamSH, teamTest);
		
		firstEncounter.startWar(scanner);
//		secondEncounter.startWar();
		
		
		
		scanner.close();
	}

}
