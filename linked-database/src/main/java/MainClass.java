import models.Student;
import repository.Repository;
import utils.LoadRepository;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        LoadRepository loadRepository = new LoadRepository();
        Repository repository = new Repository();

        loadRepository.load(repository);
        List<Student> list = repository.findAll();

        for (Student student : list) {
            System.out.println(student.getName());
        }


    }
}
