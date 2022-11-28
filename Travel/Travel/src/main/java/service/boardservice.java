package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DB;
import model.boardmodel;

public class boardservice 
{
	//게시판 전체 목록 가져오기 (김진홍)
	public  ArrayList<boardmodel> getlist( )
	{
		String sql = "SELECT * FROM board ";
		Connection conn=DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;  
		
		ArrayList<boardmodel>list= new ArrayList<boardmodel>();
		
		try
		{
            pstmt = conn.prepareStatement(sql);
           
            
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	boardmodel bm=new boardmodel();
            	bm.setListID(rs.getInt(1));
            	bm.setTitle(rs.getString(2));
            	bm.setUserID(rs.getString(3));
            	bm.setDate(rs.getDate(4));
            	bm.setContent(rs.getString(5));
            	list.add(bm);
            }
            
            
            return list;
           
        }		catch(SQLException e)
		{
			e.printStackTrace();
			return null;	//오류
		}
		finally {
			
			DB.close(conn,pstmt,rs);
		}
	
	}

	//게시판 검색 목록 가져오기 (김진홍)
	public  ArrayList<boardmodel> search(String title)
	{
		String sql = "SELECT * FROM board WHERE title LIKE ?";
		Connection conn=DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;  
		
		ArrayList<boardmodel>list= new ArrayList<boardmodel>();
		
		try
		{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+title+"%");
            
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	boardmodel bm=new boardmodel();
            	bm.setListID(rs.getInt(1));
            	bm.setTitle(rs.getString(2));
            	bm.setUserID(rs.getString(3));
            	bm.setDate(rs.getDate(4));
            	bm.setContent(rs.getString(5));
            	list.add(bm);
            }
            
        }catch(SQLException e)
		{
			e.printStackTrace();
			return null;	//오류
		}
		finally {
			
			DB.close(conn,pstmt,rs);
		}
		return list;
	}
	
	//게시판 상세 내용 가져오기 (김진홍)
	public boardmodel getdetail(int listid)
	{
		String sql = "SELECT * FROM board WHERE listID =? ";
		Connection conn=DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;  
		
	
		
		boardmodel bm=new boardmodel();
		try
		{
            pstmt = conn.prepareStatement(sql);
           
        	pstmt.setInt(1, listid);
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	bm.setListID(rs.getInt(1));
            	bm.setTitle(rs.getString(2));
            	bm.setUserID(rs.getString(3));
            	bm.setDate(rs.getDate(4));
            	bm.setContent(rs.getString(5));
            }
            
            
            return bm;
           
        }		catch(SQLException e)
		{
			e.printStackTrace();
			return null;	//오류
		}
		finally {
			
			DB.close(conn,pstmt,rs);
		}
		
		
	}

	//글쓰기(조윤주)
	public int insert(boardmodel bm) {
			
			int result = 0;
			String sql = "INSERT INTO BOARD(TITLE,USERID,DATE,CONTENT) VALUES(?,?,sysdate(),?)";
			
			try {
				Connection conn=DB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bm.getTitle());
				pstmt.setString(2, bm.getUserID());
				pstmt.setString(3, bm.getContent());
				
				
				result=pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return result;
			
			
		}
	
	//글삭제(조윤주)
	public int del(int listID) {
				
				String sql = "DELETE FROM board WHERE listID = ?";
				int result = 0;
				
				try {
					Connection conn=DB.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,listID);
					result=pstmt.executeUpdate();
					
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return result;
			} 

	//글수정(조윤주)
	public int update(boardmodel bm) {
		int result = 0;
		String sql = "UPDATE board SET userID=?, DATE=sysdate(),content=?  WHERE title = ? ";
		
		try {
			Connection conn=DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bm.getUserID());
			pstmt.setString(2, bm.getContent());
			pstmt.setString(3, bm.getTitle());
			
			
			
			result=pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//글수정시 원래 데이터 보여줌(조윤주)
	public boardmodel showupdate(String title)
	{
		String sql = "SELECT * FROM board WHERE title =? ";
		Connection conn=DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;  
		
	
		
		boardmodel bm=new boardmodel();
		try
		{
            pstmt = conn.prepareStatement(sql);
           
        	pstmt.setString(1, title);
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	bm.setTitle(rs.getString(2));
            	bm.setUserID(rs.getString(3));
            	bm.setContent(rs.getString(5));
            }
            
            
            return bm;
           
        }		catch(SQLException e)
		{
			e.printStackTrace();
			return null;	//오류
		}
		finally {
			
			DB.close(conn,pstmt,rs);
		}
	}
}
