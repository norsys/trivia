package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {

	@Test
	public void shouldInstantiateGame() throws Exception {

		Game game = new Game();

		assertNotNull(game);

		assertNotNull(game.places);
		assertEquals(6, game.places.length);

		assertNotNull(game.purses);
		assertEquals(6, game.purses.length);

		assertNotNull(game.inPenaltyBox);
		assertEquals(6, game.inPenaltyBox.length);

		assertNotNull(game.popQuestions);
		assertEquals(50, game.popQuestions.size());

		assertNotNull(game.rockQuestions);
		assertEquals(50, game.rockQuestions.size());

		assertNotNull(game.scienceQuestions);
		assertEquals(50, game.scienceQuestions.size());

		assertNotNull(game.sportsQuestions);
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldBePlayable() throws Exception {
		Game game = new Game();

		game.players.add("Player 1");
		game.players.add("Player 2");

		assertTrue(game.isPlayable());
	}

	@Test
	public void shouldNotBePlayable() throws Exception {
		Game game = new Game();

		game.players.add("Player 1");

		assertFalse(game.isPlayable());
	}

	@Test
	public void shouldAddPlayer() throws Exception {

		Game game = new Game();

		game.add("Player 1");

		assertEquals(1, game.players.size());

		assertEquals(0, game.places[1]);
		assertEquals(0, game.purses[1]);
		assertFalse(game.inPenaltyBox[1]);
	}

	@Test
	public void shouldAdd6Players() throws Exception {
		Game game = new Game();

		game.add("Player 1");
		game.add("Player 2");
		game.add("Player 3");
		game.add("Player 4");
		game.add("Player 5");
		game.add("Player 6");

		assertEquals(6, game.players.size());
	}

	@Test
	public void shouldNotAdd7Players() throws Exception {
		Game game = new Game();

		game.add("Player 1");
		game.add("Player 2");
		game.add("Player 3");
		game.add("Player 4");
		game.add("Player 5");
		game.add("Player 6");
		game.add("Player 7");

		assertEquals(6, game.players.size());
	}

	@Test
	public void shouldNotRollWithLessThan2Players() throws Exception {

		Game game = new Game();
		game.add("Player 1");

		game.roll(1);

		assertEquals(0, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());

	}

	@Test
	public void shouldRoll1Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(1);

		assertEquals(1, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(49, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll2Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(2);

		assertEquals(2, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll3Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(3);

		assertEquals(3, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(49, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll4Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(4);

		assertEquals(4, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll5Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(5);

		assertEquals(5, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(49, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll6Position0PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.roll(6);

		assertEquals(6, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll1Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(1);

		assertEquals(7, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(49, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll2Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(2);

		assertEquals(8, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll3Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(3);

		assertEquals(9, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(49, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll4Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(4);

		assertEquals(10, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll5Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(5);

		assertEquals(11, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(49, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll6Position6PlayerNotInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 6;

		game.roll(6);

		assertEquals(0, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll1Position1PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(1);

		assertEquals(2, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll2Position1PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(2);

		assertEquals(1, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll3Position1PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(3);

		assertEquals(4, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll4Position0PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(4);

		assertEquals(1, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll5Position1PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(5);

		assertEquals(6, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll6Position1PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 1;
		game.inPenaltyBox[0] = true;

		game.roll(6);

		assertEquals(1, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll1Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(1);

		assertEquals(8, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll2Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(2);

		assertEquals(7, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll3Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(3);

		assertEquals(10, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(49, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll4Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(4);

		assertEquals(7, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll5Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(5);

		assertEquals(0, game.places[0]);
		assertEquals(49, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldRoll6Position7PlayerInPenaltyBox() throws Exception {

		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.places[0] = 7;
		game.inPenaltyBox[0] = true;

		game.roll(6);

		assertEquals(7, game.places[0]);
		assertEquals(50, game.popQuestions.size());
		assertEquals(50, game.rockQuestions.size());
		assertEquals(50, game.scienceQuestions.size());
		assertEquals(50, game.sportsQuestions.size());
	}

	@Test
	public void shouldGoToNextPlayer() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.currentPlayer = 0;

		game.goToNextPlayer();

		assertEquals(1, game.currentPlayer);
	}

	@Test
	public void shouldLoopToFirstPlayer() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.currentPlayer = 1;

		game.goToNextPlayer();

		assertEquals(0, game.currentPlayer);
	}

	@Test
	public void shouldFirstPlayerAnswerCorrectlyNotInPenaltyBox()
			throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.wasCorrectlyAnswered();

		assertEquals(1, game.purses[0]);
	}

	@Test
	public void shouldLastPlayerAnswerCorrectlyNotInPenaltyBox()
			throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.currentPlayer = 1;

		game.wasCorrectlyAnswered();

		assertEquals(1, game.purses[1]);
	}

	@Test
	public void shouldFirstPlayerAnswerCorrectlyNotGettingOutPenaltyBox()
			throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.inPenaltyBox[0] = true;

		game.wasCorrectlyAnswered();

		assertEquals(0, game.purses[0]);
	}

	@Test
	public void shouldLastPlayerAnswerCorrectlyNotGettingOutPenaltyBox()
			throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.currentPlayer = 1;
		game.inPenaltyBox[1] = true;

		game.wasCorrectlyAnswered();

		assertEquals(0, game.purses[1]);
	}

	@Test
	public void shouldFirstPlayerAnswerWrongly() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");

		game.wrongAnswer();

		assertEquals(0, game.purses[0]);
		assertTrue(game.inPenaltyBox[0]);
	}

	@Test
	public void shouldLastPlayerAnswerWrongly() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.currentPlayer = 1;

		game.wrongAnswer();

		assertEquals(0, game.purses[1]);
		assertTrue(game.inPenaltyBox[1]);
	}

	@Test
	public void shouldNotWin() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.purses[0] = 4;

		boolean winner = game.isWinner();

		assertFalse(winner);

	}

	@Test
	public void shouldWin() throws Exception {
		Game game = new Game();
		game.add("Player 1");
		game.add("Player 2");
		game.purses[0] = 6;

		boolean winner = game.isWinner();

		assertTrue(winner);

	}
}
