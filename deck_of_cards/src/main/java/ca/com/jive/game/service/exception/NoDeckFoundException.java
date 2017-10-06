package ca.com.jive.game.service.exception;

import lombok.Getter;

/**
 * Custom Exception for a NoDeckFound id 
 * @author Guilherme
 */
public class NoDeckFoundException extends Exception {

	/** */
	private static final long serialVersionUID = 8939340467370984059L;
	@Getter private String deckId;
	
	public NoDeckFoundException(String id) {
		super("No deck found for id" + id);
		this.deckId = id;
	}
}
