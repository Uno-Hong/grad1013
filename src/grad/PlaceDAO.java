package grad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	String dbId = "root";
	String dbPass = "Hh33906^";
	String PortNo = "3306";
	String DBName = "gjob";
	String TIMEZONE = "serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
	String jdbcUrl = "jdbc:mysql://localhost:" + PortNo + "/" + DBName + "?" + TIMEZONE ;
	
	public PlaceDAO()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int FileUpload(String place_imgloc) {
		String SQL = "INSERT INTO tb_place (place_etc) VALUES (?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  place_imgloc);
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void PlaceInfo(PlaceDTO place) {
	
		
		try{
			sql = "select place_name, place_addr, place_pn, place_lng, place_lat from tb_place";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
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
		
		
	} // end of placeInfo
	
	
	public boolean PlaceInsert(PlaceDTO placedto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			//conn.setAutoCommit(false);
			sql = "insert into tb_place(place_name, place_addr, place_pn, place_lng, place_lat, place_etc) values(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placedto.getPlace_name());
			pstmt.setString(2, placedto.getPlace_addr());
			pstmt.setString(3, placedto.getPlace_pn());
			pstmt.setFloat(4, placedto.getPlace_lng());
			pstmt.setFloat(5, placedto.getPlace_lat());
			pstmt.setString(6, placedto.getPlace_etc());
			
			
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
	} // end of placeInsert
	
	
	
	
	
}
