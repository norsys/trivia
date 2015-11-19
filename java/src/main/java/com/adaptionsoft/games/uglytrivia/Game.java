package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int PURSE_NUMBER_TO_WIN = 6;
	private static final int BOARD_GAME_SIZE = 12;
	private static final int MAXIMUM_PLAYER_NUMBER = 6;
	private static final int MINIMUM_PLAYER_NUMBER = 2;
	private static final int QUESTION_POOL_SIZE = 50;

	protected List<String> players = new ArrayList<String>();
	protected int[] places = new int[MAXIMUM_PLAYER_NUMBER];
	protected int[] purses = new int[MAXIMUM_PLAYER_NUMBER];
	protected boolean[] inPenaltyBox = new boolean[MAXIMUM_PLAYER_NUMBER];

	protected List<String> popQuestions = new ArrayList<String>();
	protected List<String> scienceQuestions = new ArrayList<String>();
	protected List<String> sportsQuestions = new ArrayList<String>();
	protected List<String> rockQuestions = new ArrayList<String>();

	protected int currentPlayer = 0;

	public Game() {
		for (int i = 0; i < QUESTION_POOL_SIZE; i++) {
			popQuestions.add("Pop Question " + i);
			scienceQuestions.add(("Science Question " + i));
			sportsQuestions.add(("Sports Question " + i));
			rockQuestions.add("Rock Question " + i);
		}
	}

	private enum Category {
		POP, SCIENCE, SPORT, ROCK;
	}

	public boolean isPlayable() {
		return players.size() >= MINIMUM_PLAYER_NUMBER;
	}

	public void add(String playerName) {

		if (players.size() < MAXIMUM_PLAYER_NUMBER) {
			players.add(playerName);

			System.out.println(playerName + " was added");
			System.out.println("They are player number " + players.size());
		}
	}

	public void roll(int roll) {
		if (isPlayable()) {
			System.out.println(players.get(currentPlayer)
					+ " is the current player");
			System.out.println("They have rolled a " + roll);

			this.managePenaltyBox(roll);

			if (!inPenaltyBox[currentPlayer]) {
				movePlayer(roll);
				askQuestion();
			}
		} else {
			System.out.println("The game requires 2 to 6 players!!!!");
		}

	}

	private void managePenaltyBox(int roll) {
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				inPenaltyBox[currentPlayer] = false;

				System.out.println(players.get(currentPlayer)
						+ " is getting out of the penalty box");
			} else {
				System.out.println(players.get(currentPlayer)
						+ " is not getting out of the penalty box");
			}

		}
	}

	private void movePlayer(int roll) {
		places[currentPlayer] = (places[currentPlayer] + roll)
				% BOARD_GAME_SIZE;

		System.out.println(players.get(currentPlayer) + "'s new location is "
				+ places[currentPlayer]);
	}

	private void askQuestion() {
		Category currentCategory = currentCategory();

		System.out.println("The category is " + currentCategory);

		switch (currentCategory) {
		case POP:
			System.out.println(popQuestions.remove(0));
			break;
		case SCIENCE:
			System.out.println(scienceQuestions.remove(0));
			break;
		case SPORT:
			System.out.println(sportsQuestions.remove(0));
			break;
		default:
			System.out.println(rockQuestions.remove(0));
			break;
		}
	}

	private Category currentCategory() {
		return Category.values()[places[currentPlayer]
				% Category.values().length];
	}

	public void wasCorrectlyAnswered() {
		if (!inPenaltyBox[currentPlayer]) {
			System.out.println("Answer was correct!!!!");

			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) + " now has "
					+ purses[currentPlayer] + " Gold Coins.");
		}
	}

	public void goToNextPlayer() {
		currentPlayer = (currentPlayer + 1) % players.size();
	}

	public void wrongAnswer() {
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)
				+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
	}

	public boolean isWinner() {
		return purses[currentPlayer] == PURSE_NUMBER_TO_WIN;
	}
}
