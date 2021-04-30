package cn.edu.nju.ics.perish.java_lei;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CaseD {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> studentClass = Class.forName("cn.edu.nju.ics.perish.java_lei.Student");

        Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

        System.out.println(constructor);

        Object student = constructor.newInstance("Yeah", 18);

        // Method[] methods = studentClass.getMethods();
        Method[] methods = studentClass.getDeclaredMethods();

        System.out.println(student);
        // System.out.println(methods);

        for (Method method : methods) {
            System.out.println(method);
        }

        Method method = studentClass.getMethod("Say");

        method.invoke(student);
    }
}
