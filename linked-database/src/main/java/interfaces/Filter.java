package interfaces;

import models.Student;

@FunctionalInterface
public interface Filter {
    Boolean validate(Student student);
}
