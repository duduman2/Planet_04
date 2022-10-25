package board.dao.face;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BoardInfo;

public class BoardDao {
	
	private Connection conn;
	private ResultSet rs;
	
	public BoardDao() {
		
		try {
			String URL = "jdbc:oracle:thin:@localhost:1521:xe";
			String ID = "scott";
			String Password = "tiger";
//			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, ID, Password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 현재 시간을 가져오는 함수, 게시판의 글을 작성할 때 현재 서버의 시간을 넣어주는 역할
	public String getDate() {
		
		String SQL = "SELECT NOW()";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ""; // 데이터베이스 오류
	}
	
	// 게시글 번호는 하나씩 늘어나므로 마지막에 쓰인 글을 가져와서 +1을 하면 다음 번호가 된다 
	public int getNext() {
		
		String SQL = "SELECT UserID FROM Boardinfo ORDER BY UserID DESC";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1; // 데이터베이스 오류
	
	}
	
	
	// 실제로 글을 작성하는 함수
	public int write(String BoardTitle, String UserId, String BoardContent) {
		String SQL = "INSERT INTO BoardInfo VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, BoardTitle);
			pstmt.setString(3, UserId);
			pstmt.setString(4, getDate());
			pstmt.setString(5, BoardContent);
			pstmt.setInt(6, 1);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1; // 데이터베이스 오류
	}

	public ArrayList<BoardInfo> getlist(int pageNumber) {
       
		String SQL = "SELECT * FROM Boardinfo WHERE UserID < ? AND bbsAvailable = 1 ORDER BY UserID DESC LIMIT 10";
        
		ArrayList<BoardInfo> list = new ArrayList<BoardInfo>();
       
		try {
			
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                BoardInfo b = new BoardInfo();
                
                b.setBoardNo(rs.getInt(1));
                b.setBoardTitle(rs.getString(2));
                b.setUserId(rs.getString(3));
                b.setBoardDate(rs.getDate(4));
                b.setBoardContent(rs.getString(5));
                b.setBoardHit(rs.getInt(6));
               
                list.add(b);
           
            }
            
        } catch (Exception e) {
        
        	e.printStackTrace();

        }
        
        return list;
}
 
	public boolean nextPage(int pageNumber) {
        
		String SQL = "SELECT * FROM BoardInfo WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY UserID DESC LIMIT 10";
        
		try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true;
            }
            
        } catch (Exception e) {
         
        	e.printStackTrace();
        
        }
		
        return false;
}

	

}








































