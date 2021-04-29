package cn.edu.nju.ics.perish.thread.producer_consumer;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();

        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
