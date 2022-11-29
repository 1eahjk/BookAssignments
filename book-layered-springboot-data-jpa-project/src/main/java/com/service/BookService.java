package com.service;

import java.util.Collection;
import java.util.List;

import com.entity.Book;
import com.entity.BookPaySlip;

public interface BookService {

	Collection<Book> getAllBooks();
	
	Book searchBookById(int id);
	
	boolean addBook(Book book);
	
	boolean deleteBook(int id);
	
	boolean incrementSalary(int id,double increment);
	
	BookPaySlip generatePaySlip(int bookId);
}
