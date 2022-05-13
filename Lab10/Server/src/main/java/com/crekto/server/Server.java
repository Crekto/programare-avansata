/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.server;

import com.crekto.server.threads.ClientThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hiimC
 */
public class Server {

    public static final int PORT = 8100;
    boolean running = true;

    public void setRunning(boolean running) {
        this.running = running;
    }
    ServerSocket serverSocket = null;

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Server() throws IOException {

        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
