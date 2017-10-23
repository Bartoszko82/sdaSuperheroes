package com.bartoszko.learning.superheroes.heroes;

public class HeroStatistics {
	private int initialHealth;
	private int health;
	private int attack;
	private int defense;
	
	public HeroStatistics (int health, int attack, int defense) {
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}	
	
	public int getHealth() {
		return health;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void addToHealth (int toAdd) {
		health+= toAdd;		
	}
	
	public void addToAttack (int toAdd) {
		attack+= toAdd;		
	}
	
	public void addToDefense (int toAdd) {
		defense+= toAdd;		
	}
		
	public void substractFromHealth (int toSubstract) {
		health-= toSubstract;		
	}
	
	public void setInitialHealth (int health) {
		initialHealth = health;
	}
	
	public void resetHealth () {
		health = initialHealth;
	}
}
