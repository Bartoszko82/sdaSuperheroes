package com.bartoszko.learning.superheroes.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bartoszko.learning.superheroes.teams.Team;
import com.bartoszko.learning.superheroes.utils.TeamUtils;

@RunWith(MockitoJUnitRunner.class)
public class TeamUtilTest {
	
	@Mock
	private Team firstTeam;
	
	@Mock
	private Team secondTeam;
	
	@Test
	public void FirstTeamShouldBeStronger() {	
		//given
		double higherValue = 1500.0;
		double lowerValue = 1000.0;		
				
		// when
		when(firstTeam.getTeamPower()).thenReturn(higherValue);
		when(secondTeam.getTeamPower()).thenReturn(lowerValue);
				
		//then
		assertThat(TeamUtils.isFirstTeamStrongerThanSecond(firstTeam, secondTeam), is(true));
	}
	
	@Test
	public void FirstTeamShouldBeWeaker() {	
		//given
		double higherValue = 1500.0;
		double lowerValue = 1000.0;		
				
		// when
		when(firstTeam.getTeamPower()).thenReturn(lowerValue);
		when(secondTeam.getTeamPower()).thenReturn(higherValue);
				
		//then
		assertThat(TeamUtils.isFirstTeamStrongerThanSecond(firstTeam, secondTeam), is(false));
	}
	
	@Test
	public void FirstTeamShouldBeWeakerWhenPowerIsEqual() {	
		//given
		double equalValue = 1500.0;
				
		// when
		when(firstTeam.getTeamPower()).thenReturn(equalValue);
		when(secondTeam.getTeamPower()).thenReturn(equalValue);
				
		//then
		assertThat(TeamUtils.isFirstTeamStrongerThanSecond(firstTeam, secondTeam), is(false));
	}
}
