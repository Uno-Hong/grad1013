package grad;

import java.sql.*;
import java.util.ArrayList;

public class CsDAO {
	
	//?옉?꽦?씪?옄 硫붿냼?뱶
	public String getDate() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select now()";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return "";
	}
	
	//寃뚯떆湲? 踰덊샇 遺??뿬 硫붿냼?뱶
	public int getNext() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select cs_number from tb_cs order by cs_number desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //泥ル쾲吏? 寃뚯떆臾쇱씤 寃쎌슦
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return -1; //?뜲?씠?꽣踰좎씠?뒪 ?삤瑜?
	}
	
	//湲??벐湲? 硫붿냼?뱶
	public int write(CsDTO cs) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			//conn.setAutoCommit(false);
			sql = "insert into tb_cs values(?, ?, ?, ?, now(), null,  ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, cs.getCs_title());
			pstmt.setString(3, cs.getCs_id());
			pstmt.setString(4, cs.getCs_article());
			pstmt.setInt(5, cs.getCs_state());
			//System.out.println(pstmt.executeUpdate());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try{ pstmt.close(); }catch(SQLException sqle){ }
		}	
			if(conn != null) {
				try{ conn.close(); }catch(SQLException sqll){ }
			}
		}
		return -1; //?뜲?씠?꽣踰좎씠?뒪 ?삤瑜?
	}
	
	//寃뚯떆湲? 由ъ뒪?듃 硫붿냼?뱶
	public ArrayList<CsDTO> getList(int pageNumber){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ArrayList<CsDTO> list = new ArrayList<CsDTO>();
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select * from tb_cs where cs_number < ? order by cs_number desc limit 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CsDTO csDTO = new CsDTO();
				csDTO.setCs_number(rs.getInt(1));
				csDTO.setCs_title(rs.getString(2));
				csDTO.setCs_id(rs.getString(3));
				csDTO.setCs_article(rs.getString(4));
				csDTO.setCs_date(rs.getString(5));
				csDTO.setCs_answer(rs.getString(5));
				csDTO.setCs_state(rs.getInt(6));
				list.add(csDTO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//?럹?씠吏? 泥섎━ 硫붿냼?뱶
	public boolean nextPage(int pageNumber) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "select * from tb_cs user_id < ? and available = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	//寃뚯떆湲? 蹂대뒗 硫붿냼?뱶
	public CsDTO getCs(int cs_number) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			
			sql = "select * from tb_cs where cs_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				CsDTO csDTO = new CsDTO();
				csDTO.setCs_number(rs.getInt(1));
				csDTO.setCs_title(rs.getString(2));
				csDTO.setCs_id(rs.getString(3));
				csDTO.setCs_article(rs.getString(4));
				csDTO.setCs_date(rs.getString(5));
				csDTO.setCs_answer(rs.getString(6));
				csDTO.setCs_state(rs.getInt(7));
				return csDTO;
				
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int update(int cs_number, String cs_title, String cs_article) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			sql = "update tb_cs set cs_number = ?, cs_title = ? where cs_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs_title);
			pstmt.setString(2, cs_article);
			pstmt.setInt(3, cs_number);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1; 
	}
	
	public int delete(int cs_number) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/wdyl?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
			String dbId = "root";
			String dbPass = "1234";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
			conn.setAutoCommit(false);
			//?떎?젣 ?뜲?씠?꽣瑜? ?궘?젣?븯?뒗寃? ?븘?땲?씪 寃뚯떆湲? ?쑀?슚?닽?옄瑜? '0'?쑝濡? ?닔?젙
			sql = "update tb_cs set available = 0 where cs_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cs_number);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1; //?뜲?씠?꽣踰좎씠?뒪 ?삤瑜?
	}
}
