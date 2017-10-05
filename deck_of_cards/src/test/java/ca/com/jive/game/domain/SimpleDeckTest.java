package ca.com.jive.game.domain;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import ca.com.jive.game.domain.enums.SuitCardType;
import lombok.val;

/**
 * Test for the SimpleDeck 
 * @author Guilherme
 */
public class SimpleDeckTest {

	@Test
	public void checkTotalCards() {
		val deck = new SimpleDeck();
		Assert.assertEquals("SimpleDeck was not initialized with the right number of cards", 52, deck.getTotalCards());
	}
	
	@Test
	public void checkPopCard() {
		val deck = new SimpleDeck();
		deck.popCard();
		deck.popCard();
		Assert.assertEquals("SimpleDeck didn't remove the card", 50, deck.getTotalCards());
		deck.popCard();
		Assert.assertEquals("SimpleDeck didn't remove the card", 49, deck.getTotalCards());
	}
	
	@Test
	public void checkSwap() {
		val deck = new SimpleDeck();
		int indexA = 15;
		int indexB = 28;
		
		val cartA = new SuitCard(3, SuitCardType.SPADE);
		val cartB = new SuitCard(3, SuitCardType.CLUB);
		Assert.assertEquals(cartA, new ArrayList<ICard>(deck.getCards()).get(indexA));
		Assert.assertEquals(cartB, new ArrayList<ICard>(deck.getCards()).get(indexB));
		
		deck.swapCards(indexA, indexB);
		
		Assert.assertEquals("Swap didn't work correctly", cartB, new ArrayList<ICard>(deck.getCards()).get(indexA));
		Assert.assertEquals("Swap didn't work correctly", cartA, new ArrayList<ICard>(deck.getCards()).get(indexB));
	}

}
