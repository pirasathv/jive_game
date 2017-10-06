# Jive Deck Application

Small system to manager a deck. This project contains the back and the front end.

# Back-end details

The back-end was building using:
- Java 8
- SpringBoot
- Lombok: You must configure the Lombok on your IDE, otherwise the code won't compile. But it's very simples, check details here https://projectlombok.org/

To start the backend, just execute the class ca.com.jive.game.config.spring.SpringStarter.java, SpringBoot will do the hard work ;)
The system will run on http://localhost:8090/

# Some details

Some classes have Javadoc with some details of the implementation, just to explain the decisions.

The general idea is that the system manages a deck. Actually, decks. So, the REST API exposes some methods to create a new deck, shuffle a specific deck and get one card for the specific deck.
The newDeck method returns the id of the deck created. This is important to call the others methods. You must pass the id of the deck you want to get a card or shuffle. This allow to multiples games calling the API. The validation of if you can shuffle the deck after got the first card is not the responsible of this deck api. Each game can have differents rules for that so thats why I didn't implemented it. So this API has the responsabilities of:

1 - Create a new deck, return the id of it and store this new deck (it's stored on memory, didn't put a DB or any other storage way)
2 - Shuffle the deck. You must provide the id of the deck you want to shuffle. If the deck wasn't created it, it returns a BadRequest (400)
3 - Get a card from the deck. You must provide the id of the deck. If not, the same BadRequest will be returned. If you got all cards and try to get a new one the deck will be removed from the storage (delete the id), and no card is returned (null). It's a way to say "no more cards here, deck will be finished". Another attempt to get a card will result in a BadRequest, since the deck doesn't exist anymore.


Some improvements that can be done
- Return the number of the cards left on the deck when calling 'GetACard'. This will avoid a call to the API and return null to say "no more cards".
- Add a method to finish a deck or finish them automatically after some time.
- Not storing decks on memory (of course), maybe adding some kind of authentication and validation to not let anyone touch on the deck of another game


# Front-end Project

The front-end is in this same repository just to make it easy here, but in this kind of projet (Angular/React/etc + REST backend), I like to but then in differents repository. The backend and the frontend can have a different lifecicle and differents versions, so it works better having then in two differents projects

For some details of the Front-end, check the README.md inside src/main/web

