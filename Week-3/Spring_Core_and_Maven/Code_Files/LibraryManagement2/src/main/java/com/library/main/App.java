package com.library.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Test Book");
        context.close();
    }
}
