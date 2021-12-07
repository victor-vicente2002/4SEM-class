package models;

public class Student {
    String ra;
    String name;
    String className;

    public Student(String ra, String name, String className) {
        this.ra = ra;
        this.name = name;
        this.className = className;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
