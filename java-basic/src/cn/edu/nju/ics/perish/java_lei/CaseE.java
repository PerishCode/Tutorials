package cn.edu.nju.ics.perish.java_lei;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CaseE {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        // 通过反射机制越过泛型检查
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        Class<?> listClass = list.getClass();

        Method method = listClass.getMethod("add", Object.class);

        method.invoke(list, "Hello");

        System.out.println(list);
    }
}
