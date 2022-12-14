package org.example;

import java.util.List;

public class Person {
    String name;
    Integer age;
    Boolean passedExam;
    List<Integer> grades;

    public Person(String name, Integer age, Boolean passedExam, List<Integer> grades) {
        this.name = name;
        this.age = age;
        this.passedExam = passedExam;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getPassedExam() {
        return passedExam;
    }

    public void setPassedExam(Boolean passedExam) {
        this.passedExam = passedExam;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}
