package ca.com.jive.game.domain;

import java.util.Collection;

/**
 * Interface with methods to access a deck.
 * 
 * @author Guilherme
 */
public interface IDeck<C extends ICard> {

	/**
	 * @return true if the deck still have some cards
	 */
	int getTotalCards();

	/**
	 * @return ICard from the top of the deck. The card is removed from the
	 *         deck.
	 */
	boolean hasCards();

	/**
	 * @return The list of cards on the deck. Usually should be unmodifiable
	 */
	Collection<C> getCards();

	/**
	 * @return the card of the top of the deck. The card is removed from the
	 *         deck
	 */
	C popCard();

	/**
	 * Swap two cards of order.
	 * 
	 * @param indexA First index to swap
	 * @param indexB Second index to swap
	 */
	void swapCards(int indexA, int indexB);
}
