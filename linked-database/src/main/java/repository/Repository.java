package repository;

import models.Student;
import utils.DoubleLinkedList;

import java.util.List;

public class Repository {

    DoubleLinkedList studentsList = new DoubleLinkedList();

    public List<Student> findAll(){
        return studentsList.returnAsList();
    }
    Student findByRa(String ra){
        Student student = studentsList.findByRa(ra);
        if (student == null){
            throw new IllegalArgumentException("models.Student does not exists");
        }
        return student;
    }

    List<Student>findByClassName(String className){
        return studentsList.findByClassName(className);
    }
    void saveAll(List<Student> students){
        studentsList.saveAll(students);
    }
    public void save(Student student){
        studentsList.insert(student);
    }
    void deleteAll(){
        studentsList.deleteALl();
    }
    void delete(Student student){
        studentsList.deleteNode(student);
    }
    int count(){
        return studentsList.getSize();
    }
    boolean exists(Student student){
        return studentsList.exists(student);
    }
    boolean existsByRa(String ra){
        return studentsList.existsByRa(ra);
    }
}
