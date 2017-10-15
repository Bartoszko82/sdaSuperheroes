package com.sda.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;


public class HeroCreatorTest {

	@Test
	public void testVillain() {
		Villain villain1 = HeroCreator.createVillainWithDefaultStats("Joker", TeamType.RED);
		Villain villain2 = HeroCreator.createVillainWithDefaultStats("Penguin", TeamType.BLUE);
		Villain villain3 = HeroCreator.createVillainWithDefaultStats("Gargamel", TeamType.GREEN);
		Villain villain4 = HeroCreator.createVillainWithDefaultStats("Vader", TeamType.RED);
	
		assertTrue (villain1.getTeam().equals(TeamType.RED));
		assertTrue (villain1.getStats().getHealth()==150);
		
		
		System.out.println("Dude: " + villain1.getName() + " has beautifull stats like health (" + villain1.getStats().getAttack() + "), attack (" + villain1.getStats().getAttack() + ") and defence (" + villain1.getStats().getDefense() + "), whitch gives pa쿮r: " + villain1.getPower());
		System.out.println("Dude: " + villain2.getName() + " has beautifull stats like health (" + villain2.getStats().getAttack() + "), attack (" + villain2.getStats().getAttack() + ") and defence (" + villain2.getStats().getDefense() + "), whitch gives pa쿮r: " + villain2.getPower());
		System.out.println("Dude: " + villain3.getName() + " has beautifull stats like health (" + villain3.getStats().getAttack() + "), attack (" + villain3.getStats().getAttack() + ") and defence (" + villain3.getStats().getDefense() + "), whitch gives pa쿮r: " + villain3.getPower());
		System.out.println("Dude: " + villain4.getName() + " has beautifull stats like health (" + villain4.getStats().getAttack() + "), attack (" + villain4.getStats().getAttack() + ") and defence (" + villain4.getStats().getDefense() + "), whitch gives pa쿮r: " + villain4.getPower());
		
	
	}
	
}
