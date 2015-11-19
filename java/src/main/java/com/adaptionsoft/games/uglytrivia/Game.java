package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
	protected List<String> players = new ArrayList<String>();
	protected int[] places = new int[6];
	protected int[] purses = new int[6];
	protected boolean[] inPenaltyBox = new boolean[6];

	protected List<String> popQuestions = new ArrayList<String>();
	protected List<String> scienceQuestions = new ArrayList<String>();
	protected List<String> sportsQuestions = new ArrayList<String>();
	protected List<String> rockQuestions = new ArrayList<String>();

	protected int currentPlayer = 0;

	public Game() {
		for (int i = 0; i < 50; i++) {
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
		return players.size() >= 2;
	}

	public void add(String playerName) {

		if (players.size() < 6) {
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
		places[currentPlayer] = (places[currentPlayer] + roll) % 12;

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
		return Category.values()[places[currentPlayer] % 4];
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
		return purses[currentPlayer] == 6;
	}
}
