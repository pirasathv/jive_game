package ca.com.jive.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.com.jive.game.domain.SuitCard;
import ca.com.jive.game.service.impl.SimpleDeckService;

/**
 * Controller to the actions on a deck
 * @author Guilherme
 */
@RestController("/deck")
public class DeckController {

	@Autowired
	private SimpleDeckService deckService;

	@RequestMapping("/new")
	public String newDeck() {
		return this.deckService.newDeck();
	}
	
	@RequestMapping("/shuffle/{id}")
	public void shuffle(@PathVariable("id") String deckId) {
		this.deckService.shuffle(deckId);
	}
	
	@RequestMapping("/deal-one-card/{id}")
	public SuitCard dealOneCard(@PathVariable("id") String deckId) {
		return this.deckService.dealOneCard(deckId);
	}
}
