package ca.com.jive.game.service.game;

import ca.com.jive.game.domain.ICard;
import ca.com.jive.game.domain.IDeck;

/**
 * Interface of a game using an specific deck
 * 
 * @author Guilherme
 * @param <D> The deck type
 */
public interface IGame<D extends IDeck<?>> {

	/**
	 * @return The current deck on the game
	 */
	D getDeck();

	/**
	 * @param instance A new instance of a deck to be used for the game
	 * @return The new deck stted
	 */
	D newDeck(D instance);

	/**
	 * Change the order of the cards deck
	 */
	void shuffle();

	/**
	 * @return The next card of the deck, removing it from the deck
	 */
	ICard dealOneCard();
}
