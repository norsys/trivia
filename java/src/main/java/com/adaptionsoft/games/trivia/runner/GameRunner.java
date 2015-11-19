package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

	private static boolean notAWinner;

	private Game game;

	public GameRunner() {
		this.game = new Game();
	}

	public void launchGame(Long seed) {

		game.add("Chet");
		game.add("Pat");
		game.add("Sue");

		Random rand = null;

		if (seed != null) {
			rand = new Random();
		} else {
			rand = new Random(seed);
		}

		do {

			game.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = game.wrongAnswer();
			} else {
				notAWinner = game.wasCorrectlyAnswered();
			}

		} while (notAWinner);
	}

	public static void main(String[] args) {
		GameRunner runner = new GameRunner();

		runner.launchGame(null);

	}
}
