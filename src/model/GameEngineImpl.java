package model;

import java.util.Collection;
import java.util.Deque;

import view.interfaces.GameEngineCallback;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;

public class GameEngineImpl implements GameEngine {

	GameEngineCallback gameEngineCallback = null;

	@Override
	public void dealPlayer(Player player, int delay) {
		// TODO Auto-generated method stub
		/*
		 * 1. deal a card to the player 2. call GameEngineCallback.nextCard(...)
		 * 3. continue looping until the player busts (default value of
		 * GameEngine.BUST_TOTAL=21) 4. GameEngineCallback.bustCard(...) 5. call
		 * {@link GameEngineCallback#result(Player, int, GameEngine)} with final
		 * result for player (the pre bust total) 6. update the player with
		 * final result so it can be retrieved later
		 */
		PlayingCard card = null;
		int pointsBeforeBust = 0;
		while (true) {
			card = dealACard();
			setPlayerPointsBeforeDeal(player, card);
			gameEngineCallback.nextCard(player, card, this);
			if (player.getPoints() > GameEngine.BUST_LEVEL)
				break;
			pointsBeforeBust = player.getPoints();
		}
		this.gameEngineCallback.bustCard(player, card, this);
		this.gameEngineCallback.result(player, pointsBeforeBust, this);
		player.setPoints(pointsBeforeBust);
	}

	private void setPlayerPointsBeforeDeal(Player player, PlayingCard card) {
		player.setPoints(player.getPoints() + card.getScore());
	}

	private PlayingCard dealACard() {
		PlayingCard pc = new PlayingCardImpl();
		return pc;
	}

	@Override
	public void dealHouse(int delay) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		this.gameEngineCallback = gameEngineCallback;
	}

	@Override
	public boolean removeGameEngineCallback(
			GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() {
		// TODO Auto-generated method stub
		return null;
	}

}
