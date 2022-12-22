package com.example.class3demo2.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }
    private Model(){
        for(int i=0;i<8;i++){
            addStudent(new Student("name " + i,""+i,"",false, "number","address" ));
        }
    }

    List<Student> data = new LinkedList<>();
    public List<Student> getAllStudents(){
        return data;
    }

    public Student getStudent(int pos){
        return data.get(pos);
    }

    public void addStudent(Student st){
        data.add(st);
    }

    public void deleteStudent(int pos){
        data.remove(pos);
    }
    public void addStudentInPos(Student st, int pos){
        data.add(pos,st);
    }



}
