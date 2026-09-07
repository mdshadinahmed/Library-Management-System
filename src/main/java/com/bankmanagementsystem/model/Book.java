package com.bankmanagementsystem.model;

public class Book {

    private int bookID;
    private String bookName;
    private String authorName;
    private double price;

    // Default Constructor to reduce constructor mismatch exception
    public Book(){
        super();
    }

    public Book(int bookID, String bookName, String authorName, double price){
        super();
        this.bookID = bookID;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
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
}
