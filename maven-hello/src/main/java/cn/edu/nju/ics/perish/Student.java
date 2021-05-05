package cn.edu.nju.ics.perish;

public class Student {

    @Range(min = 10, max = 120)
    int age;

    @Range(min = 5, max = 10)
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
