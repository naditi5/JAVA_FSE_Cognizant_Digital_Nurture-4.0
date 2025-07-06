package DigitalNurture.LibraryManagement;

import com.library.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookService = (BookService) context.getBean("bookService");
//		BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
//		bookRepository.display();
		bookService.addBook("Algorithms and Data Structures");
	}
	
}
    