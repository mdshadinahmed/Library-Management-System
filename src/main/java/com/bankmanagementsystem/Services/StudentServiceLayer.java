package com.bankmanagementsystem.Services;

import com.bankmanagementsystem.Database.Library;
import com.bankmanagementsystem.Exception.DuplicateStudentFoundException;
import com.bankmanagementsystem.Exception.StudentNotFoundException;
import com.bankmanagementsystem.model.Student;

public class StudentServiceLayer {

    private Library library;

    /**
     *
     * Default constructor to reduce mismatch Exception
     */

    public StudentServiceLayer(){
        super();
    }

    public StudentServiceLayer(Library library){
        this.library = library;
    }

    /**
     *
     * @register_Student
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
     *
     * @Find_Student
     */

    public void findStudent(int studentId) throws StudentNotFoundException {

        Student isFound = null;

        for (Student existingStudent : library.getStudents()){
            if (existingStudent.getStudentId() == studentId){
                isFound = existingStudent;
                break;
            }
        }


        /**
         * @Found_Condition
         */

        if (isFound != null){
            isFound.displayStudentInfo();
        }else {
            throw  new StudentNotFoundException("Student Not Found!");
        }


    }



}

