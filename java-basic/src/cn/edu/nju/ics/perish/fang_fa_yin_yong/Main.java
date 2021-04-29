package cn.edu.nju.ics.perish.fang_fa_yin_yong;

public class Main {
    public static void main(String[] args) {
        // play(s->System.out.println(s));
        // 只要可推导类型，就可以使用‘方法引用’的写法
        // - 类的静态方法
        // - 实例的方法
        // - 类的非静态方法
        play(System.out::println);

        // cut((s, a, b) -> s.substring(a, b));
        cut(String::substring);

        build(Student::new);
    }

    static void play(Playable playable) {
        playable.play("HA");
    }

    static void cut(Cutable cutable) {
        System.out.println(cutable.cut("Hello", 0, 3));
    }

    static void build(StudentBuilder studentBuilder) {
        Student student = studentBuilder.build("张三", 18);

        System.out.println(student.getName() + "," + student.getAge());
    }
}
