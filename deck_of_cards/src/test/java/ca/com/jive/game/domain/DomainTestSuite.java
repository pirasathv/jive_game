package ca.com.jive.game.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite to run all tests from Domain package
 * @author Guilherme
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	SimpleDeckTest.class,
	SuitCardTest.class
})
public class DomainTestSuite {

}
