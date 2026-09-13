package com.bankmanagementsystem.Exception;

import com.bankmanagementsystem.model.Book;

public class BookNotIssuedException extends RuntimeException{

    public BookNotIssuedException(String message){
        super(message);
    }
}
