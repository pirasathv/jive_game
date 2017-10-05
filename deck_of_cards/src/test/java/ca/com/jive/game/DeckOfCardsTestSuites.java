package ca.com.jive.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ca.com.jive.game.domain.DomainTestSuite;
import ca.com.jive.game.service.game.impl.ServiceGameTestSuite;

/**
 * Suite to run all tests of the project
 * @author Guilherme
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  DomainTestSuite.class,
  ServiceGameTestSuite.class
})
public class DeckOfCardsTestSuites {

}
