package model;

import java.util.Date;

public class boardmodel 
{
	private int listID;
	private String title;
	private String userID;
	private Date date;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getListID() {
		return listID;
	}
	public void setListID(int listID) {
		this.listID = listID;
	}

	
	
}
