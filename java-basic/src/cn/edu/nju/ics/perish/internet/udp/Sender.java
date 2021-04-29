package cn.edu.nju.ics.perish.internet.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String line;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while ((line = reader.readLine()) != null) {
            if ("bye".equals(line))
                break;

            byte[] buffer = line.getBytes();
            socket.send(new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 2200));
        }

        socket.close();
    }
}
