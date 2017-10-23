package com.bartoszko.learning.superheroes.teams;

import java.util.ArrayList;
import java.util.List;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;
import com.bartoszko.learning.superheroes.heroes.SuperHero;
import com.bartoszko.learning.superheroes.heroes.Villain;

public class Team {

	private TeamControl control;
	private TeamType teamType;
	private List<AbstractHero> list;
	private TeamSide side = TeamSide.UNKNOWN;

	public Team(TeamType teamType, TeamControl control) {
		this.control = control;
		this.teamType = teamType;
		list = new ArrayList<AbstractHero>();
	}
	
	public TeamType getTeamType() {
		return teamType;
	}
	
	public TeamControl getTypeOfControl() {
		return control;
	}
	
	public TeamSide getSide() {
		return side;
	}
	
	private void updateTeamSide() {
		List<AbstractHero> heroesInTeam = this.list;
		int numberOfV = 0;
		int numberOfSH = 0;

		for (AbstractHero hero : heroesInTeam) {
			if (hero instanceof Villain) {
				numberOfV++;
			}
			if (hero instanceof SuperHero) {
				numberOfSH++;
			}
		}

		if (numberOfV > numberOfSH) {
			side = TeamSide.EVIL;
		} else if (numberOfV < numberOfSH) {
			side = TeamSide.GOOD;
		} else {
			side = TeamSide.UNKNOWN;
		}

	}
	
	public List<AbstractHero> getListOfHeroes() {
		return list;
	}

	public void addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException {
		if (hero.getTeam().equals(this.teamType)){
			list.add(hero);
			updateTeamSide();
		} else {
			throw new InvalidHeroTeamException(hero.getName() + " doesn`t match team type (RED should go to RED etc.)");
		} 
	}

	public int getNumberOfAlive() {
		int count = 0;
		for (AbstractHero ah : list) {
			if (ah.isAlive()) {
				count += 1;
			}
		}
		return count;
	}

	public int getNumberOfDead() {
		int count = 0;
		for (AbstractHero ah : list) {
			if (!ah.isAlive()) {
				count += 1;
			}
		}
		return count;
	}
	
	public double getTeamPower() {
		List<AbstractHero> heroesInTeam = this.list;
		double TeamPower = 0;
		for (AbstractHero hero : heroesInTeam) {
			TeamPower += hero.getPower();
		}
		return TeamPower;
	}

	@Override
	public String toString() {
		return "team: " + teamType + " (" + control + ")";
	}
	
	
}
