package ca.com.jive.game.service.game.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import ca.com.jive.game.domain.IDeck;
import ca.com.jive.game.domain.SimpleDeck;
import ca.com.jive.game.domain.SuitCard;
import ca.com.jive.game.service.game.IDeckService;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of a Poker game.
 * 
 * @author Guilherme
 * @param <D> The deck type to use on the game 
 */
@Slf4j
@Service
public class SimpleDeckService implements IDeckService<SuitCard> {

	/** Number of operations to swap the cards */
	private static final int TIMES_TO_SHUFFLE = 1000;
	public Map<String, SimpleDeck> decksStared = new HashMap<String, SimpleDeck>();

	public String newDeck() {
		val newDeck = new SimpleDeck();
		this.shuffle(newDeck);

		String deckId = UUID.randomUUID().toString();
		this.decksStared.put(deckId, newDeck);
		return deckId;
	}

	public void shuffle(String id) {
		SimpleDeck deck = this.getDeck(id);
		if (deck == null) throw new IllegalArgumentException("No deck for this id");
		
		this.shuffle(deck);
	}

	/**
	 * @param deckId
	 * @return the next card on the deck or null if has no more cards
	 */
	public SuitCard dealOneCard(String deckId) {
		try {
			IDeck<SuitCard> deck = this.getDeck(deckId);
			if (deck == null) throw new IllegalArgumentException("No deck for this id");
			
			return deck.popCard();	
		} catch (NoSuchElementException e) {
			log.debug("No more cards on deck " + deckId);
			return null;
		}
	}

	public SimpleDeck getDeck(String id) {
		return this.decksStared.get(id);
	}
	
	private void shuffle(SimpleDeck deck) {
		final val random = ThreadLocalRandom.current();
		final int maxCardIndex = deck.getTotalCards();
		for (int i = 0; i < SimpleDeckService.TIMES_TO_SHUFFLE; i++) {
			int changeA = random.nextInt(0, maxCardIndex);
			int changeB = random.nextInt(0, maxCardIndex);
			deck.swapCards(changeA, changeB);
		}
	}
}
