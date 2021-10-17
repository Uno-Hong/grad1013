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
	
	
	public boolean PlaceFileInsert(PlaceFileDTO placefiledto, int place_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			sql = "insert into tb_place_img(place_id, place_img_name, place_img_origin, place_img_size) values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, place_id);
			pstmt.setString(2, placefiledto.getPlace_img_name());
			pstmt.setString(3, placefiledto.getPlace_img_origin());
			pstmt.setLong(4, placefiledto.getPlace_img_size());
			
			int rs = pstmt.executeUpdate();
			System.out.println(rs);
			if(rs==1) 
			{ 
				flag = true;
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
		return flag;
	} // end of placeFileInsert
	
	public int PlaceInsert(PlaceDTO placedto) {
		Connection conn = null;
		Connection conn1 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String sql = null;
		int id = 0;

		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			
			//conn.setAutoCommit(false);
			sql = "insert into tb_place(place_name, place_addr, place_pn, place_lng, place_lat) values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, placedto.getPlace_name());
			pstmt.setString(2, placedto.getPlace_addr());
			pstmt.setString(3, placedto.getPlace_pn());
			pstmt.setFloat(4, placedto.getPlace_lng());
			pstmt.setFloat(5, placedto.getPlace_lat());
			
			
			//pstmt.executeUpdate();
			
			pstmt.executeUpdate();
			
			
			sql = "select place_id from tb_place where place_lng = ? and place_lat = ? and place_name = ? and place_addr = ? and place_pn = ?";
			
			conn1 = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			pstmt1 = conn1.prepareStatement(sql);
			pstmt1.setFloat(1, placedto.getPlace_lng());
			pstmt1.setFloat(2, placedto.getPlace_lat());
			pstmt1.setString(3, placedto.getPlace_name());
			pstmt1.setString(4, placedto.getPlace_addr());
			pstmt1.setString(5, placedto.getPlace_pn());
			rs = pstmt1.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
		
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt1 != null || pstmt != null) {
				try{ pstmt1.close(); pstmt.close();}catch(SQLException sqle){ }
		}	
			if(conn1 != null || pstmt != null) {
				try{ conn1.close(); conn.close();}catch(SQLException sqll){ }
			}
		}
		return id;
	} // end of placeInsert
	
	
	
	
	
}
