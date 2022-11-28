package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DB;
import model.boardmodel;
import model.usermodel;


public class userservice {

	//회원가입 (최민성)
	public int Signup(usermodel model)
	{
		String sql = "INSERT INTO user VALUES (?,?,?,?,?)";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		try
		{    
            pstmt = conn.prepareStatement(sql);        
            
            pstmt.setString(1, model.getId());
            pstmt.setString(2, model.getPwd());
            pstmt.setString(3, model.getName());
            pstmt.setDate(4, model.getDate());
            pstmt.setString(5, model.getGender());

            if(pstmt.executeUpdate() !=1)
            {
                return 0;		
            }
            return 1;			
        }
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;			
		}   
		finally 
		{	
			DB.close(conn,pstmt);
		}
    }
	
	//비밀번호 변경 (손유림)
	public int Updatepwd(String uppwd, String id)
	{
		String sql = "UPDATE user set password = ? where id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt = conn.prepareStatement(sql);
			
            pstmt.setString(1, uppwd);
            pstmt.setString(2, id);
            
            if(pstmt.executeUpdate() !=1)
            {
                return 0;		
            }       
            return 1;			
        }
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;			
		}  
		finally 
		{	
			DB.close(conn,pstmt);
		}
	}
	
	//비밀번호 확인 (손유림)
	public int Checkpwd(String pwd, String id)
	{	
		String sql = "SELECT password from user where id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		 
		try
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
            if (rs.next()) 
            {
            	if(rs.getString(1).equals(pwd))
            		return 1;
                else
             	   return 0;	 //비밀번호 불일치
             } 
             return -1;	//비밀번호 없음
        }
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		} 
		finally 
		{	
			DB.close(conn, pstmt, rs);
		}
	}
	
	//회원 삭제 (손유림)
	public int Deleteuser(String pwd)
	{
		String sql = "DELETE FROM user where password = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		
		try
		{
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setString(1, pwd);
            
            if(pstmt.executeUpdate() !=1)
            {
                return 0;	
            }       
            return 1;
        }
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}  
	}
	
	//회원 정보 불러오기 (손유림)
	public usermodel Selectuser(String id) 
	{
		String sql = "SELECT * FROM user where id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		usermodel user = new usermodel();
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); 
			
			while (rs.next()) 
			{ 			
				user.setId(rs.getString(1));		//id
				user.setPwd(rs.getString(2));		//password
				user.setName(rs.getString(3));		//name
				user.setDate(rs.getDate(4));		//birth
				user.setGender(rs.getString(5));	//gender
			}
			
			return user;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally 
		{
			DB.close(conn, pstmt, rs);
		}
	}
	
	//로그인(최민성)
	public  int findbyuserid(usermodel model)
	{
		String sql = "SELECT password FROM user WHERE id = ?";
		Connection conn=DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;  
		
		try
		{
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setString(1, model.getId());
            
            rs = pstmt.executeQuery();
            if (rs.next()) 
            {
               if (rs.getString(1).equals(model.getPwd()))
            	   return 1;		//로그인 성공
               else
            	   return 0;	//비밀번호 불일치
            } 
            return -1;	//아이디가 없음
        }
		catch(SQLException e)
		{
			e.printStackTrace();
			return -2;	//오류
		}
		finally 
		{	
			DB.close(conn,pstmt,rs);
		}
	
	}

	//내가 쓴 글 목록 가져오기(손유림)
	public  ArrayList<boardmodel> mywriting(String id)
		{
			String sql = "SELECT * FROM board where userId = ? ";
			Connection conn=DB.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;  
			
			ArrayList<boardmodel> list = new ArrayList<boardmodel>();
			
			try
			{
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            
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
	           
	        }		
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;	//오류
			}
			finally 
			{
				DB.close(conn,pstmt,rs);
			}
		}
		
	//내가 쓴 글 자세히 가져오기(손유림)
	public  boardmodel detailborad(String title)
		{
			String sql = "SELECT * FROM board where title = ?";
			Connection conn=DB.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;  
			
			boardmodel board = new boardmodel();
			
			try 
			{
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, title);
				
				rs = pstmt.executeQuery(); 
				
				while (rs.next()) 
				{ 			
					board.setListID(rs.getInt(1));			//ListID
					board.setTitle(rs.getString(2));		//Title
					board.setDate(rs.getDate(4));			//Date
					board.setContent(rs.getString(5));		//Content
				}
				
				return board;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			} 
			finally 
			{
				DB.close(conn, pstmt, rs);
			}
		}
}
