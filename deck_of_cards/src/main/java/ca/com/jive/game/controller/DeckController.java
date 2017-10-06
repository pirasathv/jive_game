package ca.com.jive.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.com.jive.game.domain.SuitCard;
import ca.com.jive.game.service.exception.NoDeckFoundException;
import ca.com.jive.game.service.impl.SimpleDeckService;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller to the actions on a deck
 * @author Guilherme
 */
@Slf4j
@RestController("/deck")
public class DeckController {

	@Autowired
	private SimpleDeckService deckService;

	@RequestMapping("/new")
	public String newDeck() {
		return this.deckService.newDeck();
	}
	
	@RequestMapping("/shuffle/{id}")
	public ResponseEntity<String> shuffle(@PathVariable("id") String deckId) {
		try {
			this.deckService.shuffle(deckId);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoDeckFoundException e) {
			log.info("No deck found for" + deckId, e);
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/deal-one-card/{id}")
	public ResponseEntity<SuitCard> dealOneCard(@PathVariable("id") String deckId) {
		try {
			SuitCard card = this.deckService.dealOneCard(deckId);
			return new ResponseEntity<SuitCard>(card, HttpStatus.OK);
		} catch (NoDeckFoundException e) {
			log.info("No deck found for" + deckId, e);
			return new ResponseEntity<SuitCard>(HttpStatus.BAD_REQUEST);
		}
	}
}
