package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream().filter((x) -> x.getAverageGrade() == averageGrade).findFirst().orElse(null);
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students.stream().max(Comparator.comparing(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return students.stream().min(Comparator.comparing(Student::getAverageGrade)).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}