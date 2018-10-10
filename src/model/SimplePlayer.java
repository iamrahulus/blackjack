package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;

	private String playerName;

	private int points;

	private int bet;

	private int result;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		this.bet = bet;
		if (bet >= 0 && this.points >= bet)
			return true;
		return false;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
	}

	@Override
	public int getResult() {
		return this.result;
	}

	@Override
	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("Player: ");
		strBuffer.append("id=" + this.playerId);
		strBuffer.append(", name=" + this.playerName);
		strBuffer.append(", points=" + this.points);
		return strBuffer.toString();
	}
}