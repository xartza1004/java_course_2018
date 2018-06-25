package com.example.demo;

public class TennisGame2 {

	private int player1Point = 0;
	private int player2Point = 0;

	private String player1Result = "";
	private String player2Result = "";

	public TennisGame2(String player1Name, String player2Name) {

	}

	private String sayScore(int point) {
		String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
		
		if (point < 0)
			throw new IllegalArgumentException();
		else if (point < scores.length)
			return scores[point];
		else
			return "Advantage";
		
		/*if (point < 0)
			throw new IllegalArgumentException();
		else if (point == 0)
			return "Love";
		else if (point == 1)
			return "Fifteen";
		else if (point == 2)
			return "Thirty";
		else if (point == 3)
			return "Forty";
		else
			return "Advantage";*/
	}
	
	public String getScoreNew() {
		String score = "";
		
		return score;
	}
	
	private boolean isAll() {
		return player1Point == player2Point && player1Point < 3;
	}

	public String getScore() {
		String score = "";
		
		// Winner
		if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
			return "Win for player1";
		}
		if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
			return "Win for player2";
		}
		
		// Advantage
		if (player1Point > player2Point && player2Point >= 3) {
			return "Advantage player1";
		}
		if (player2Point > player1Point && player1Point >= 3) {
			return "Advantage player2";
		}
		
		// Deuce
		if (player1Point == player2Point && player1Point >= 3)
			return "Deuce";
		
		// General
		if (isAll()) {
			return sayScore(player1Point) + "-All";
		}
		
		return sayScore(player1Point) + "-" + sayScore(player2Point);
	}

	public void SetP1Score(int number) {

		for (int i = 0; i < number; i++) {
			P1Score();
		}

	}

	public void SetP2Score(int number) {

		for (int i = 0; i < number; i++) {
			P2Score();
		}

	}

	public void P1Score() {
		player1Point++;
	}

	public void P2Score() {
		player2Point++;
	}

	public void wonPoint(String player) {
		if (player == "player1")
			P1Score();
		else
			P2Score();
	}
}
