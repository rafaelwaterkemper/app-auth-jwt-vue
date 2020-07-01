package com.waterkemper.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);

            String awnser = "";

            while(!awnser.equals("sair")) {
                System.out.println("Aguardando mensagem");
                Scanner scanner = new Scanner(System.in);
                awnser = scanner.nextLine();
                client.getOutputStream().write(awnser.getBytes());
                client.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
