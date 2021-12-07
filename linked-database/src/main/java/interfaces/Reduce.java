package interfaces;

import models.Student;

@FunctionalInterface
public interface Reduce {
    int reduce(int acumulator, Student student);
}
