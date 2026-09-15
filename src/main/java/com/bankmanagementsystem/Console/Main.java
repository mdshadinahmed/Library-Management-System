package com.bankmanagementsystem.Console;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.*;
import com.bankmanagementsystem.Services.BookServiceLayer;
import com.bankmanagementsystem.Services.StudentServiceLayer;
import com.bankmanagementsystem.model.Book;
import com.bankmanagementsystem.model.Student;
//import com.bankmanagementsystem.model.StudentNotFoundException;
import java.rmi.StubNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.*;

/**

 ================================================================
 LIBRARY MANAGEMENT SYSTEM
 ================================================================


 Main Class


 This class serves as the entry point of the Library Management System.
 It provides the console-based user interface and handles user input
 for different library operations.


 Responsibilities:


 Display the main menu


 Accept user input


 Manage book-related operations


 Manage student-related operations


 Connect Service Layer with the console interface


 Handle user input validation and exceptions


 Architecture:
 Console → Service Layer → Library (Database)


 @author MD SHADIN AHMED
 @version 1.0
 @since 1.0
 */



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);


        /*
          Create Library Object
          ***************************************************************
          Create Library Here to share the same library for every service

          @see Library
          @see BookServiceLayer
          @see StudentServiceLayer
         */


        Library library = new Library();

        /*
          Create Service Classes and send library object
         */

        BookServiceLayer bookServiceLayer =
                new BookServiceLayer(library);

        StudentServiceLayer studentServiceLayer =
                new StudentServiceLayer(library);




        while (true){

            out.println();
            out.println("=============================");
            out.println("Library Management System");
            out.println("=============================\n");

            out.println("1. Add Book");
            out.println("2. Show All Books");
            out.println("3. Register Student");
            out.println("4. Show All Student");
            out.println("5. Issue Book");
            out.println("6. Return Book");
            out.println("7. Search Book");
            out.println("8. Show Available Books");
            out.println("9. Show Issued Books");
            out.println("10. Calculate Fine");
            out.println("11. Remove Book");
            out.println("12. Show All Books");
            out.println("13. Exits From Library");



            try{

                out.println("Enter Your Choice");
                int choice = scanner.nextInt();

                /*
                   Check Validation
                 */

                if (choice>12 || choice<=0){
                    out.println("Choice should be 1-12");
                }

                switch (choice){

                    /*
                     * 1. Add Book
                     *
                     *    Collects book information from the user and creates a new
                     *    Book object with the provided details.
                     *
                     *    The Book object is then passed to BookServiceLayer to be
                     *    added to the shared Library collection.
                     *
                     *    DuplicateBookException is handled to prevent adding a book
                     *    with an ID that already exists in the library.
                     */

                    case 1:
                        try{
                        out.println("Enter Book Id : ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        out.println("Enter Book Name : ");
                        String bookname = scanner.nextLine();
                        out.println("Author Name : ");
                        String bookAuthorName = scanner.nextLine();
                        out.println("Enter Category");
                        String category = scanner.nextLine();

                        out.println("Enter Book Price : ");
                        double price = scanner.nextDouble();

                        Book book = new Book(bookId,bookname, bookAuthorName,
                                category,price);

                            bookServiceLayer.addBook(book);
                        }catch (DuplicateBookException e){
                            out.println("Error : " + e.getMessage());
                        }catch (Exception e){
                            out.println("Error : " + e.getMessage());
                        }
                        break;
                    /*
                     * 2. View All Books
                     *
                     *    Displays all books currently available in the shared Library
                     *    collection by using the BookServiceLayer.
                     *
                     *    BookNotFoundExceptions is handled when no book is available
                     *    in the library collection.
                     */

                    case 2:
                        try{
                             bookServiceLayer.showAllBooks();
                        }catch (BookNotFoundExceptions e){
                            out.println("Error : " + e.getMessage());
                        }
                        break;

                    /*
                     * 3. Register Student
                     *
                     *    Collects student information from the user and creates a new
                     *    Student object with the provided details.
                     *
                     *    The Student object is then passed to StudentServiceLayer for
                     *    registration in the shared Library collection.
                     *
                     *    DuplicateStudentFoundException is handled to prevent registering
                     *    a student with an ID that already exists in the library.
                     */

                    case 3:

                        out.println("Enter Student ID: ");
                        int id = scanner.nextInt();

                        /*
                         * Buffer Clear
                         */
                        scanner.nextLine();

                        out.println("Enter Student Name : ");
                        String name = scanner.nextLine();

                        out.println("Enter Student Dept. : ");
                        String dept = scanner.nextLine();

                        out.println("Enter Student Phone : ");
                        String phone = scanner.nextLine();

                        out.println("Enter Student Address : ");
                        String address = scanner.nextLine();


                        try{
                            studentServiceLayer.registerStudent(new Student(id,name,dept,phone,address));
                        }catch (DuplicateStudentFoundException e){
                            out.println("Error : "+e.getMessage());
                        }
                        break;

                    /*
                     * 4. View All Students
                     *
                     *    Displays all registered students from the library collection
                     *    by using the StudentServiceLayer.
                     *
                     *    If no student is available, StudentNotAvailableException
                     *    is handled and an appropriate error message is displayed.
                     */

                    case 4:

                        try{
                            studentServiceLayer.showAllStudent();
                        }catch (StudentNotAvailableException e){
                            out.println("Error : " + e.getMessage());
                        }
                        break;

                    /*
                     * 5. Issue Book
                     *
                     *    Issue a selected book to a registered student by using the
                     *    BookServiceLayer. The user is required to provide both the
                     *    Book ID and Student ID.
                     *
                     *    The operation may fail if:
                     *      - The specified book does not exist.
                     *      - The specified student is not available.
                     *      - The book has already been issued.
                     *
                     *    Each expected exception is handled separately to display a
                     *    meaningful error message to the user. A general Exception
                     *    handler is also included to handle any unexpected errors.
                     */
                    case 5:

                        out.println("Enter Book Id : ");
                        int bookId = scanner.nextInt();

                        out.println("Enter Student Id : ");
                        int studentId = scanner.nextInt();

                        try {
                            bookServiceLayer.issueBook(bookId, studentId);
                        }catch (BookNotFoundExceptions e){
                            out.println("Error : " + e.getMessage());
                        }catch (StudentNotAvailableException e){
                            out.println("Error : "  + e.getMessage());
                        }catch (BookAlreadyIssuedException e){
                            out.println("Error : " + e.getMessage());
                        }catch (Exception e){
                            out.println("Error : " + e.getMessage());
                        }

                        break;


                    /*
                     * 6. Return Book
                     *
                     *    Issue a selected book to a registered student by using the
                     *    BookServiceLayer. And also to return a book a student only can provide bookId, but I take StudentId also
                     *    The user is required to provide both the
                     *    Book ID and Student ID to return a book.
                     *
                     *    The operation may fail if:
                     *      - The specified book does not exist.
                     *      - The specified student is not available.
                     *      - The book not issued yet.
                     *
                     *    Each expected exception is handled separately to display a
                     *    meaningful error message to the user. A general Exception
                     *    handler is also included to handle any unexpected errors.
                     */


                    case 6:

                        out.println("Enter Return Book Id : ");
                        int returnBoookId = scanner.nextInt();
                        out.println("Enter Return Student Id : ");
                        int returnStudentID = scanner.nextInt();

                        try {
                            bookServiceLayer.returnBook(returnBoookId, returnStudentID);
                        }catch (BookNotFoundExceptions e){
                            out.println("Error : " + e.getMessage());
                        }catch (StudentNotAvailableException e){
                            out.println("Error : " + e.getMessage());
                        }catch (BookNotIssuedException e){
                            out.println("Error : " + e.getMessage());
                        }
                        break;


                }

            }catch (InputMismatchException e){
                out.println("Error : " + e.getMessage());
                scanner.nextLine();

            }






        }




    }
}