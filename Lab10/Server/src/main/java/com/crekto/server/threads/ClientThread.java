/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.server.threads;

import com.crekto.server.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import utils.Database;
import utils.FriendCommand;
import utils.LoginCommand;
import utils.MessageCommand;
import utils.RegisterCommand;

/**
 *
 * @author hiimC
 */
public class ClientThread extends Thread {

    private Server server = null;
    private Socket socket = null;
    private Database db = null;
    private boolean loggedIn = false;
    private String username = "Unconnected";

    public ClientThread(Socket socket, Server server, Database db) throws IOException {
        this.server = server;
        this.socket = socket;
        this.db = db;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String response = new String();
            boolean running = true;
            while (running) {
                out.println(username);
                out.flush();
                String request = in.readLine();

                // Send the response to the oputput stream: server → client
                String[] command = request.split(" ", 2);
                switch (command[0]) {
                    case "register":
                        response = RegisterCommand.register(db, command[1]);
                        break;
                    case "login":
                        response = LoginCommand.login(db, command[1], this);
                        break;
                    case "friend":
                        response = FriendCommand.friend(db, this, command[1]);
                        break;
                    case "send":
                        response = MessageCommand.send(db, command[1], this);
                        break;
                    case "read":
                        response = MessageCommand.read(db, this);
                        break;
                    case "stop":
                        response = "The server is stopping..";
                        server.getServerSocket().close();
                        server.setRunning(false);
                        socket.close();
                        break;
                    default:
                        response = "Aceasta comanda nu exista!";
                        break;
                }

                out.println(response);
                /*
            if (request.equals(new String("stop"))) {
                System.out.println("The server is stopping...");
                server.setRunning(false);
            }*/
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
