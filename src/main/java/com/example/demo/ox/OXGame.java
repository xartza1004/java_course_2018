package com.example.demo.ox;

public class OXGame {

	private final int ROW = 3;
	private final int COL = 3;

	private String[][] tables;
	private Player player1;
	private Player player2;

	public OXGame() {
		tables = new String[ROW][COL];
		initialTables();
		player1 = new Player("X");
		player2 = new Player("O");
	}

	public String[][] getTables() {
		return tables;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public String valueAt(int i, int j) {
		return tables[i][j];
	}

	public void playWith(Player player, int i, int j) {
		tables[i][j] = player.getSymbol();
	}

	public boolean isWinner() {
		return checkHorizontal();
	}

	public boolean isEnd() {
		return false;
	}

	private void initialTables() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				tables[i][j] = "";
			}
		}
	}

	private boolean checkHorizontal() {
		String symbol;

		for (int i = 0; i < ROW; i++) {
			symbol = valueAt(i, 0);

			if (symbol.equals("")) {
				continue;
			}

			for (int j = 1; j < COL; j++) {
				if (!symbol.equals(valueAt(i, j))) {
					break;
				} else if (j == COL - 1) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean justTest() {
		for (int i = 0; i < ROW; i++) {
			if (checkH(i) || checkV(i)) {
				return true;
			}
		}

		return false; //checkD();
	}

	private boolean checkH(int i) {
		String symbol = valueAt(i, 0);
		if (symbol.equals("")) {
			return false;
		}

		for (int j = 1; j < COL; j++) {
			if (!symbol.equals(valueAt(i, j))) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkV(int i) {
		String symbol = valueAt(0, i);
		if (symbol.equals("")) {
			return false;
		}

		for (int j = 1; j < COL; j++) {
			if (!symbol.equals(valueAt(j, i))) {
				return false;
			}
		}
		
		return true;
	}

}
