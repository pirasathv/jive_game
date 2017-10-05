package ca.com.jive.game.service.game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ca.com.jive.game.domain.ICard;
import ca.com.jive.game.domain.SimpleDeck;
import ca.com.jive.game.service.game.impl.PokerGame;
import lombok.val;

/**
 * Service to manager a match of a game
 * 
 * @author Guilherme
 */
public class MatchService {

	// TODO - guilherme.rodrigues - Should be a generic game. Must fix in others
	// places
	public Map<String, IGame<SimpleDeck>> gamesStared;

	/**
	 * Starts a new game shuffling the deck and with all prepared to the first
	 * step.
	 * 
	 * @return The id of the game created.
	 */
	public String startGame() {
		if (this.gamesStared == null) {
			this.gamesStared = new HashMap<String, IGame<SimpleDeck>>();
		}

		IGame<SimpleDeck> newGame = new PokerGame<SimpleDeck>();

		// configure the game
		newGame.newDeck(new SimpleDeck());
		newGame.shuffle();

		String gameId = UUID.randomUUID().toString();

		this.gamesStared.put(gameId, newGame);
		return gameId;
	}

	/**
	 * Finilize the game started
	 * 
	 * @param gameId Id of the t
	 */
	public void endGame(String gameId) {
		this.gamesStared.remove(gameId);
	}

	/**
	 * Start a new deck on the game. Can only start a new deck if the current
	 * has no more cards
	 * 
	 * @param gameId The game id
	 * @throws IllegalStateException if the game still have cards on the deck
	 */
	public void newDeck(String gameId) {
		val game = this.getGame(gameId);
		if (game.getDeck().hasCards()) {
			throw new IllegalStateException("Can't start a new deck without finishing the current one");
		}

		game.newDeck(new SimpleDeck());
	}

	/**
	 * Shuflle the cards on the deck. Can be done any time
	 * 
	 * @param gameId The game id
	 */
	public void shuffle(String gameId) {
		val game = this.getGame(gameId);
		game.shuffle();
	}

	/**
	 * Get the next card on the deck of the game
	 * @param gameId The game id
	 * @return The next card. The deck will be decrease by one on the cards number
	 */
	public ICard dealOneCard(String gameId) {
		val game = this.getGame(gameId);
		return game.dealOneCard();
	}

	/**
	 * Get the game of the id check if it exists
	 * @param id Id of the game
	 * @return Game already started
	 */
	private IGame<SimpleDeck> getGame(String id) {
		IGame<SimpleDeck> game = this.gamesStared.get(id);
		if (game == null) {
			throw new IllegalArgumentException("No game for this id");
		}
		return game;
	}
}
