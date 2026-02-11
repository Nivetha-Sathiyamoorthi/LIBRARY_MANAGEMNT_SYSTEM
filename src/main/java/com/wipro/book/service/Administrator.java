package com.wipro.book.service;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

public class Administrator {
	public String addBook(BookBean bookBean) {
		if(bookBean==null || bookBean.getBookName().isEmpty() ||bookBean.getCost()==0||bookBean.getBookType()!='G' && bookBean.getBookType()!='T')
			return "INVALID";
			if(bookBean.getIsbn().isEmpty() ||bookBean.getBookType()==' '||bookBean.getAuthor().getAuthorName().isEmpty())
			return "INVALID";
			
			BookDAO bookdao=new BookDAO();
			if(bookdao.createBook(bookBean)==1) {
				return "SUCCESS";
			}
			return "FAILURE";
		}
		public BookBean viewBook(String isbn) {
			BookDAO bookdao=new BookDAO();
			BookBean bookBean=bookdao.fetchBook(isbn);
			return bookBean;
		}
}