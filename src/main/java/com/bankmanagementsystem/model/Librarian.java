package com.bankmanagementsystem.model;

public class Librarian {

    private int librarianId;
    private String name;

    public Librarian(){
        super();
    }

    public Librarian(int librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayLibrarianInfo() {

        System.out.println("------------------------------");
        System.out.println("Librarian ID : " + librarianId);
        System.out.println("Name         : " + name);
        System.out.println("------------------------------");
    }
}
