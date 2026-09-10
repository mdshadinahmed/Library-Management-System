package com.bankmanagementsystem.Exception;

import com.bankmanagementsystem.model.Book;

public class BookNotIssuedException extends Exception{

    public BookNotIssuedException(String message){
        super(message);
    }
}
