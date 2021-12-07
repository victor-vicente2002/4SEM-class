package utils;

import models.Student;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {
    Node head;
    private int size;

    public DoubleLinkedList() {
        head = new Node(null);
        size = 0;
    }

    public DoubleLinkedList(Node selectedHead) {
        head = selectedHead;
    }

    public int getSize() {
        return size;
    }

    Node getHead(){ return this.head; }

    public void insert(Student value){
        Node node = new Node(value);
        Node next = head.getNext();
        if (next != null){
            head.getNext().setPrevious(node);
        }
        node.setPrevious(head);
        node.setNext(head.getNext());
        head.setNext(node);
        size++;
    }

    public boolean deleteNode(Student value){
        Node actual = head.getNext();
        while (actual != null) {
            if (actual.getInfo() == value) {
                Node previous = actual.getPrevious();
                Node next = actual.getNext();
                previous.setNext(next);
                next.setPrevious(previous);
                size--;
                return true;
            }else {
                actual = actual.getNext();
            }
        }
        return false;
    }

    public List<Student> returnAsList(){
        List<Student> returnedList = new ArrayList<>();
        Node actual = head.getNext();
        while (actual != null){
            returnedList.add(actual.getInfo());
            actual = actual.getNext();
        }

        return returnedList;
    }

    public Student findByRa(String value){
        Node actual= head.getNext();
        while (actual != null){
            Student student = actual.getInfo();
            System.out.println(student.getRa());
            System.out.println(value);
            if (value.equals(student.getRa())) {
                return student;
            }else{
                actual = actual.getNext();
            }
        }
        return null;
    }

    public List<Student> findByClassName(String className){
        Node actual= head.getNext();
        List<Student> studentsList = new ArrayList<>();
        while (actual.getNext() != null){
            Student student = actual.getInfo();
            if (student.getClassName().equals(className)) {
                studentsList.add(student);
            }else{
                actual = actual.getNext();
            }
        }
        return studentsList;
    }

    public void saveAll(List<Student> list){
        int index = 0;
        while (index < list.size()){
            insert(list.get(index));
            index++;
        }
    }

    public void deleteALl(){
        size = 0;
        head.setNext(null);
    }

    public boolean exists(Student obj){
        Node actual= head.getNext();
        while (actual.getNext() != null){
            if (actual.getInfo() == obj){
                return true;
            }else {
                actual = actual.getNext();
            }
        }
        return false;
    }

    public boolean existsByRa(String ra){
        Node actual= head.getNext();
        while (actual.getNext() != null){
            if (actual.getInfo().getRa() == ra){
                return true;
            }else {
                actual = actual.getNext();
            }
        }
        return false;
    }
}
