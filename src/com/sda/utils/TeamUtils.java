package com.sda.utils;

import com.sda.teams.Team;

public class TeamUtils {


	public static boolean isFirstTeamStrongerThanSecond(Team firstTeam, Team secondTeam) {
		if (firstTeam.getTeamPower()>secondTeam.getTeamPower()){
			return true;
		} else {
			return false;
		}
	}
}
