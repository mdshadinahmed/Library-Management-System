package com.bankmanagementsystem.Console;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.BookNotFoundExceptions;
import com.bankmanagementsystem.Exception.DuplicateBookException;
import com.bankmanagementsystem.Exception.DuplicateStudentFoundException;
import com.bankmanagementsystem.Services.BookServiceLayer;
import com.bankmanagementsystem.Services.StudentServiceLayer;
import com.bankmanagementsystem.model.Book;
import com.bankmanagementsystem.model.Student;

import java.rmi.StubNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);


        /**
         * Create Library Object
         * ***************************************************************
         * Create Library Here to share the same library for every service
         */


        Library library = new Library();

        /**
         * Create Service Classes and send library object
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
            out.println("2. Show All Students");
            out.println("3. Register Student");
            out.println("4. Issue Book");
            out.println("5. Return Book");
            out.println("6. Search Book");
            out.println("7. Show Available Books");
            out.println("8. Show Issued Books");
            out.println("9. Calculate Fine");
            out.println("10. Remove Book");
            out.println("11. Show All Books");
            out.println("12. Exits From Library");



            try{

                out.println("Enter Your Choice");
                int choice = scanner.nextInt();

                /**
                 *
                 * Check Validation
                 */

                if (choice>12 || choice<=0){
                    out.println("Choice should be 1-12");
                }

                switch (choice){

                    /**
                     *
                     * 1. Add Book
                     * Add a new book to the library collections  by using BookService Class Function
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

                        /**
                         *
                         * 2. See All Books
                         * See All books from library collections  by using BookService Class Function
                         */

                    case 2:
                        try{
                             bookServiceLayer.showAllBooks();
                        }catch (BookNotFoundExceptions e){
                            out.println("Error : " + e.getMessage());
                        }
                        break;

                    /**
                     *
                     * 1. See All Books
                     * See All books from library collections  by using BookService Class Function
                     */

                    case 3:


                        out.println("Enter Student ID: ");
                        int id = scanner.nextInt();

                        /**
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





                }

            }catch (InputMismatchException e){
                out.println("Error : " + e.getMessage());
                scanner.nextLine();

            }






        }




    }
}