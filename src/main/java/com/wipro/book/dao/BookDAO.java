package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.BookBean;
import com.wipro.book.util.DBUtil;

public class BookDAO {
	public int createBook(BookBean bookBean) {
		int status = 0;
		try {
			Connection con = DBUtil.getDBConnection();
			String sql = "INSERT INTO Book_tbl  VALUES (?,?,?,?,?)" ;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookBean.getIsbn());
			ps.setString(2, bookBean.getBookName());
			ps.setString(3, String.valueOf(bookBean.getBookType()));
			ps.setInt(4, bookBean.getAuthor().getAuthorCode()); 
			ps.setFloat(5, bookBean.getCost());
			status =  ps.executeUpdate();
			con.commit();
			} catch (Exception e) {
				 e.printStackTrace();
			
			}
		return status;
	}
public BookBean fetchBook(String isbn) {
	 BookBean bookbean = null;
	try {
		Connection con = DBUtil.getDBConnection();
	 String sql = "SELECT * FROM Book_tbl WHERE isbn = ?";
	 PreparedStatement ps = con.prepareStatement(sql);
	 ps.setString(1,isbn);
	 ResultSet rs = ps.executeQuery();
	 if(rs.next()) {
		 bookbean = new BookBean();
		 bookbean.setIsbn(rs.getString(1));
		 bookbean.setBookName(rs.getString(2));
         bookbean.setBookType(rs.getString(3).charAt(0));
		 bookbean.setAuthor(new AuthorDAO().getAuthor(rs.getInt(4)));
		 bookbean.setCost(rs.getFloat(5));
		 
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	return bookbean;
	 }
  }
