package com.bankmanagementsystem.Services;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.BookAlreadyIssuedException;
import com.bankmanagementsystem.Exception.BookNotFoundExceptions;
import com.bankmanagementsystem.Exception.DuplicateBookException;
import com.bankmanagementsystem.Exception.StudentNotAvailableException;
import com.bankmanagementsystem.model.Book;
import com.bankmanagementsystem.model.Student;

import java.time.LocalDate;

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



    /**
     Issue Book From Library by using this method

     @author  Shadin Ahmed

     @throws BookNotFoundExceptions if book are not available in Library
     @throws StudentNotAvailableException if Student not available in Library
     @throws BookAlreadyIssuedException if the corresponding book issued by student
     then it will throw this exception

     @see Library
     @see StudentServiceLayer
     @see com.bankmanagementsystem.Console.Main
     */

    public void issueBook(int bookId, int studentId) throws BookNotFoundExceptions,
            StudentNotAvailableException, BookAlreadyIssuedException {

        // ===========================
        // Find  Book
        // ===========================

        Book findBook = null;

        for (Book book : library.getBooks()){

            if (book.getBookID() == bookId){
                findBook = book;
                break;
            }

        }

        if (findBook == null){
            throw new  BookNotFoundExceptions("Book not available in Library!");
        }

        // ===========================
        // Find  Student
        // ===========================

        Student findStudent = null;

        for (Student student : library.getStudents()){

            if (student.getStudentId() == studentId){
                findStudent = student;
                break;
            }

        }

        if (findStudent == null){
            throw  new StudentNotAvailableException("Student Not available in Library!");
        }


        // ===========================
        // Issue Student
        // ===========================

        if (findBook.isIssued()){
            throw new BookAlreadyIssuedException("Book Already Issued!");
        }

        findBook.setIssued(true);
        findBook.setIssuedStudentId(studentId);
        findBook.setIssueDate(LocalDate.now());
        System.out.println("Book Successfully Issued by :  \n" + findStudent.getName() +"\n" + findStudent.getStudentId()+
                                                        "\n"+findStudent.getDept());






    }



}
