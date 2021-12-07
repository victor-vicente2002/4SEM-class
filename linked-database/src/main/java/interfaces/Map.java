package interfaces;

import models.Student;

@FunctionalInterface
public interface Map {
    Student execute(Student value);
}
