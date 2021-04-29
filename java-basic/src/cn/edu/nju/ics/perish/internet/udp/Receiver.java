package cn.edu.nju.ics.perish.internet.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(2200);

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            System.out.println("接收到：" + new String(packet.getData(), 0, packet.getLength()));
        }
    }
}
