package com.bartoszko.learning.superheroes.utils;

import com.bartoszko.learning.superheroes.teams.Team;

public class TeamUtils {


	public static boolean isFirstTeamStrongerThanSecond(Team firstTeam, Team secondTeam) {
		if (firstTeam.getTeamPower()>secondTeam.getTeamPower()){
			return true;
		} else {
			return false;
		}
	}
}
