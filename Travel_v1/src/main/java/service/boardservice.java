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
            pstmt.setString(1, title);
            
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
}
