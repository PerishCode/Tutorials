package cn.edu.nju.ics.perish.jie_kou;

/*
 Interface 组成
 
 - 常量 
 - 抽象方法 
 - 默认方法 在继承关系比较复杂的场景下，调整顶部的接口就不需要重构了
 - 静态方法 只能由接口直接调用
 - 私有方法
 */

public class Main {
    public static void main(String[] args) {
        Example example = new Example() {
            public void show1() {
                System.out.println("这是一个通过匿名内部类方式构造的实例被重写的 show1 方法");
            };
        };

        example.show1();

        Example.show3();
    }
}
