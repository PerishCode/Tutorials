# Java 学习杂记

## 基本数据类型

- byte/short/int/long
- float/double
- char
- boolean

## 引用数据类型 \*

- 强引用：只有变量赋值为 null 或生命周期结束时才会被回收\[最普遍情况\]
- 软引用：内存充足时表现类似于强引用，内存不足时会按照"等待时间最长"的策略被回收\[对象缓存\]
- 弱引用：不论内存是否充足，只要 GC 发现弱引用就会强制回收\[对象缓存\]
- 虚引用：不论内存是否充足，只要 GC 发现虚引用就会强制回收\[GC 过程的插桩\]

## 类

### 权限修饰符

| 修饰符    | 当前类 | 相同 package 的类 | 当前类的子类 | 不同 package 的类 |
| :-------- | :----- | :---------------- | :----------- | :---------------- |
| private   | √      |                   |              |                   |
| default   | √      | √                 |              |                   |
| protected | √      | √                 | √            |                   |
| public    | √      | √                 | √            | √                 |

### static 关键字

#### 静态成员变量

```java
class Demo {
    static int i = 0;
}
```

#### 静态成员方法

- 只能访问类中的静态变量

```java
class Demo {
    static int i = 0;

    static void say(){
        System.out.println(this.i);
    }
}
```

### final 关键字

#### 成员变量

#### 局部变量

### 泛型

#### 类型通配符

- ```java
    List<?> demo; // 任意类
  ```

- ```java
    List<? extends Number> demo; // Number 类及 Number 类的子类
  ```

- ```java
    List<? super Number> demo; // Number 类及 Number 类的父类
  ```

## 常用 Collection

### Set

- 元素不重复

#### HashSet

- 不保证遍历顺序

#### LinkedHashSet

- 保证遍历顺序(遍历顺序与插入顺序一致)

#### TreeSet

- 保证遍历顺序(遍历顺序与排序结果一致)

- 自然排序 Comparable

  ```java
  public class Demo implements Comparable<Demo> {
      @Override
      public int comparaTo(Demo demo){
          return 0;
      }
  }
  ```

- 定制排序 Comparator

  ```java
  Comparator comparator = new Comparator<Demo>() {
      @Override
      public int compare(Demo demo_a, Demo demo_b) {
          return 0;
      }
  }
  ```

## JDK

### 自动装箱/自动拆箱

- 自动装箱：将基本数据类型转换为包装类的实例对象

```java
Integer i = 10; // Integer i = new Integer(10);
```

- 自动拆箱：将包装类的实例对象转换为基本数据类型

```java
Integer i = 10;
int j = i; // int j = i.intValue();
```

#### 原理

- JDK 自动调用包装类的 valueOf 方法构造实例对象，以及自动调用 \[xxx\]Value 方法获取基本数据类型

## File 类

- 实质就是把路径封装成了一个对象(那为啥不叫 Path (・∀・(・∀・(・∀・\*))

## IO

- Java 中的文件 IO 都通过流的机制实现

  - 数据流向划分：输入/输出
  - 数据处理方式划分：字节/字符
  - 底层调用效率划分：基本流/缓冲流

### 字节流&字节缓冲流

### 字符流&字符缓冲流

### 序列化流/反序列化流

- 序列化：把对象存储到文件中
- 反序列化：从文件中恢复对象

  ```java
  static void write() throws FileNotFoundException, IOException {
      ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(resourcePath + "1.txt"));
      output.writeObject(new Student("张三", 18));
      output.close();
  }

  static void read() throws FileNotFoundException, IOException, ClassNotFoundException {
      ObjectInputStream input = new ObjectInputStream(new FileInputStream(resourcePath + "1.txt"));
      System.out.println((Student) input.readObject());
      input.close();
  }
  ```

- 注意事项

  - 为防止局部更改导致默认计算的 UID 发生变化，要显示地定义 UID
  - 不希望被序列化的成员变量要通过 transient 关键字修饰

    ```java
    public class Student implements Serializable {

        private static final long serialVersionUID = 2200L;

        public String name;
        public transient int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "姓名：" + name + "----" + "年龄：" + age;
        }
    }
    ```

## 多线程

### 进程

- 运行中的程序(程序本身就是一堆代码和静态资源)
- 操作系统进行资源分配和调度的最小单位
- 每个进程都有专属的内存空间和系统资源

### 线程

- 进程中的顺序控制流
- 只有一个线程的进程就是单线程进程\[e.g. 记事本编辑打印是单一顺序控制(不能在打印界面被唤出时编辑内容)\]
- 存在若干线程的进程就是多线程进程\[e.g. 扫雷的计时器和游戏逻辑分离\]
- Java 采用抢占式内存调度策略，优先级越高，线程抢占 CPU 的概率越高

### Thread 类

- 重写 run 方法定义线程的执行逻辑(如果直接调用 run 方法等价于单线程调用)
- 调用 start 方法启动一个线程(JVM 会调用 run 方法)

  ```java
  public class Say extends Thread {

      int id;

      public Say(int id) {
          this.id = id;
      }

      @Override
      public void run() {
          for (int i = 0; i < 10; ++i)
              System.out.println(id + ": " + i);
      }
  }

  public static void main(String[] args) {
      Say say_a = new Say(0);
      Say say_b = new Say(1);

      say_a.start();
      say_b.start();
  }
  ```

### Runnable 接口

- 自定义类实现 Runnable 接口并实现 run 方法
- 创建 Thread 实例时先创建自定义类的实例作为构造函数的参数传入

  ```java
  public class RunnableSay implements Runnable {
      @Override
      public void run() {
          for (int i = 0; i < 10; ++i) {
              System.out.println(Thread.currentThread().getName() + ", " + i);
          }
      }
  }

  public static void main(String[] args) throws InterruptedException {

      Runnable runnableSay = new RunnableSay();

      Thread say_a = new Thread(runnableSay);
      Thread say_b = new Thread(runnableSay);

      say_a.start();
      say_b.start();

  }
  ```

- 优点：规避单继承的缺陷 & 对于同一类线程可以只实例化一个 Runnable 对象，代码和进程充分分离

#### 常用方法

- sleep：线程休眠
- join：线程执行完毕才会继续下面的逻辑(很像 js await)
- setDeamon: 设置线程为守护线程(基本上就是主线程结束时自动结束的线程)

#### 生命周期

 <!-- TODO 补充图片示例 -->

### 多线程数据同步

- 同步代码块

  ```java
  public class SellTicket implements Runnable {
      private int nonselledTicketNum = 100;
      private Object nonselledTicketNumLock = new Object();

      @Override
      public void run() {

          String threadName = Thread.currentThread().getName();

          while (true) {
              synchronized (nonselledTicketNumLock) {
                  if (nonselledTicketNum > 0) {
                      System.out.println(threadName + "窗口正在售出第" + (nonselledTicketNum--) + "张票");
                  }
              }
          }

      }
  }
  ```

  - 弊端：每个线程运行时都要先检查锁，存在一定的性能损失

- 同步方法：等价于同步代码块锁定 this
- 静态同步方法：等价于同步代码块锁定当前类 XXX.class

#### 线程安全类

- StringBuffer $\Leftrightarrow$ StringBuilder
- Vector $\Leftrightarrow$ Collections.syncronizedList $\Leftrightarrow$ ArrayList
- Hashtable $\Leftrightarrow$ Collections.syncronizedMap $\Leftrightarrow$ HashMap

#### 生产者消费者模式

- notify
- notifyAll
- wait
