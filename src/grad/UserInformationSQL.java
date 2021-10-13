package grad;

import java.sql.*;
import java.util.ArrayList;

public class UserInformationSQL {
	
	//濡쒓렇�씤
			public ArrayList<UserBean> AllUserSelect () {
				ArrayList<UserBean> lists = new ArrayList<UserBean>();
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql = null;
				
				try{
					String dbId = "root";
					String dbPass = "Hh33906^";
					String PortNo = "3306";
					String DBName = "gjob";
					String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
					
					String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
					
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
					conn.setAutoCommit(false);
					sql = "select * from tb_user;";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);
					
					while(rs.next())
					{
						UserBean userbean = new UserBean();
						userbean.setUser_id(rs.getString("user_id"));
						userbean.setUser_pw(rs.getString("user_pw"));
						userbean.setUser_name(rs.getString("user_name"));
						userbean.setUser_phone(rs.getString("user_phone"));
						userbean.setUser_reg(rs.getDate("user_reg"));
						userbean.setUser_man(rs.getInt("user_man"));
						
						lists.add(userbean);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(pstmt != null) {
						try{ pstmt.close(); }catch(SQLException sqle){ }
				}	
					if(conn != null) {
						try{ conn.close(); }catch(SQLException sqll){ }
					}
				}
				return lists;
			} // 
	
	//濡쒓렇�씤
		public boolean login (String id, String pw) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			boolean flag = false;
			
			try{
				String dbId = "root";
				String dbPass = "Hh33906^";
				String PortNo = "3306";
				String DBName = "gjob";
				String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
				
				String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
				conn.setAutoCommit(false);
				sql = "select user_id, user_pw from tb_user where user_id = '" + id + "' and user_pw = '" + pw + "'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				flag = rs.next();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(pstmt != null) {
					try{ pstmt.close(); }catch(SQLException sqle){ }
			}	
				if(conn != null) {
					try{ conn.close(); }catch(SQLException sqll){ }
				}
			}
			return flag;
		} // end of login
	
	//id 以묐났 �솗�씤
	public boolean idCheck (String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select user_id from tb_user where user_id = '" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			flag = rs.next();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return flag;
	} // end of idCheck
	
	//�쉶�썝媛��엯
	public boolean join(UserBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try{
			
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			//conn.setAutoCommit(false);
			sql = "insert into tb_user(user_id, user_pw, user_name, user_phone, user_reg) values(?, ?, ?, ?, now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getUser_id());
			pstmt.setString(2, bean.getUser_pw());
			pstmt.setString(3, bean.getUser_name());
			pstmt.setString(4, bean.getUser_phone());
			//pstmt.executeUpdate();
			
			int rs = pstmt.executeUpdate();
			if(rs==1) { flag = true;}
			
			
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return flag;
	} // end of join
	
	//�쉶�썝 �깉�눜
	public boolean userDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			//conn.setAutoCommit(false);
			sql = "delete from tb_user where user_id = '" + id + "'";
			
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.executeUpdate();
			
			int rs = pstmt.executeUpdate();
			if(rs==1) { flag = true;}
			
			
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return flag;
	} // end of userDelete
	
	//鍮꾨�踰덊샇 �솗�씤
	public String checkPw(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String pw = "";
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select user_pw from tb_user where user_id = '" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				pw = rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return pw;
	} // end of checkPw
	
	//鍮꾨�踰덊샇 蹂�寃�
	public boolean changePw(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "update tb_user set user_pw = '" + pw + "' where user_id = '" + id + "'";
			
			pstmt = conn.prepareStatement(sql);
			int rs = pstmt.executeUpdate();
			
			if(rs==1) { flag = true;}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return flag;
	} // end of changePw
	
	//�븘�씠�뵒 李얘린
	public String searchId(String name, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String id = "";
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select user_id from tb_user where user_name = '" + name + "'and user_phone = '" + phone + "'";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return id;
	} // end of searchId
	
	//鍮꾨�踰덊샇 李얘린
	public String searchPw(String id, String name, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String pw = "";
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select user_pw from tb_user where user_id = '" + id + "' and user_name = '" + name + "' and user_phone = '" + phone + "'";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				pw = rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return pw;
	} // end of searchId
	
	
	public String searchName(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String name = "";
		
		try{
			String dbId = "root";
			String dbPass = "Hh33906^";
			String PortNo = "3306";
			String DBName = "gjob";
			String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			
			String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select user_name from tb_user where user_id = '" + id + "';";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				name = rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return name;
	} // end of searchId
	
}
