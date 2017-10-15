package com.sda.utils;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.KamikadzeCleric;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;

public class HeroCreator {

	public static SuperHero createHero (String name, HeroStatistics stats, TeamType team) {
		return new SuperHero (name, stats, team);
	}
	
	public static Villain createVillain (String name, HeroStatistics stats, TeamType team) {
		return new Villain (name, stats, team);
	}
	
	public static KamikadzeCleric createCleric (String name, HeroStatistics stats, TeamType team) {
		return new KamikadzeCleric(name, stats, team);
	}
	
	public static SuperHero createHeroWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		String healthStr = System.getProperty("config.superHeroBaseHealth");
		int health = Integer.parseInt(healthStr);
		String attackStr = System.getProperty("config.superHeroBaseAttack");
		int attack = Integer.parseInt(attackStr);
		String defenseStr = System.getProperty("config.superHeroBaseDefence");
		int defense = Integer.parseInt(defenseStr);
		
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
			
		return createHero (name, stats, team);
	}
	
	public static Villain createVillainWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		String healthStr = System.getProperty("config.superHeroBaseHealth");
		int health = Integer.parseInt(healthStr);
		String attackStr = System.getProperty("config.superHeroBaseAttack");
		int attack = Integer.parseInt(attackStr);
		String defenseStr = System.getProperty("config.superHeroBaseDefence");
		int defense = Integer.parseInt(defenseStr);
		
		HeroStatistics stats = new HeroStatistics(health, attack, defense);
			
		return createVillain (name, stats, team);
		
	}
	
}
