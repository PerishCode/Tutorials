package cn.edu.nju.ics.perish.java_lei;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CaseC {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> studentClass = Class.forName("cn.edu.nju.ics.perish.java_lei.Student");

        Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

        System.out.println(constructor);

        Object student = constructor.newInstance("Yeah", 18);

        // Field[] fields = studentClass.getFields();
        Field[] fields = studentClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        Field field = studentClass.getField("name");

        field.set(student, "Haha");

        System.out.println(student);
    }
}
