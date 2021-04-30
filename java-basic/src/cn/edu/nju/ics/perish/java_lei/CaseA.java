package cn.edu.nju.ics.perish.java_lei;

import java.lang.reflect.InvocationTargetException;

/*
  任何 java 程序在运行过程中如果需要某个类，且该类还未加载到内存中，JVM就会通过
    - 类的加载
    - 类的连接
    - 类的初始化
  这三个步骤对类进行初始化
  
  类的加载： 
    1. JVM 将 class 读入内存，并创建一个 java.lang.Class 对象

  类的连接：
    1. 验证 class 文件的合法性
    2. 为类的 Class 对象分配内存，并初始化其默认值
    3. 将类中二进制数据的符号引用替换为内存中的直接引用

  类的初始化：
    - 假如类还未被加载和连接，则先进行加载和连接
    - 假如类的直接父类还未被初始化，则先对直接父类进行初始化
 */

/*
  类的初始化时机：
    - 创建类的实例
    - 调用类的静态方法
    - 访问类的静态变量
    - 通过反射强制创建 Class 实例
    - 直接通过命令行工具 'java' 来调用某个类
 */

/*
  类加载机制：
    - 全盘委托：除非显式地指定类加载器，否则使用全局的默认类加载器
    - 父类委托：
    - 缓存机制：所有被加载的类都会在一个全局的缓存区中被缓存，在类加载器试图加载某个类时会优先搜索缓存区
 */

public class CaseA {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
      InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();

        System.out.println(systemLoader);
    
        ClassLoader platformLoader = systemLoader.getParent();
    
        System.out.println(platformLoader);
    
        ClassLoader bootstrapLoader = platformLoader.getParent();
    
        System.out.println(bootstrapLoader);
    
        Class<?> studentClass = Student.class;
    
        System.out.println(studentClass);
    
        Class<?> studentClass_copy = Student.class;
    
        System.out.println(studentClass == studentClass_copy);
    
        Student student = new Student("Tony", 18);
    
        System.out.println(studentClass == student.getClass());
    
        Class<?> studentClass_forName = Class.forName("cn.edu.nju.ics.perish.java_lei.Student");
    
        System.out.println(studentClass_forName == studentClass);
  }
}
