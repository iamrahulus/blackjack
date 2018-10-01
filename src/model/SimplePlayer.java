package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;

	private String playerName;

	private int points;

	private int bet;

	private int result;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		// TODO Auto-generated constructor stub
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return this.playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		// TODO Auto-generated method stub
		this.bet = bet;
		if (bet >= 0 && this.points >= bet)
			return true;
		return false;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return this.bet;
	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub
		this.bet = 0;
	}

	@Override
	public int getResult() {
		// TODO Auto-generated method stub
		return this.result;
	}

	@Override
	public void setResult(int result) {
		// TODO Auto-generated method stub
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("Player: ");
		strBuffer.append("id=" + this.playerId);
		strBuffer.append(", name=" + this.playerName);
		strBuffer.append(", points=" + this.points + "\n");
		return strBuffer.toString();
	}
}