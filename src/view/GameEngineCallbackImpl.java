package view;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public GameEngineCallbackImpl() {
		logger.setLevel(Level.ALL);
	}

	private LogRecord getLogRecord(String log) {
		return new LogRecord(Level.INFO, log);
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		String log = String.format(
				"Card Dealt to %s Suit: %s, Value: %s, Score: %d",
				player.getPlayerName(), card.getSuit(), card.getValue(),
				card.getScore());
		logger.log(getLogRecord(log));
	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		String log = String.format("%s, final result=%d",
				player.getPlayerName(), result);
		logger.log(getLogRecord(log));
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		String log = String
				.format("Card Dealt to %s Suit: %s, Value: %s, Score: %d ... YOU BUSTED!",
						player.getPlayerName(), card.getSuit(),
						card.getValue(), card.getScore());
		logger.log(getLogRecord(log));
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		String log = String.format(
				"Card Dealt to House Suit: %s, Value: %s, Score: %d",
				card.getSuit(), card.getValue(), card.getScore());
		logger.log(getLogRecord(log));
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		String log = String
				.format("Card Dealt to House Suit: %s, Value: %s, Score: %d ... HOUSE BUSTED!",
						card.getSuit(), card.getValue(), card.getScore());
		logger.log(getLogRecord(log));
	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		String log = String.format("House, final result=%d", result);
		logger.log(getLogRecord(log));
		printFinalResults(engine);
	}

	private void printFinalResults(GameEngine e) {
		logger.log(Level.INFO, "Final Player Results");
		for (Player p : e.getAllPlayers()) {
			System.out.println(p);
		}
	}
}