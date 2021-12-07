package utils;

import models.Student;
import repository.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoadRepository {
    final String FILE_NAME = "file.csv";

    public void load(Repository repository){
        FileReader fileReader = null;
        Scanner input = null;
        boolean error = false;

        try {
            fileReader = new FileReader(FILE_NAME);
            input = new Scanner(fileReader).useDelimiter(";|\\r\\n");

        }catch (FileNotFoundException e){
            System.err.println("File not found!");
            System.exit(1); // encerra o programa, com status de erro
        }

        try {
            while (input.hasNext()) {
                String ra = input.next();
                String name = input.next();
                String classRoom = input.next();

                Student newStudent = new Student(ra, name, classRoom);
                repository.save(newStudent);
            }
        } catch (NoSuchElementException er){
            System.err.println("File with problems");
            error = true;
        }
        catch (IllegalStateException er){
            System.err.println("Error reading the file");
            error = true;
        }
        finally {
            input.close();
            try {
                fileReader.close();
            }
            catch (IOException erro) {
                System.err.println("Error closing the file");
                error = true;
            }
            if (error) {
                System.exit(1);
            }
        }
    }
}
