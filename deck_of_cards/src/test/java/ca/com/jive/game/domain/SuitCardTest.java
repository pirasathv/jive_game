package ca.com.jive.game.domain;

import org.junit.Test;

import ca.com.jive.game.domain.enums.SuitCardType;
import junit.framework.Assert;
import lombok.val;

/**
 * Test for the SuitCard domain class
 * @author Guilherme
 */
public class SuitCardTest {

	@Test(expected = IllegalArgumentException.class)
	public void checkNumberMinLimit() {
		new SuitCard(0, SuitCardType.CLUB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkNumberMaxLimit() {
		new SuitCard(14, SuitCardType.CLUB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkSuitTypeValidation() {
		new SuitCard(1, null);
	}
	
	@Test
	public void checkCardsNames() {
		val ace = new SuitCard(1, SuitCardType.CLUB);
		Assert.assertEquals("Card 1 name is wrong", "Ace", ace.getDisplayNumber());
		val jack = new SuitCard(11, SuitCardType.CLUB);
		Assert.assertEquals("Card 11 name is wrong", "Jack", jack.getDisplayNumber());
		val queen = new SuitCard(12, SuitCardType.CLUB);
		Assert.assertEquals("Card 12 name is wrong", "Queen", queen.getDisplayNumber());
		val king = new SuitCard(13, SuitCardType.CLUB);
		Assert.assertEquals("Card 13name is wrong", "King", king.getDisplayNumber());
		
		for (int i = 2; i <= 10; i++) {
			val card = new SuitCard(i, SuitCardType.CLUB);
			Assert.assertEquals("Card " + i + " name is wrong", String.valueOf(i), card.getDisplayNumber());
		}
		
	}
}
