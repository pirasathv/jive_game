package ca.com.jive.game.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import ca.com.jive.game.domain.enums.SuitCardType;
import lombok.EqualsAndHashCode;

/**
 * Provides a Deck with the regular 1 to 13 cards of the 4 suit
 * {@link SuitCardType} The deck is initialized with all the cards from each
 * suit in the natural order.
 * 
 * @author Guilherme
 */
@EqualsAndHashCode(of = "cards")
public final class SimpleDeck implements IDeck<SuitCard> {

	/** Total cards by suit */
	private static final int TOTAL_CARDS_SUIT = 13;
	/** List of cards in the deck */
	private LinkedList<SuitCard> cards;

	public SimpleDeck() {
		this.startDeck();
	}

	public boolean hasCards() {
		return !this.cards.isEmpty();
	}

	public SuitCard popCard() {
		return this.cards.pop();
	}

	public Collection<SuitCard> getCards() {
		return Collections.unmodifiableCollection(this.cards);
	}
	
	public int getTotalCards() {
		return this.cards.size();
	}

	public void swapCards(int indexA, int indexB) {
		Collections.swap(this.cards, indexA, indexB);
	}

	/**
	 * Start the deck adding all cards to it. The cards are sorted by natural
	 * order.
	 */
	private void startDeck() {
		this.cards = new LinkedList<SuitCard>();
		for (int i = 1; i <= SimpleDeck.TOTAL_CARDS_SUIT; i++) {
			this.cards.add(new SuitCard(i, SuitCardType.CLUB));
			this.cards.add(new SuitCard(i, SuitCardType.DIAMOND));
			this.cards.add(new SuitCard(i, SuitCardType.HEART));
			this.cards.add(new SuitCard(i, SuitCardType.SPADE));
		}
		Collections.sort(this.cards);
	}
}
