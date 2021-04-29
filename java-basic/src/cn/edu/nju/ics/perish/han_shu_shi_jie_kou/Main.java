package cn.edu.nju.ics.perish.han_shu_shi_jie_kou;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // 通过添加注解可以显式地提醒使用者该接口为函数式接口
        Sayable example = () -> System.out.println("这是一个 lambda 方法");

        example.say();

        new Thread(runnableBuilder("冲啊！！！！")).start();

        Supplier<String> supplier = () -> "你好呀，我是供应商";

        System.out.println(supplier.get());

        Function<String, Integer> func = String::length;

        System.out.println(func.apply("你好呀，我是个函数"));
    }

    static Runnable runnableBuilder(String source) {
        return () -> System.out.println(source);
    }
}
