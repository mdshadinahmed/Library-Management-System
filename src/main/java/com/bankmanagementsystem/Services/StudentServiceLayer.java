package com.bankmanagementsystem.Services;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.DuplicateStudentFoundException;
import com.bankmanagementsystem.Exception.StudentNotFoundException;
import com.bankmanagementsystem.model.Student;


/**

 Service layer responsible for managing student-related operations
 in the Library Management System.

 <p>This class acts as an intermediate layer between the console
 interface and the {@link Library} data store. It handles operations
 such as registering students, finding students, and displaying
 all registered students.</p>

 <p>The service layer also performs validation and throws custom
 exceptions when a student already exists or cannot be found.</p>

 @author MD SHADIN AHMED
 @version 1.0
 @since 1.0

 */



public class StudentServiceLayer {

    private Library library;

    /**

     Default constructor to reduce mismatch Exception

     */

    public StudentServiceLayer(){
        super();
    }

    public StudentServiceLayer(Library library){
        this.library = library;
    }



    /**
     Registers a new student in the library.
     already exists before adding the student to the library.</p>

     @param student the student to be registered
     @throws DuplicateStudentFoundException if a student with
     the same ID already exists

     @see Library
     @see com.bankmanagementsystem.Console.Main
     */

    public void registerStudent(Student student) throws DuplicateStudentFoundException {

        for (Student exitingStudents : library.getStudents()){
            if (exitingStudents.getStudentId() ==
                           student.getStudentId()){
                throw new DuplicateStudentFoundException("Student Already Available!");
            }
        }
        library.addStudents(student);
        System.out.println("Student Successfully Register.");
    }

    /**
     Find a student by their id from the Library

     @param studentId the student will be found
     @throws StudentNotFoundException if a specific student not found in Library

     @see Library
     @see com.bankmanagementsystem.Console.Main
     */

    public void findStudent(int studentId) throws StudentNotFoundException {

        Student isFound = null;

        for (Student existingStudent : library.getStudents()){
            if (existingStudent.getStudentId() == studentId){
                isFound = existingStudent;
                break;
            }
        }


        // Found Student display to the user

        if (isFound != null){
            isFound.displayStudentInfo();
        }else {
            throw  new StudentNotFoundException("Student Not Found!");
        }


    }


    /**
     See All Student From Library by using this method

     @author  Shadin Ahmed
     @throws StudentNotFoundException if Student not available in Library

     @see Library
     @see com.bankmanagementsystem.Console.Main
     */

    public void showAllStudent() throws StudentNotFoundException{

        if (library.getStudents().isEmpty()){
            throw new StudentNotFoundException("Student Not Available!");
        }

        int count = 0;
        System.out.println("Student List : ");
        for (Student student : library.getStudents()){
            System.out.println("Student : " + count++);
            student.displayStudentInfo();
        }

    }


}

