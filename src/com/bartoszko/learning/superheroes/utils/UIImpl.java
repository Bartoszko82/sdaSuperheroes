package com.bartoszko.learning.superheroes.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import com.bartoszko.learning.superheroes.heroes.AbstractHero;
import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.teams.TeamControl;

public class UIImpl {
//	private static Scanner scanner;
//	
//	public static void openScanner(Scanner scanner) {
//		this.scanner = scanner;
//		scanner = new Scanner(System.in);
//	}
//	
//	public static void closeScanner(Scanner scanner) {
//		scanner.close();
//	}
	private Random generator;
	
	public UIImpl () {
		this.generator = new Random();
	}
	
	public int getInputToPickFighter (Team team, Scanner scanner) {
		int result;
		if (team.getTypeOfControl().equals(TeamControl.CPU)) {
			result = randomInputFighter(team);
		} else {
			result = manualInputFighter(team, scanner);
		}
		return result;
	}
	
	public int getInputToPickAction (Team team, AbstractHero hero, Scanner scanner) {
		int result;
		if (team.getTypeOfControl().equals(TeamControl.CPU)) {
			result = randomInputAction(hero);
		} else {
			result = manualInputAction(hero, scanner);
		}
		return result;
	}
	
	private int randomInputFighter(Team team) {
		int randomInput = 0;
		if(team.getNumberOfSuperheroes() > 0) {
			int inputRange = team.getNumberOfSuperheroes();
			randomInput = generator.nextInt(inputRange);
		}	
		return randomInput;
	}
	
	private int manualInputFighter(Team team, Scanner scanner) {
		List<AbstractHero> listOfHeroes = team.getListOfHeroes();
		int manualInput;
		System.out.println("\nLIST OF HEROES IN " + team);
		for (AbstractHero ah : listOfHeroes) {
			if (ah.isAlive()) {
				System.out.println((listOfHeroes.indexOf(ah)+1) + ". " + "In your team: " + ah + " is Alive " + ah.showStats());
			} else {
				System.out.println((listOfHeroes.indexOf(ah)+1) + ". " + "In your team: " + ah + " is Dead");
			}
		}

		do {
			System.out.println("Chose your Hero! (number 1 to " + listOfHeroes.size() + ")");
			manualInput = keyboardInput(scanner); 
		} while (manualInput < 0 || manualInput > listOfHeroes.size());
		return manualInput;
	}
	
	private int randomInputAction(AbstractHero hero) {
		List<String> listOfActions = hero.getListOfActions();
		int inputRange = listOfActions.size();
		int randomInput = generator.nextInt(inputRange);
		return randomInput;
	}
	
	private int manualInputAction(AbstractHero hero, Scanner scanner) {
		List<String> listOfActions = hero.getListOfActions();
		int manualInput;
		do {
			System.out.println("\nChoose Action to be performed: ");
			for (String s : listOfActions) {
				System.out.println("[" + (listOfActions.indexOf(s)+1) + "] " + s);
			}
			manualInput = keyboardInput(scanner); 
		} while (manualInput > hero.getListOfActions().size());
		System.out.println("you Chose to " + listOfActions.get(manualInput));
		return (manualInput);
	}
	
	private int keyboardInput (Scanner scanner) {
		int keyboardInput = 0;
		try {
			keyboardInput = scanner.nextInt();
		} catch (NoSuchElementException nsee) {
			nsee.getMessage();
			System.out.println("Something went wrong with keyboard input. Press any button to continue");
		}
		return (keyboardInput-1);
	}
}

