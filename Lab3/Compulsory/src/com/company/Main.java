package com.company;

import com.company.classes.Computer;
import com.company.classes.Network;
import com.company.classes.Router;
import com.company.classes.Switch;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("Computer A", "00-00-00", "Iasi", "127.0.0.1", 1024);
        Computer v2 = new Computer("Computer B", "00-00-00", "Vaslui", "127.0.0.1", 512);
        Computer v3 = new Computer("Computer C", "00-00-00", "Bacau", "127.0.0.1", 2048);
        Router v4 = new Router("Router A", "00-00-00", "Iasi", "127.0.0.1");
        Switch v5 = new Switch("Switch A", "00-00-00", "Bucuresti");

        Network network1 = new Network();
        network1.addNode(v1);
        network1.addNode(v3);
        network1.addNode(v5);
        network1.addNode(v4);
        network1.addNode(v2);

        System.out.println(network1);
    }
}
