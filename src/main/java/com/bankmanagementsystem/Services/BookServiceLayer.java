package com.bankmanagementsystem.Services;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.BookNotFoundExceptions;
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

    /**
     Add Book Function
     Before adding the book, this method checks
     whether a book with same ID already exists or not in the Library.

     @param book the book to be added to the library
     @throws DuplicateBookException if a book with same
             ID already Exists

     @see Library
     @see com.bankmanagementsystem.Console.Main
     */

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

    /**

     Display all books.
     Here by using ShowAllBooks function we are able to see all books that are available in library
     @throws BookNotFoundExceptions if a book not available in the library

     @see Library
     @see com.bankmanagementsystem.Console.Main

     */

    public void showAllBooks() throws BookNotFoundExceptions {

        if (!library.getBooks().isEmpty()){
            for(Book book : library.getBooks()){
                book.displayBookInfo();
            }
        }else {
            throw new BookNotFoundExceptions("Book no available!");
        }

    }


}
