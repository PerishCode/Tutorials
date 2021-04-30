package cn.edu.nju.ics.perish.java_lei;

public class Student {
    public String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Say() {
        System.out.println("My name is : " + name);
    }

    @Override
    public String toString() {
        return name + "," + age;
    }
}
