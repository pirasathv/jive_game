package ca.com.jive.game.service.game.impl;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;

public class SimpleDeckServiceTest {

	@Test
	public void checkDealOneCard() {
		val service = new SimpleDeckService();
		val deckId = service.newDeck();

		Assert.assertEquals(48, service.getDeck(deckId).getTotalCards());
		service.dealOneCard(deckId);
		Assert.assertEquals(47, service.getDeck(deckId).getTotalCards());
		service.dealOneCard(deckId);
		Assert.assertEquals(46, service.getDeck(deckId).getTotalCards());
	}
	
	@Test
	public void checkSuffle() {
		val service = new SimpleDeckService();
		val deckId = service.newDeck();
		
		val previousCards = service.getDeck(deckId).getCards();
		Assert.assertEquals(48, service.getDeck(deckId).getTotalCards());
		service.shuffle(deckId);
		val shuffledCards = service.getDeck(deckId).getCards();
		Assert.assertEquals(48, service.getDeck(deckId).getTotalCards());
		Assert.assertFalse("Deck was not shuffled", previousCards.equals(shuffledCards));
	}
	
	@Test
	public void checkPopUntilLastCard() {
		val service = new SimpleDeckService();
		val deckId = service.newDeck();
		
		int totalCards = service.getDeck(deckId).getTotalCards();
		for (int i = 0; i < totalCards; i++) {
			service.dealOneCard(deckId);
		}

		Assert.assertNull("Should has no more cards", service.dealOneCard(deckId));
	}

}
