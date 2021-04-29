package cn.edu.nju.ics.perish.thread.producer_consumer;

public class Producer implements Runnable {

    private Box box;

    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            box.put(i);
        }
    }

}
