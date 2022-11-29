package com.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Book;
import com.entity.BookPaySlip;
import com.service.BookService;


@Component("presentation")
public class BookPresentationImpl implements BookPresentation {

	@Autowired
	private BookService bookService;
	
    /**
     *
     */
    @Override
    public void showMenu() {
            System.out.println("===========================");
            System.out.println("Book Management System");
            System.out.println("1. List All Books");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Add New Book");
            System.out.println("4. Update Number of Copies *under construction*");
            System.out.println("5. Exit");
            System.out.println("============================");
            
    }
    
    @Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
                
		switch (choice) {
                    
		case 1:
			Collection<Book> books=bookService.getAllBooks();
			for(Book book:books) {
				System.out.println(book);
			}
			break;
                        
		case 2:
			System.out.println("Enter Book ID : ");
			int id=scanner.nextInt();
			Book book=bookService.searchBookById(id);
			if(book!=null)
				System.out.println(book);
			else
				System.out.println("Book with id "+id+" does not exist");
			break;
                        
                case 3:
			Book newBook = new Book();
			
			System.out.println("Enter Book id : ");
			newBook.setBookId(scanner.nextInt());
			System.out.println("Enter Book Name : ");
			newBook.setBookName(scanner.next());
                        System.out.println("Enter Author Name : ");
			newBook.setAuthorName(scanner.next());
                        System.out.println("Enter Number of Copies : ");
			newBook.setNoOfCopies(scanner.nextInt());
			
			if(bookService.addBook(newBook))
				System.out.println("Book Record Added");
			else
				System.out.println("Book with id "+newBook.getBookId()+" already exist, so cannot add it as a new book!");
			
			break;	
		case 4:
			System.out.println("Enter Book ID : ");
			int bookId=scanner.nextInt();
			BookPaySlip payslip=bookService.generatePaySlip(bookId);
			if(payslip!=null)
				System.out.println(payslip);
			else
				System.out.println("Book with id "+bookId+" does not exist!");
			break;
                        
                        
		case 5:
			System.out.println("Thanks for using Book Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}

	}

}
