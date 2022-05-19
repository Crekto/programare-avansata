/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author hiimC
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                 Socket socket = new Socket(serverAddress, PORT);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Send a request to the server
            Scanner requestIn = new Scanner(System.in);
            while (true) {
                String username = in.readLine();
                System.out.println("[" + username + "] Enter a command: ");
                String request = requestIn.nextLine();
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
                if (request.equals("stop")) {
                    break;
                }

            }

        } catch (IOException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
