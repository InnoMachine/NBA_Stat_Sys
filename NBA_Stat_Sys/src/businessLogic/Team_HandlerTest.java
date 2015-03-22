package businessLogic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Team_HandlerTest {

	Team_Handler team_handler;
	@Before
	public void setUp() throws Exception {
		team_handler = new Team_Handler();
	}

	@Test
	public void testGetTeamByAbbr() {
		assertTrue(team_handler.getTeamByAbbr("ATL")!=null);
		assertTrue(team_handler.getTeamByAbbr("AT")==null);
	}

	@Test
	public void testGetAllTeam() {
		assertTrue(team_handler.getAllTeam().size()==30);
	}

}
