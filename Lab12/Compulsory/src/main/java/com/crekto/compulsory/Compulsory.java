/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.crekto.compulsory;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hiimC
 */
public class Compulsory {

    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String commandName = scanner.next();
            if (commandName.equalsIgnoreCase("exit")) {
                break;
            }
            String[] params = scanner.nextLine().trim().split("\\s+");
            try {
                // The command name is actually the class name
                Class clazz = Class.forName(commandName);
                Command command = (Command) clazz.newInstance();
                command.execute(params);
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException e) {
                System.err.println(e);
            }
        }
    }

}
