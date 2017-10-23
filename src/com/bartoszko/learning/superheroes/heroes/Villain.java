package com.bartoszko.learning.superheroes.heroes;

import java.util.Arrays;
import java.util.List;

import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamType;

public class Villain extends AbstractHero {

	public Villain(String name, HeroStatistics stats, TeamType team) {
		super(name, stats, team);
	}
	
	@Override
	public List<String> getListOfActions(){
		List<String> result = Arrays.asList("Attack", "Defense");  
		return result;
	}
	
	@Override
	public void useBonusPower(Team heroATeam, AbstractHero heroA, AbstractHero heroB) {

	}
	
	@Override
	public double getPower(){
		int health =  this.getStats().getHealth(); 
		int attack = this.getStats().getAttack();
		int defense = this.getStats().getDefense();
		
		return (health+attack)*defense;
		
	}
}
	
	
