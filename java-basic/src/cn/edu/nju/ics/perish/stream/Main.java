package cn.edu.nju.ics.perish.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "张四", "李四");

        List<String> result = list.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());

        System.out.println(result);

        Stream.of("张三", "张四", "李四").filter(s -> s.startsWith("张")).collect(Collectors.toList());
    }
}
