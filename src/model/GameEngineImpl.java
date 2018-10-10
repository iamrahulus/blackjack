package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import view.interfaces.GameEngineCallback;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;

public class GameEngineImpl implements GameEngine {

	private List<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();

	private List<Player> players = new ArrayList<Player>();

	Deque<PlayingCard> playingCards = null;

	private void dealCardsToHouse(int delay) {
		playHouse(delay);
	}

	private void dealCardsToPlayer(Player p, int delay) {
		playPlayer(p, delay);
	}

	private void adjustPoints(int dealerScore) {
		for (Player p : players) {
			if (p.getResult() < dealerScore)
				p.setPoints(p.getPoints() - p.getBet());
			if (p.getResult() > dealerScore)
				p.setPoints(p.getPoints() + p.getBet());
		}
	}

	private int playHouse(int delay) {
		int dealerScore = 0;
		PlayingCard card = null;
		while (true) {
			card = dealACard(playingCards);
			dealerScore += card.getScore();
			if (dealerScore > GameEngine.BUST_LEVEL)
				break;
			for (GameEngineCallback gameEngineCallback : gameEngineCallbacks)
				gameEngineCallback.nextHouseCard(card, this);
			pause(delay);
		}
		dealerScore = dealerScore - card.getScore();
		adjustPoints(dealerScore);
		updateHouseCallbacks(card, dealerScore);
		return dealerScore;
	}

	private int playPlayer(Player p, int delay) {
		int playerScore = 0;
		if (playingCards == null)
			playingCards = getShuffledDeck();
		PlayingCard card = null;
		while (true) {
			card = dealACard(playingCards);
			playerScore += card.getScore();
			if (playerScore > GameEngine.BUST_LEVEL)
				break;
			for (GameEngineCallback gameEngineCallback : gameEngineCallbacks) {
				gameEngineCallback.nextCard(p, card, this);
			}
			pause(delay);
		}
		playerScore = playerScore - card.getScore();
		p.setResult(playerScore);
		updatePlayersCallbacks(p, card, playerScore);
		return playerScore;
	}

	private void pause(int d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException ioe) {
			ioe.printStackTrace();
		}
	}

	private void updateHouseCallbacks(PlayingCard c, int r) {
		for (GameEngineCallback g : this.gameEngineCallbacks) {
			g.houseBustCard(c, this);
			g.houseResult(r, this);
		}
	}

	private void updatePlayersCallbacks(Player p, PlayingCard c, int r) {
		for (GameEngineCallback g : this.gameEngineCallbacks) {
			g.bustCard(p, c, this);
			g.result(p, r, this);
		}
	}

	private PlayingCard dealACard(Deque<PlayingCard> playingCards) {
		return playingCards.pop();
	}

	private List<PlayingCard> createPlayingCardList() {
		List<PlayingCard> playingCards = new ArrayList<PlayingCard>();
		for (Suit s : PlayingCard.Suit.values()) {
			for (Value v : PlayingCard.Value.values()) {
				PlayingCard pc = new PlayingCardImpl(v, s);
				playingCards.add(pc);
			}
		}
		return playingCards;
	}

	@Override
	public void dealHouse(int delay) {
		dealCardsToHouse(delay);
	}

	@Override
	public void dealPlayer(Player player, int delay) {
		dealCardsToPlayer(player, delay);
	}

	@Override
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player p : this.players) {
			if (p.getPlayerId().equals(id))
				return p;
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return this.players.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(
			GameEngineCallback gameEngineCallback) {
		return this.gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableList(this.players);
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() {
		List playingCardList = createPlayingCardList();
		Collections.shuffle(playingCardList);
		Deque<PlayingCard> dq = new ArrayDeque<PlayingCard>(playingCardList);
		return dq;
	}
}