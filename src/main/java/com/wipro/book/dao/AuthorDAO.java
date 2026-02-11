package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

public class AuthorDAO {
	public AuthorBean getAuthor(int authorCode) {
		 AuthorBean author = null;
		try {
		            Connection con = DBUtil.getDBConnection();
		            String sql = "SELECT * FROM Author_tbl WHERE Author_code = ?";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setInt(1, authorCode);
		            ResultSet rs = ps.executeQuery();
		          if (rs.next()) {
		                author = new AuthorBean();
		                author.setAuthorCode(rs.getInt("Author_code"));
		                author.setAuthorName(rs.getString("Author_name"));
		                author.setContactNo(rs.getLong("Contact_no"));    
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		        return author; 
		    }
	public AuthorBean getAuthor(String authorName) {
		 AuthorBean author = null;
		try {
		            Connection con = DBUtil.getDBConnection();
		            String sql = "SELECT * FROM Author_tbl WHERE Author_name = ?";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1,authorName );
		            ResultSet rs = ps.executeQuery();
		          if (rs.next()) {
		                author = new AuthorBean();
		                author.setAuthorCode(rs.getInt("Author_code"));
		                author.setAuthorName(rs.getString("Author_name"));
		                author.setContactNo(rs.getLong("Contact_no"));    
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		        return author; 
		    }
	}
