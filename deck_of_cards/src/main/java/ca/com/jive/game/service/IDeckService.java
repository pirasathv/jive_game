package ca.com.jive.game.service;

import ca.com.jive.game.domain.ICard;
import ca.com.jive.game.domain.IDeck;
import ca.com.jive.game.service.exception.NoDeckFoundException;

/**
 * Interface of a service deck using an specific deck
 * 
 * @author Guilherme
 * @param <D> The deck type
 */
public interface IDeckService<C extends ICard> {

	/**
	 * @param id The id of the deck created
	 * @return The current found or null
	 */
	IDeck<C> getDeck(String id);

	/**
	 * @return The id of new deck created
	 */
	String newDeck();

	/**
	 * @param id The id of the deck created
	 * Change the order of the cards deck
	 * @throws NoDeckFoundException
	 */
	void shuffle(String id) throws NoDeckFoundException;

	/**
	 * @param id The id of the deck created
	 * @return The next card of the deck, removing it from the deck
	 * @throws NoDeckFoundException
	 */
	C dealOneCard(String deckId) throws NoDeckFoundException;
}
