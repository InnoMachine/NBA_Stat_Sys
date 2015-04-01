package businessLogic;

import java.util.ArrayList;

import po.Division;
import vo.PlayerVo;

public class Player_BL_Stub implements Player_BS{

	
	public PlayerVo getPlayerByName(String name) {
		PlayerVo playerVo=new PlayerVo();
		playerVo.setName(name);
		playerVo.setBlockRate(0.035);
		playerVo.setAge(31);
		return playerVo;
	}

	public ArrayList<PlayerVo> getAllPlayer() {
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		a.setName("aaa");
		a.setDivision(Division.ATLANTIC);
		b.setAge(26);
		b.setDivision(Division.CENTRAL);
		c.setBirth("1988-07-08");
		c.setDivision(Division.NORTHWEST);
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
	}

	public ArrayList<PlayerVo> sortPlayerBy(String option) {
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		PlayerVo d=new PlayerVo();
		PlayerVo e=new PlayerVo();
		a.setName("aaa");
		a.setDivision(Division.ATLANTIC);
		b.setName("bbb");
		b.setDivision(Division.CENTRAL);
		c.setName("ccc");
		c.setBirth("1988-07-08");
		c.setDivision(Division.NORTHWEST);
		d.setName("dddd");
		d.setDivision(Division.PACIFIC);
		e.setName("eeeee");
		e.setDivision(Division.SOUTHEAST);
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		playerVos.add(d);
		playerVos.add(e);
		return playerVos;
	}

	public ArrayList<PlayerVo> filterPlayerBy(String position, String div, String option) {
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		PlayerVo d=new PlayerVo();
		PlayerVo e=new PlayerVo();
		a.setName("a");
		a.setDivision(Division.ATLANTIC);
		b.setName("bb");
		b.setDivision(Division.CENTRAL);
		c.setName("ccc");
		c.setBirth("1988-07-08");
		c.setDivision(Division.NORTHWEST);
		d.setName("dddd");
		d.setDivision(Division.PACIFIC);
		e.setName("eeeee");
		e.setDivision(Division.SOUTHEAST);
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		playerVos.add(d);
		playerVos.add(e);
		System.out.println("筛选成功！");
		return playerVos;
		
	}
	/*
	public ArrayList<PlayerVo> getPlayersByTeam(String abbr)
	{
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		a.setName("aaa");
		b.setName("bb");
		c.setName("c");
		b.setAge(26);
		b.setDivision(Division.CENTRAL);
		c.setBirth("1988-07-08");
		c.setDivision(Division.NORTHWEST);
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
		
	}
	*/
	
}
