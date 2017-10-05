package ca.com.jive.game.domain;

import java.util.ArrayList;

import org.junit.Test;

import ca.com.jive.game.domain.enums.SuitCardType;
import junit.framework.Assert;
import lombok.val;

/**
 * Test for the SimpleDeck 
 * @author Guilherme
 */
public class SimpleDeckTest {

	@Test
	public void checkTotalCards() {
		val deck = new SimpleDeck();
		Assert.assertEquals("SimpleDeck was not initialized with the right number of cards", 48, deck.getTotalCards());
	}
	
	@Test
	public void checkPopCard() {
		val deck = new SimpleDeck();
		deck.popCard();
		deck.popCard();
		Assert.assertEquals("SimpleDeck didn't remove the card", 46, deck.getTotalCards());
		deck.popCard();
		Assert.assertEquals("SimpleDeck didn't remove the card", 45, deck.getTotalCards());
	}
	
	@Test
	public void checkSwap() {
		val deck = new SimpleDeck();
		int indexA = 15;
		int indexB = 28;
		
		val cartA = new SuitCard(9, SuitCardType.CLUB);
		val cartB = new SuitCard(8, SuitCardType.SPADE);
		Assert.assertEquals(cartA, new ArrayList<ICard>(deck.getCards()).get(indexA));
		Assert.assertEquals(cartB, new ArrayList<ICard>(deck.getCards()).get(indexB));
		
		deck.swapCards(indexA, indexB);
		
		Assert.assertEquals("Swap didn't work correctly", cartB, new ArrayList<ICard>(deck.getCards()).get(indexA));
		Assert.assertEquals("Swap didn't work correctly", cartA, new ArrayList<ICard>(deck.getCards()).get(indexB));
	}

}
