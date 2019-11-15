package eg.game.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eg.game.Game;
import eg.game.fixtures.StaticGame;
import org.junit.jupiter.api.Test;

public class StaticGameTest {

	@Test
	public void shouldReturnSameInstanceAfterTwoCalls() {

		Game game = StaticGame.getInstance();
		Game additionalGame = StaticGame.getInstance();
		assertEquals(game, additionalGame);
	}

}
