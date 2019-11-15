package eg.game.tests;

import eg.game.Game;
import eg.game.GameException;
import eg.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

	private Game game; 
	
	@BeforeEach
	public void setup() { 
	   game = new Game(); 	
	}
	
	@Test
	public void shouldHaveZeroPlayersAndNotStartWhenInitialised() {
		Player player = new Player("Ada Lovelace");
		
		assertFalse(game.playerIsPlaying(player));
		assertEquals(0, game.getNumberOfPlayers());
		assertFalse(game.gameHasStarted());
	}
	
	@Test
	public void shouldSeeIncreaseInPlayerNumbersWhenNewPlayersAddedBeforeGameStarted() 
	throws GameException { 
		game.addPlayer("Alan Turing");
		assertEquals(1, game.getNumberOfPlayers());
		
		game.addPlayer("Ada Countess of Lovelace");
		assertEquals(2, game.getNumberOfPlayers());
	}
	
	@Test
	public void shouldNotAllowPersonToJoinGameWhenTheGameHasStarted() {

		assertThrows(GameException.class, () -> {
			game.addPlayer("Alan Turing");
			game.takeTurn(1);
			game.addPlayer("Ada Countess of Lovelace");
		});

	}
	
	@Test 
	public void shouldRemovePlayersWhenPlayersAreInGame() throws GameException { 
		Player player = game.addPlayer("Ada"); 
		Player player2 = game.addPlayer("Babbage"); 
		
		game.removePlayer(player);
		game.removePlayer(player2); 
	}
	
	@Test
	public void shouldNotAllowPersonToLeaveGameWhenGameHasStarted() {
       assertThrows(GameException.class, () -> {
		   Player player = game.addPlayer("Ada");
		   game.takeTurn(2);
		   game.removePlayer(player);
	   });

	}
	
	@Test 
	public void shouldManageCorrectTurnForPlayers() throws GameException { 
	   game.addPlayer("Ada");
	   game.addPlayer("Babbage");
	   
	   assertEquals("Ada", game.takeTurn(2));
	   assertEquals("Babbage", game.takeTurn(5));
	   assertEquals("Ada", game.takeTurn(3));
	}
	
	@Test 
	public void shouldShowGameHasStartedAfterFirstTurn() throws GameException { 
		game.addPlayer("Ada"); 
		game.takeTurn(1); 
		assertTrue(game.gameHasStarted());
	}
	
	@Test 
	public void shouldReturnPlayerInGame() throws GameException { 
		Player ada = game.addPlayer("Ada"); 
		Player babbage = game.addPlayer("Babbage"); 
		
		assertEquals(ada, game.getPlayerNamed("Ada"));
		assertEquals(babbage, game.getPlayerNamed("Babbage"));
	}
	
	@Test 
	public void shouldNotFindPersonWhoIsNotInTheGame() throws GameException { 
		assertNull(game.getPlayerNamed("Ada"));
		game.addPlayer("Babbage"); 
		assertNull(game.getPlayerNamed("Ada"));
	}
	
	@Test 
	public void shouldConfirmPlayerIsInGame() throws GameException { 
		Player ada = game.addPlayer("Ada"); 
		assertTrue(game.playerIsPlaying(ada));
	}

	@Test 
	public void shouldConfirmPlayerIsNotInGame() throws GameException { 
		game.addPlayer("Ada"); 
		Player babbage = new Player("Babbage");
		assertFalse(game.playerIsPlaying(babbage));
	}
	
}
