package com.adaptionsoft.games.trivia;

import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameRunner;

public class GameRunnerTest {

	@Test
	public void shouldLaunch() throws Exception {

		GameRunner runner = new GameRunner();

		runner.launchGame(1L);
	}

	@Test
	public void shouldLaunchMultiple() throws Exception {

		for (long i = 0; i < 100; i++) {

			GameRunner runner = new GameRunner();

			runner.launchGame(i);
		}
	}
}
