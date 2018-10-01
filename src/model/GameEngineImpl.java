package model;

import java.util.Collection;
import java.util.Deque;

import view.interfaces.GameEngineCallback;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;

public class GameEngineImpl implements GameEngine {

	@Override
	public void dealPlayer(Player player, int delay) {
		// TODO Auto-generated method stub
		
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
