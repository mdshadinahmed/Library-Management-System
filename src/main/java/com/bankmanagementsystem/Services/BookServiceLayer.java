package com.bankmanagementsystem.Services;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.DuplicateBookException;
import com.bankmanagementsystem.model.Book;

public class BookServiceLayer {

    private Library library;


    public BookServiceLayer(){
        super();
    }

    public BookServiceLayer(Library library){
        super();
        this.library = library;

    }

    //===============================================
    // Add Book Function
    //===============================================
    public void addBook(Book book) throws DuplicateBookException {

        for (Book exitingBook : library.getBooks()){
            if (book.getBookID() == exitingBook.getBookID()){
                throw new DuplicateBookException(
                        "Book already exists!"
                );
            }
        }
        library.addBook(book);
        System.out.println("Book Successfully Added!!");

    }


}
