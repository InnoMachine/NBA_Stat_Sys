/**
 * puppy
 * 2015年3月9日 上午10:22:37
 * TODO
 */
package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseMysqlUtility.DBUtil;
import po.PlayerPO;
import po.SinglePerformance;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public void add(PlayerPO player) {
		
		String sql = "insert into nba.players(name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath)values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getNumber());
			pstmt.setString(3, player.getPosition());
			pstmt.setString(4, player.getHeight());
			pstmt.setString(5, player.getWeight());
			pstmt.setString(6, player.getBirth());
			pstmt.setInt(7, player.getAge());
			pstmt.setInt(8, player.getExp());
			pstmt.setString(9, player.getSchool());
			pstmt.setString(10, player.getActionImgPath());
			pstmt.setString(11, player.getPortraitImgPath());
//			pstmt.setString(12, player.getSeasonSinglePerformance().toString());//no need
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void update(PlayerPO player) {
		
		String sql = "update nba.players set name=?,number=?,position=?,height=?,weight=?,birth=?,age=?,exp=?,school=?,actionimgpath=?,portraitimgpath=?,seasonsp=? where name=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getNumber());
			pstmt.setString(3, player.getPosition());
			pstmt.setString(4, player.getHeight());
			pstmt.setString(5, player.getWeight());
			pstmt.setString(6, player.getBirth());
			pstmt.setInt(7, player.getAge());
			pstmt.setInt(8, player.getExp());
			pstmt.setString(9, player.getSchool());
			pstmt.setString(10, player.getActionImgPath());
			pstmt.setString(11, player.getPortraitImgPath());
			
			String singleSpListText = new String();
			for(SinglePerformance sp: player.getSeasonSinglePerformance()){
				singleSpListText += (sp.toString()+"$");
			}
			pstmt.setString(12, singleSpListText);
			
			pstmt.setString(13, player.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}

	}

	@Override
	public void deletePlayerByName(String name) {

		String sql = "delete from nba.players where name=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public PlayerPO getPlayerByName(String name) {

		PlayerPO player = new PlayerPO();
		String sql = "select name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath,seasonsp from nba.players where name=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
				player.setName(rs.getString("name"));
				player.setNumber(rs.getString("number"));
				player.setPosition(rs.getString("position"));
				player.setHeight(rs.getString("height"));
				player.setWeight(rs.getString("weight"));
				player.setBirth(rs.getString("birth"));
				player.setAge(rs.getInt("age"));
				player.setExp(rs.getInt("exp"));
				player.setSchool(rs.getString("school"));
				player.setActionImgPath(rs.getString("actionimgpath"));
				player.setPortraitImgPath(rs.getString("portraitimgpath"));
				
				if(rs.getString("seasonsp") != null){
					String seasonSpListText = rs.getString("seasonsp");
					ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
					String[] splited = seasonSpListText.split("\\$");
					for(int i = 0; i < splited.length; i ++){
						spList.add(SinglePerformance.makeSP(splited[i]));
					}
					player.setSeasonSinglePerformance(spList);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return player;
	}

	@Override
	public ArrayList<PlayerPO> getAllPlayers() {
		
		ArrayList<PlayerPO> playerList = new ArrayList<PlayerPO>();
		String sql = "select name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath,seasonsp from nba.players";
		Connection conn = DBUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				PlayerPO player = new PlayerPO();
				player.setName(rs.getString("name"));
				player.setNumber(rs.getString("number"));
				player.setPosition(rs.getString("position"));
				player.setHeight(rs.getString("height"));
				player.setWeight(rs.getString("weight"));
				player.setBirth(rs.getString("birth"));
				player.setAge(rs.getInt("age"));
				player.setExp(rs.getInt("exp"));
				player.setSchool(rs.getString("school"));
				player.setActionImgPath(rs.getString("actionimgpath"));
				player.setPortraitImgPath(rs.getString("portraitimgpath"));
				
				if(rs.getString("seasonsp") != null){
					String seasonSpListText = rs.getString("seasonsp");
					ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
					String[] splited = seasonSpListText.split("\\$");
					for(int i = 0; i < splited.length; i ++){
						spList.add(SinglePerformance.makeSP(splited[i]));
					}
					player.setSeasonSinglePerformance(spList);
				}				
				
				playerList.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return playerList;
	}

}
