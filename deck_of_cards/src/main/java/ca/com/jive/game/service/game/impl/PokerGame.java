package ca.com.jive.game.service.game.impl;

import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import ca.com.jive.game.domain.ICard;
import ca.com.jive.game.domain.IDeck;
import ca.com.jive.game.service.game.IGame;
import lombok.Getter;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of a Poker game.
 * 
 * @author Guilherme
 * @param <D> The deck type to use on the game 
 */
@Slf4j
public class PokerGame<D extends IDeck<?>> implements IGame<D> {

	private static final int TIMES_TO_SHUFFLE = 1000;
	@Getter private D deck;

	public D newDeck(D instance) {
		return this.deck = instance;
	}

	public void shuffle() {
		final val random = ThreadLocalRandom.current();
		final int maxCardIndex = this.deck.getTotalCards();
		for (int i = 0; i < PokerGame.TIMES_TO_SHUFFLE; i++) {
			int changeA = random.nextInt(0, maxCardIndex);
			int changeB = random.nextInt(0, maxCardIndex);
			this.deck.swapCards(changeA, changeB);
		}
	}

	/**
	 * @return the next card on the deck or null if has no more cards
	 */
	public ICard dealOneCard() {
		try {
			return this.deck.popCard();	
		} catch (NoSuchElementException e) {
			log.debug("No more cards on deck");
			return null;
		}
		
	}
}
