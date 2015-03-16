package jdbc_tools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDatabase {

	public static void main(String[] args) {
		Connection conn = DBUtil.open();
		
		String sql = "source ~puppy/desktop/tm_sharetime.sql";
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);	
		
	}

}
