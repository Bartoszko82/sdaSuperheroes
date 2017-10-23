package com.bartoszko.learning.superheroes.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;

public class Comments {
	
	public Comments () {
		
	}
	
	public String getAttackComment(Random random, AbstractHero attackingFighter, AbstractHero dodgeFighter) {
		List<String> attackComments = Arrays.asList(
				attackingFighter + " is attackig " + dodgeFighter,
				"Powerfull kick by " + attackingFighter, 
				attackingFighter + " punched " + dodgeFighter,
				"Quick charge by " + attackingFighter + " finished with nice stroke" 
				);
		int randomNumber = random.nextInt(attackComments.size());
		String chosenAttackComment = attackComments.get(randomNumber);
		return chosenAttackComment;
	}
	
	public String getCriticalComment(Random random, AbstractHero attackingFighter, AbstractHero dodgeFighter) {
		List<String> attackComments = Arrays.asList(
				"Critical Hit!!!!!" 
				);
		int randomNumber = random.nextInt(attackComments.size());
		String chosenAttackComment = attackComments.get(randomNumber);
		return chosenAttackComment;
	}

	public String getSuccesfullAttackComment(Random random, AbstractHero attackingFighter, int attackPower, AbstractHero defendingFighter) {
		List<String> attackComments = Arrays.asList(
				"now " + defendingFighter + " has to find his limbs flying around",
				"right in the face, with strenght of " + attackPower,
				"it doesn`t looks like its just bout a scratch"
				);
		int randomNumber = random.nextInt(attackComments.size());
		String chosenAttackComment = attackComments.get(randomNumber);
		return chosenAttackComment;
	}

	public String getFailedAttackComment(Random random, AbstractHero attackingFighter, AbstractHero defendingFighter) {
		List<String> dodgeComments = Arrays.asList(
				"but... What a beautifull dodge by " + defendingFighter,
				"but missed by milimeters", 
				defendingFighter + " avoided certain death, when moved out of the way of that magnificent " + attackingFighter + " attack",
				"but " + defendingFighter + " just did some \"Neo from Matrix\" moves, and avoided being hit"
				);
		int randomNumber = random.nextInt(dodgeComments.size());
		String chosenDodgeComment = dodgeComments.get(randomNumber);
		return chosenDodgeComment;
	}
	
	public String getDefensiveComment(Random random, AbstractHero defensiveFighter) {
		List<String> defensiveComments = Arrays.asList(
				defensiveFighter + " believes in his defense powers and shouts: You shall not pass",
				defensiveFighter + " will try to avoid attacks rather than charging with fury", 
				defensiveFighter + " is prepearing himself for an attack",
				defensiveFighter + " waits, focused in \"Crouching Tigermoth \" position"
				);
		int randomNumber = random.nextInt(defensiveComments.size());
		String chosenDefensiveComment = defensiveComments.get(randomNumber);
		return chosenDefensiveComment;
	}
	
	public String getCounterAttackComment(Random random, AbstractHero attackingHero, AbstractHero defendingFighter, int counterattackPower) {
		List<String> counterAttackComments = Arrays.asList(
				"Now " + defendingFighter + " is counterattacking",
				"What a counterattack by " + defendingFighter, 
				"What a counterattack!!, " + attackingHero + " is hit",
				"What a counterattack!!#4");
		int randomNumber = random.nextInt(counterAttackComments.size());
		String chosenCounterAttackComment = counterAttackComments.get(randomNumber);
		return chosenCounterAttackComment;
	}

	public String getEndTurnComment(Random random, AbstractHero fighterA, AbstractHero fighterB) {
		List<String> endTurnComments = Arrays.asList(
		"After this round of lowkicks, punches, poking and pinching, heroes are left witch "
				+ fighterA.getStats().getHealth() + " (" + fighterA + ") and " + fighterB.getStats().getHealth()
				+ " points of health (" + fighterB + ")"
		);
		int randomNumber = random.nextInt(endTurnComments.size());
		String chosenEndTurnComment = endTurnComments.get(randomNumber);
		return chosenEndTurnComment;
	}

}
