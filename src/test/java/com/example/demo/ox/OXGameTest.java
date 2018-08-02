package com.example.demo.ox;

import static org.junit.Assert.*;

import org.junit.Test;

public class OXGameTest {
	
	@Test
	public void gameStart_emptyTable() {
		String[][] expectedTables = generateEmptyTable();
		OXGame game = new OXGame();
		String[][] tables = game.getTables();
		assertArrayEquals(expectedTables, tables);
	}

	@Test
	public void gameStart_haveTwoPlayersAndZeroScore() {
		OXGame game = new OXGame();
		Player player1 = game.getPlayer1();
		Player player2 = game.getPlayer2();
		assertEquals(0, player1.getScore());
		assertEquals(0, player2.getScore());
	}
	
	@Test
	public void player1StartAt0_0() {
		OXGame game = new OXGame();
		Player player1 = new Player("X");
		game.playWith(player1, 0, 0);
		assertEquals("X", game.valueAt(0, 0));
	}
	
	@Test
	public void player2PlayAt1_0() {
		OXGame game = new OXGame();
		Player player1 = new Player("X");
		Player player2 = new Player("O");
		game.playWith(player1, 0, 0);
		game.playWith(player2, 1, 0);
		assertEquals("X", game.valueAt(0, 0));
		assertEquals("O", game.valueAt(1, 0));
	}
	
	@Test
	public void whenPlayer1Win_horizontal_0() {
		OXGame game = new OXGame();
		Player player1 = new Player("X");
		Player player2 = new Player("O");
		game.playWith(player1, 0, 0);
		game.playWith(player2, 1, 0);
		game.playWith(player1, 0, 1);
		game.playWith(player2, 1, 1);
		game.playWith(player1, 0, 2);
		assertTrue(game.isWinner());
	}
	
	@Test
	public void whenPlayer2Win_horizontal_0() {
		OXGame game = new OXGame();
		Player player1 = new Player("X");
		Player player2 = new Player("O");
		game.playWith(player1, 1, 0);
		game.playWith(player2, 0, 0);
		game.playWith(player1, 1, 1);
		game.playWith(player2, 0, 1);
		game.playWith(player1, 2, 0);
		game.playWith(player2, 0, 2);
		assertTrue(game.isWinner());
	}

	private String[][] generateEmptyTable() {
		String[][] tables = new String[3][3];
		for (int i = 0; i < tables.length; i++) {
			for (int j = 0; j < tables[i].length; j++) {
				tables[i][j] = "";
			}
		}
		return tables;
	}

}
