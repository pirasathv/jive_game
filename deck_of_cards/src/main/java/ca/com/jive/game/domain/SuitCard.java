package ca.com.jive.game.domain;

import ca.com.jive.game.domain.enums.SuitCardType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.val;

/**
 * Represents a common suit card of a deck. Can be one of the
 * {@link SuitCardType} suit types. It has the number and the suit of the card.
 * 
 * Has no setter's methods because the card details should not be allowed to change.
 * 
 * @author Guilherme
 */
@EqualsAndHashCode(of = { "number", "suit" })
public final class SuitCard implements ICard {

	@Getter private final int number;
	@Getter private final String displayNumber;
	@Getter private final SuitCardType suit;

	/**
	 * Creates a new card with its number and suit.
	 * 
	 * @param number The number value of the card. Must be from 1 to 13
	 * @param type The suit type. Check {@link SuitCardType}
	 */
	public SuitCard(int number, SuitCardType type) {
		if (number < 1 || number > 13)
			throw new IllegalArgumentException("Invalid card number. Must be between 1-13");
		if (type == null)
			throw new IllegalArgumentException("Invalid card suit. Must not be null");

		this.number = number;
		this.suit = type;
		this.displayNumber = this.getCardName(number);
	}

	public int compareTo(ICard o) {
		if (!(o instanceof SuitCard)) {
			return -1;
		}

		val suitCard = (SuitCard) o;
		if (suitCard.getSuit().equals(this.suit)) {
			return Integer.compare(this.number, o.getNumber());
		}

		return this.suit.compareTo(suitCard.getSuit());
	}

	/**
	 * @param number Card number value
	 * @return Returns the name of the card if it has some special name, or just
	 *         the number of the card as a string.
	 */
	private String getCardName(int number) {
		String cardName = "";
		switch (number) {
		case 1:
			cardName = "Ace";
			break;
		case 11:
			cardName = "Jack";
			break;
		case 12:
			cardName = "Queen";
			break;
		case 13:
			cardName = "King";
			break;
		default:
			cardName = String.valueOf(number);
			break;
		}
		return cardName;
	}

}
