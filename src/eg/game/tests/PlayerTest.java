package eg.game.tests;

import eg.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

	private Player playerOne; 
	
	private Player playerTwo; 
	
	@BeforeEach
	public void setup() { 
		playerOne = new Player("Alan Turing");
		playerTwo = new Player("Augusta Ada King");
	}
	
	@Test
	public void shouldHaveNameAfterInitialisation() {
		assertEquals("Alan Turing", playerOne.getName());
	}
	
	@Test 
	public void shouldIdentifyPlayersWithSameName() { 
		Player alternativePlayerOne = new Player("Alan Turing"); 
		assertTrue(playerOne.equals(alternativePlayerOne));
	}
	
	@Test 
	public void shouldIdentifyPlayersWithDifferentName() { 
		assertFalse(playerOne.equals(playerTwo));
	}
	
	@Test 
	public void shouldOnlyTestEqualsForPlayerObjects() { 
		Object o = new Object(); 
		assertFalse(playerOne.equals(o));
	}

}
