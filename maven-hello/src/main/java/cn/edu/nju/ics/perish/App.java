package cn.edu.nju.ics.perish;

import java.lang.reflect.Field;

/**
 * Hello world!
 *
 */
public class App {

    static boolean check(Student student) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : Student.class.getDeclaredFields()) {
            Range range = field.getAnnotation(Range.class);

            if (range == null)
                continue;

            Object source = field.get(student);

            switch (source.getClass().getName()) {
                case "java.lang.Integer": {
                    int value = (Integer) source;
                    if (value < range.min() || value > range.max())
                        return false;
                    break;
                }
                case "java.lang.String": {
                    int length = ((String) source).length();
                    System.out.println("length: " + length);
                    if (length < range.min() || length > range.max())
                        return false;
                    break;
                }

                default:
                    break;
            }

        }

        return true;
    }

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Student student = new Student(18, "张三");

        System.out.println(check(student));
    }
}
