package com.library.repository;

public class BookRepository{
	
	public void display() {
		System.out.println("Book repository!");
	}
	
	public void saveBook(String bookName) {
        System.out.println("Book '" + bookName + "' saved to the repository.");
    }
}