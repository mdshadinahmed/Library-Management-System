package com.bankmanagementsystem.Exception;

public class BookAlreadyIssuedException extends RuntimeException {
  public BookAlreadyIssuedException(String message) {
    super(message);
  }
}
