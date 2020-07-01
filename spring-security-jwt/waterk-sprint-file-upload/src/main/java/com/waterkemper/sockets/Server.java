package com.waterkemper.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress localhost = new InetSocketAddress("localhost", 8080);
            serverSocket.bind(localhost);
            Socket accept = serverSocket.accept();
            accept.getInputStream();
            boolean close = true;

            while(close) {
                Thread.sleep(1000);
                InputStream inputStream = accept.getInputStream();
                inputStream.available();
                byte[] buffer = new byte[8];
                inputStream.read(buffer);
                String message = new String(buffer);
                if(!message.isEmpty()) {
                    System.out.println("Message received: " + message);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
