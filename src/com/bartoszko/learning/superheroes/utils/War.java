package com.bartoszko.learning.superheroes.utils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;
import com.bartoszko.learning.superheroes.teams.Team;

public class War {
	private Team teamA;
	private Team teamB;
	private UI userInterface;
	private Random generator;
	private Comments comments;
	

	public War(Team teamA, Team teamB) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.userInterface = new UI();
		this.generator = new Random();
		this.comments = new Comments();
	}

	public void startWar(Scanner scanner) {
		int clashNumber = 1;

		do {
			if (oneTeamReadyToFight(teamA, teamB)) {
				AbstractHero fighterA = pickFighter(teamA, scanner);
				AbstractHero fighterB = pickFighter(teamB, scanner);
				fight(fighterA, fighterB, clashNumber, scanner);
				clashNumber++;
			} else {
				System.out.println("No teams ready to fight");
			}
		} while (bothTeamsReadyToFight(teamA, teamB));

		checkWarOutput(teamA, teamB);
	}

	private void fight(AbstractHero fighterA, AbstractHero fighterB, int number, Scanner scanner) {
		int healthA;
		int healthB;
		boolean bothHeroesReadyToFigth = true;
		String fightOutput;

		System.out.println();
		System.out.println(">>>>>>>>>> FIGHT!! <<<<<<<<<<");
		System.out.println("clash number " + number + ": " + fighterA + " VS " + fighterB);

		do {
			healthA = fighterA.getStats().getHealth();
			healthB = fighterB.getStats().getHealth();
			if (healthA <= 0 || healthB <= 0) {
				bothHeroesReadyToFigth = false;
			} else {
				String actionA = pickAction(teamA, fighterA, scanner);
				String actionB = pickAction(teamB, fighterB, scanner);
				oneTurnOfFight(fighterA, actionA, fighterB, actionB);
			}
		} while (bothHeroesReadyToFigth);

		if (healthA <= 0 && healthB <= 0) {
			fightOutput = "Both Heroes are dead. Let`s call it a draw";
			fighterA.isKilled();
			fighterB.isKilled();
		} else if (healthA > healthB) {
			fightOutput = fighterA + " is Victorious!";
			fighterB.isKilled();
			System.out.println(fighterB + " is killed");
		} else {
			fightOutput = fighterB + " is victorious!";
			fighterA.isKilled();
			System.out.println(fighterA + " is killed");
		}

		System.out.println();
		System.out.println(fightOutput);
		System.out.println("***************************");
	}

	private void oneTurnOfFight(AbstractHero fighterA, String actionA, AbstractHero fighterB, String actionB) {
		double defenceModifierA = 1;
		double defenceModifierB = 1;
		double initiativeModifierA = 1;
		double initiativeModifierB = 1;

		if (actionA.equals("Defense")) {
			System.out.println(comments.getDefensiveComment(generator, fighterA));
			defenceModifierA=1.5;
			initiativeModifierA = 0.7;
		}
		
		if (actionB.equals("Defense")) {
			System.out.println(comments.getDefensiveComment(generator, fighterB));
			defenceModifierB=1.5;
			initiativeModifierB = 0.7;
		}

		int agilityA = calculateAgility(fighterA, defenceModifierA);
		int agilityB = calculateAgility(fighterB, defenceModifierB);
		System.out.println("agilA" + agilityA);
		System.out.println("agilB" + agilityB);
		
		if (actionA.equals("Bonus") && actionB.equals("Bonus")) {
			if(agilityA*initiativeModifierA > agilityB*initiativeModifierB) {
				fighterA.useBonusPower(teamA, fighterA, fighterB);
				fighterB.useBonusPower(teamB, fighterB, fighterA);
			} else {
				fighterB.useBonusPower(teamB, fighterB, fighterA);
				fighterA.useBonusPower(teamA, fighterA, fighterB);
			}
			return;
		} else if (actionA.equals("Bonus")) {
			fighterA.useBonusPower(teamA, fighterA, fighterB);
			return;
		} else if (actionB.equals("Bonus")) {
			fighterB.useBonusPower(teamB, fighterB, fighterA);
			return;
		} else {
			
		}
		
		if (actionA.equals("Attack") && actionB.equals("Attack")) {
			if(agilityA*initiativeModifierA > agilityB*initiativeModifierB) {
				attack(fighterA, agilityA, fighterB, agilityB);
				if (fighterB.getStats().getHealth()>0) {
					agilityA = calculateAgility(fighterA, defenceModifierA);
					agilityB = calculateAgility(fighterB, defenceModifierB);
					System.out.println("agilA" + agilityA);
					System.out.println("agilB" + agilityB);
					attack(fighterB, agilityB, fighterA, agilityA);
				}
			} else {
				attack(fighterB, agilityB, fighterA, agilityA);
				if (fighterA.getStats().getHealth()>0) {
					agilityA = calculateAgility(fighterA, defenceModifierA);
					agilityB = calculateAgility(fighterB, defenceModifierB);
					System.out.println("agilA" + agilityA);
					System.out.println("agilB" + agilityB);
					attack(fighterA, agilityA, fighterB, agilityB);
				}
			}
		} else if (actionA.equals("Attack")) {
			attack(fighterA, agilityA, fighterB, agilityB);
		} else if (actionB.equals("Attack")) {
			attack(fighterB, agilityB, fighterA, agilityA);
		} else {
			//getBoringComment
			System.out.println("Very Boring round this time");
		}

		if (fighterA.getStats().getHealth() > 0 && fighterB.getStats().getHealth() > 0) {
			System.out.println();
			System.out.println(comments.getEndTurnComment(generator, fighterA, fighterB));
		}
	}

	private void attack (AbstractHero attackingFighter, int attackerAgility, AbstractHero defendingFighter, int defenderAgility) {
		int attackerAttack = attackingFighter.getStats().getAttack();
		int defenderAttack = defendingFighter.getStats().getAttack();
		int attackPower = Math.floorDiv((3*attackerAttack)+(2*attackerAgility), 10);
		int counterattackPower = Math.floorDiv((3*defenderAttack)+(2*defenderAgility), 10);
		
		System.out.println();
		System.out.println(comments.getAttackComment(generator, attackingFighter, defendingFighter));
		
		if(attackerAgility > 8*defenderAgility) {
			System.out.println(comments.getCriticalComment(generator, attackingFighter, defendingFighter));
			defendingFighter.isWounded(5*attackPower);
			System.out.println(defendingFighter + " is critically wounded (-" + 5*attackPower + " HP)");
		} else if (attackerAgility > defenderAgility) {
			System.out.println(comments.getSuccesfullAttackComment(generator, attackingFighter, attackPower, defendingFighter));
			defendingFighter.isWounded(attackPower);
			System.out.println(defendingFighter + " is wounded (-" + attackPower + " HP)");
		} else {
			System.out.println(comments.getFailedAttackComment(generator, attackingFighter, defendingFighter));
			if (2*attackerAgility < defenderAgility) {
				System.out.println(comments.getCounterAttackComment(generator, attackingFighter, defendingFighter, counterattackPower));
				attackingFighter.isWounded(counterattackPower);
				System.out.println(attackingFighter + " is wounded (-" + counterattackPower + " HP)");
			}
		}
	}
	
	private int calculateAgility(AbstractHero fighter, double modifier) {
		int agility;
		int attack = fighter.getStats().getAttack();
		int defence = fighter.getStats().getDefense();
		int health = fighter.getStats().getHealth();
		double power = (attack+(defence*modifier)+health)/3;
		if (power <= 0) {
			agility = 0;
		} else {
			agility = generator.nextInt((int)Math.floor(power));
		}
		return agility;
	}
	
	private boolean bothTeamsReadyToFight(Team teamA, Team teamB) {
		return (teamA.getNumberOfAlive() > 0 && teamB.getNumberOfAlive() > 0);
	}
	
	private boolean oneTeamReadyToFight(Team teamA, Team teamB) {
		return (teamA.getNumberOfAlive() > 0 || teamB.getNumberOfAlive() > 0);
	}
	
	private String pickAction(Team team, AbstractHero hero, Scanner scanner) {
		List<String> listOfActions = hero.getListOfActions();
		int input = userInterface.getInputToPickAction(team, hero, scanner);
		String pickedAction = listOfActions.get(input);
		return pickedAction;
	}

	public AbstractHero pickFighter(Team team, Scanner scanner) {
		List<AbstractHero> listOfFighters = team.getListOfHeroes();
		AbstractHero pickedFighter;
		int input;
		do {
			input = userInterface.getInputToPickFighter(team, scanner);
			pickedFighter = listOfFighters.get(input);
		} while (!pickedFighter.isAlive());

		System.out.println(team.getTypeOfControl().toString() + " picked " + pickedFighter);
		return pickedFighter;
	}

	private void checkWarOutput(Team teamA, Team teamB) {
		String warOutput;
		if (teamA.getNumberOfAlive() > teamB.getNumberOfAlive()) {
			warOutput = teamA + " WON!!\n" + "TeamA: " + teamA.getNumberOfAlive() + " heroes survived. "
					+ teamA.getNumberOfDead() + " heroes died\n" + "TeamB: " + teamB.getNumberOfAlive()
					+ " heroes survived. " + teamB.getNumberOfDead() + " heroes died";
		} else if (teamA.getNumberOfAlive() < teamB.getNumberOfAlive()) {
			warOutput = teamB + " WON!!\n" + "TeamA: " + teamA.getNumberOfAlive() + " heroes survived. "
					+ teamA.getNumberOfDead() + " heroes died\n" + "TeamB: " + teamB.getNumberOfAlive()
					+ " heroes survived. " + teamB.getNumberOfDead() + " heroes died";
		} else {
			warOutput = "There was a draw";
		}

		if (teamA.getListOfHeroes().isEmpty()) {
			warOutput += "\nNo Heroes in " + teamA;
		} else if (teamB.getListOfHeroes().isEmpty()) {
			warOutput += "\nNo Heroes in " + teamB;
		}

		System.out.println(warOutput);
	}
}

