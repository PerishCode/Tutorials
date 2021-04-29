package cn.edu.nju.ics.perish.internet.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();

        System.out.println(address);
    }
}
