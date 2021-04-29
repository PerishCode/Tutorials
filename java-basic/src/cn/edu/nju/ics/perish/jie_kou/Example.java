package cn.edu.nju.ics.perish.jie_kou;

public interface Example {
    void show1();

    private void hey() {
    }

    private static void static_hey() {
    }

    default void show2() {
        hey();
    }

    public static void show3() {
        static_hey();
    }
}
