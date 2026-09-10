package com.bankmanagementsystem.model;

import java.time.LocalDate;

public class Book {

    private int bookID;
    private String bookName;
    private String authorName;
    private String category;
    private double price;


    private boolean issued;
    private int issuedStudentId;
    private LocalDate issueDate;

    // Default Constructor to reduce constructor mismatch exception
    public Book(){
        super();
    }




    public Book(int bookID, String bookName, String authorName, String category, double price ){
        super();
        this.bookID = bookID;
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.price = price;


        this.issued = false;
        this.issueDate = null;
        this.issuedStudentId = 0;
    }

    // getter setter


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // to String method

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}' + "\n";
    }

    public void displayBookInfo(){

        System.out.println("--------------------------------");

        System.out.println("Book ID         : " + bookID);
        System.out.println("Boon Name       : " + bookName);
        System.out.println("Author Name     : " + authorName);
        System.out.println("Book Category   : " + category);
        System.out.println("Book Price      : " + price);

        if (issued){

            System.out.println("Status      : Issued");
            System.out.println("Student ID  : " + issuedStudentId);
            System.out.println("Issued Data : " + issueDate);

        }else {
            System.out.println("Status      : Available");
        }

        System.out.println("--------------------------------");
    }
}
