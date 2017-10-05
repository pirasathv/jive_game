package ca.com.jive.game.domain;

/**
 * Interface for a type of card. Each card must provide its number and a display
 * name
 * 
 * @author Guilherme
 */
public interface ICard extends Comparable<ICard> {

	int getNumber();

	String getDisplayNumber();

}
