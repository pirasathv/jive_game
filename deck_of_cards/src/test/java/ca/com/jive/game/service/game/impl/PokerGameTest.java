package ca.com.jive.game.service.game.impl;

import org.junit.Assert;
import org.junit.Test;

import ca.com.jive.game.domain.SimpleDeck;
import lombok.val;

public class PokerGameTest {

	@Test
	public void checkDealOneCard() {
		val game = new PokerGame<SimpleDeck>();
		game.newDeck(new SimpleDeck());

		Assert.assertEquals(48, game.getDeck().getTotalCards());
		game.dealOneCard();
		Assert.assertEquals(47, game.getDeck().getTotalCards());
		game.dealOneCard();
		Assert.assertEquals(46, game.getDeck().getTotalCards());
	}
	
	@Test
	public void checkSuffle() {
		val game = new PokerGame<SimpleDeck>();
		game.newDeck(new SimpleDeck());
		
		val previousCards = game.getDeck().getCards();
		Assert.assertEquals(48, game.getDeck().getTotalCards());
		game.shuffle();
		val shuffledCards = game.getDeck().getCards();
		Assert.assertEquals(48, game.getDeck().getTotalCards());
		Assert.assertFalse("Deck was not shuffled", previousCards.equals(shuffledCards));
	}
	
	@Test
	public void checkPopUntilLastCard() {
		val game = new PokerGame<SimpleDeck>();
		game.newDeck(new SimpleDeck());
		
		int totalCards = game.getDeck().getTotalCards();
		for (int i = 0; i < totalCards; i++) {
			game.dealOneCard();
		}

		Assert.assertNull("Should has no more cards", game.dealOneCard());
	}

}
