package com.bankmanagementsystem.model;

public class Student {

    private int studentId;
    private String name;
    private String dept;
    private String phone;
    private String address;

    public Student(){
        super();
    }

    public Student(int studentId, String address, String phone, String dept, String name) {
        this.studentId = studentId;
        this.address = address;
        this.phone = phone;
        this.dept = dept;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayStudentInfo() {

        System.out.println("------------------------------");

        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + dept);
        System.out.println("Phone      : " + phone);
        System.out.println("Address    : " + address);

        System.out.println("------------------------------");
    }



}
