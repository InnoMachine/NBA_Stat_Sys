package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;

public class Player_BL_Stub implements Player_BS{

	
	public PlayerVo getPlayerByName(String name) {
		PlayerVo playerVo=new PlayerVo();
		playerVo.setName("James");
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
		b.setAge(26);
		c.setBirth("1988-07-08");
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
		a.setName("aaa");
		b.setName("bbb");
		c.setName("ccc");
		c.setBirth("1988-07-08");
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
	}

	public ArrayList<PlayerVo> filterPlayerBy(String position, String div, String option) {
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		a.setName("a");
		b.setName("bb");
		c.setName("ccc");
		c.setBirth("1988-07-08");
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		System.out.println("筛选成功！");
		return playerVos;
		
	}
	
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
		c.setBirth("1988-07-08");
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
		
	}
	
	
}
