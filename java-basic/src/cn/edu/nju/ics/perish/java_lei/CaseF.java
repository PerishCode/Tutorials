package cn.edu.nju.ics.perish.java_lei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CaseF {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(
                new FileReader("/home/perish/Tutorials/java-basic/resources/configuration.txt"));

        String className = reader.readLine().split("=")[1];
        String methodName = reader.readLine().split("=")[1];

        // System.out.println(className + "," + methodName);

        Class<?> targetClass = Class.forName("cn.edu.nju.ics.perish.java_lei." + className);

        Constructor<?> constructor = targetClass.getConstructor(String.class, int.class);

        Method method = targetClass.getMethod(methodName);

        method.invoke(constructor.newInstance("李磊", 18));

        reader.close();
    }
}
