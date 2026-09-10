package com.bankmanagementsystem.Database;

import com.bankmanagementsystem.model.Book;
import com.bankmanagementsystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Student> students;

    public Library(){

        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book books) {
        this.books.add(books);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(List<Student> students) {
        this.students = students;
    }
}
