package cn.edu.nju.ics.perish.thread.producer_consumer;

public class Box {
    private int countOfMilk;
    private boolean empty = true;

    public synchronized void put(int count) {

        if (!empty) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        countOfMilk = count;
        System.out.println("送奶工将第" + count + "瓶奶放入奶箱");

        empty = false;

        notifyAll();
    }

    public synchronized void get() {

        if (empty) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("客户拿到第" + countOfMilk + "瓶奶");
        empty = true;

        notifyAll();
    }
}
