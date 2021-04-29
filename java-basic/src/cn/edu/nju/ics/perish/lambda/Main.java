package cn.edu.nju.ics.perish.lambda;

public class Main {
    public static void main(String[] args) {

        // lambda 表达式的使用前提
        // 1. 正常情况下参数类型为接口
        // 2. 接口中有且只有一个抽象方法

        // 使用技巧
        // 1. 参数类型可以省略
        // 2. 如果要省略必须全部省略
        // 3. 如果只有一个参则数可以省略括号
        // 4. 如果代码块只包含一个语句则可以省略 return 以及 {}

        // 匿名内部类的适用范围更广 但是编译会生成对应的 class 文件

        check(a -> ("我是个苹果被吃掉了" + a));
    }

    static void check(Eatable eatable) {
        System.out.println(eatable.eat(123));

    }
}
