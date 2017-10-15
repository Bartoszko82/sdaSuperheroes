package com.sda.superheroes;

import java.util.Arrays;
import java.util.List;

import com.sda.teams.Team;
import com.sda.teams.TeamType;

public class KamikadzeCleric extends AbstractHero {
	
	public KamikadzeCleric(String name, HeroStatistics stats, TeamType team) {
		super(name, stats, team);
	}
	
	@Override
	public List<String> getListOfActions(){
		List<String> result = Arrays.asList("Attack", "Defense", "Bonus");  
		return result;
	}
	
	@Override
	public void useBonusPower(Team clericTeam, AbstractHero cleric, AbstractHero opponent) {
		List<AbstractHero> listOfHeroes = clericTeam.getListOfHeroes();
		for (AbstractHero hero : listOfHeroes) {
			hero.isResurrected();
		}
		
		cleric.isKilled();
		opponent.isKilled();
		System.out.println("Cleric commited suicide, taking his opponent with him");
		
	}
	
	@Override
	public double getPower(){
		int health =  this.getStats().getHealth(); 
		int attack = this.getStats().getAttack();
		int defense = this.getStats().getDefense();
		
		return (defense+health)*attack;
	}
	

}
