package com.sda.superheroes;

import java.util.List;

import com.sda.teams.Team;
import com.sda.teams.TeamType;

public abstract class AbstractHero {

	private String name;
	private HeroStatistics stats;
	private TeamType team;
	private boolean isAlive;

	public AbstractHero(String name, HeroStatistics stats, TeamType team) {
		this.name = name;
		this.stats = stats;
		this.team = team;
		
		this.isAlive = true;

		switch (team) {

		case RED:
			stats.addToHealth(50);
			break;
		case BLUE:
			stats.addToAttack(50);
			break;
		case GREEN:
			stats.addToDefense(50);
			break;
		}
		
		stats.setInitialHealth(stats.getHealth());
	}

	public abstract List<String> getListOfActions();
 	
	public abstract double getPower();

	public String getName() {
		return name;
	}

	public HeroStatistics getStats() {
		return stats;
	}

	public TeamType getTeam() {
		return team;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void isWounded(int toSubstract) {
		stats.substractFromHealth(toSubstract);
		if (stats.getHealth() <= 0) {  
			isKilled();
		}
	}
	
	public void isKilled() {
		int health = stats.getHealth();
		stats.substractFromHealth(health);
		isAlive = false;
	}
	
	public void isResurrected() {
		isAlive = true;
		if(stats.getHealth() <= 0) {
			stats.resetHealth();
		}
	}
	
	public void setAliveToTrue() {
		isAlive = true;
	}
	
	public String showStats() {
		int attack = getStats().getAttack();
		int defense = getStats().getDefense();
		int health = getStats().getHealth();
		return "( a:" + attack + ", d " + defense + ", h " + health + " )";
	}
	
	public abstract void useBonusPower(Team clericTeam, AbstractHero cleric, AbstractHero opponent); 
	
	public String toString() {
		return name;
	}
	
	
}
