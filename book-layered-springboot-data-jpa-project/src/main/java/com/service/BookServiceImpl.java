package com.service;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Book;
import com.entity.BookPaySlip;
import com.persistence.BookDao;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public Book searchBookById(int id) {

		return bookDao.findById(id).orElse(null);

	}

	@Override
	public boolean addBook(Book book) {

		if (searchBookById(book.getBookId()) == null) {
			// save means : save and update
			bookDao.save(book);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		if (searchBookById(id) != null) {
			bookDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean incrementSalary(int id,double increment) {
		Book book=searchBookById(id);
		if(book!=null) {
			book.setNoOfCopies(book.getNoOfCopies()+increment);
			bookDao.save(book);
			return true;
		}
		return false;
	}

	/*
	 * Business Rule AllowanceA : 18% of salary AllowanceB : 12% of salary
	 * Dedeuction : 8% of salary
	 */
	@Override
	public BookPaySlip generatePaySlip(int bookId) {
		Book book=searchBookById(bookId);
		if(book!=null) {
			double allowanceA=.18*book.getNoOfCopies();
			double allowanceB=.12*book.getNoOfCopies();
			double deduction=.08*book.getNoOfCopies();
			double totalSalary=book.getNoOfCopies()+allowanceA+allowanceB-deduction;
			
			BookPaySlip bookPaySlip=new BookPaySlip(book, allowanceA, allowanceB, deduction,totalSalary);
			return bookPaySlip;
		}
		return null;

	}      
//
//	@Override
//	public List<Book> getBooksByDepartment(String bookName) {
//		
//		return bookDao.findByBookName(bookName);
//	}

}		