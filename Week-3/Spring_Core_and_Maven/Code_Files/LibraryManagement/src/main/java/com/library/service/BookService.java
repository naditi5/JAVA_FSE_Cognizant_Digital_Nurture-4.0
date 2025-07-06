package com.library.service;
import com.library.repository.*;

public class BookService{
	private BookRepository bookRepository;
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void display() {
		System.out.println("Book Service!");
		bookRepository.display();
	}
	
	public void addBook(String name) {
        System.out.println("Adding book: " + name);
        bookRepository.saveBook(name);
    }
}