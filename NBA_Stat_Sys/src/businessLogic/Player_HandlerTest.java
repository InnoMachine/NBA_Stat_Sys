package businessLogic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Player_HandlerTest {

	Player_Handler player_handler;
	@Before
	public void setUp() throws Exception {
		player_handler = new Player_Handler();
	}

	@Test
	public void testGetPlayerByName() {
		assertTrue(player_handler.getPlayerByName("Aaro")==null);
		assertTrue(player_handler.getPlayerByName("Aaron Gray")!=null);
	}

	@Test
	public void testGetAllPlayer() {
		assertTrue(player_handler.getAllPlayer().size()==448);
		assertTrue(player_handler.getAllPlayer().size()!=221);
	}

	

	@Test
	public void testGetPlayersByTeam() {
		assertTrue(player_handler.getPlayersByTeam("ATL")!=null);
	}

	

}
