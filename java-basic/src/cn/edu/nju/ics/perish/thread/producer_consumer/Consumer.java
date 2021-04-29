package cn.edu.nju.ics.perish.thread.producer_consumer;

public class Consumer implements Runnable {

    private Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.get();
        }
    }
}
