package com.company;

import com.company.classes.Computer;
import com.company.classes.Network;
import com.company.classes.Router;
import com.company.classes.Switch;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("v1 (Computer A)", "00-00-00", "Iasi", "127.0.0.1", 1024);
        Router v2 = new Router("v2 (Router A)", "00-00-00", "Iasi", "82.245.77.83");
        Switch v3 = new Switch("v3 (Switch A)", "00-00-00", "Bucuresti");
        Switch v4 = new Switch("v4 (Switch B)", "00-00-00", "Suceava");
        Router v5 = new Router("v5 (Router B)", "00-00-00", "Constanta", "87.23.67.124");
        Computer v6 = new Computer("v6 (Computer B)", "00-00-00", "Vaslui", "92.12.95.83", 1024);


        v1.addCost(v2, 10);
        v1.addCost(v3, 50);
        v2.addCost(v3, 20);
        v2.addCost(v4, 20);
        v2.addCost(v5, 20);
        v3.addCost(v4, 10);
        v4.addCost(v5, 30);
        v4.addCost(v6, 10);
        v5.addCost(v6, 20);

        /* In case that the graph is undirected */
        v2.addCost(v1, 10);
        v3.addCost(v1, 50);
        v3.addCost(v2, 20);
        v4.addCost(v2, 20);
        v5.addCost(v2, 20);
        v4.addCost(v3, 10);
        v5.addCost(v4, 30);
        v6.addCost(v4, 10);
        v6.addCost(v5, 20);

        Network network1 = new Network();
        network1.addNode(v1);
        network1.addNode(v2);
        network1.addNode(v3);
        network1.addNode(v4);
        network1.addNode(v5);
        network1.addNode(v6);
        System.out.println(network1);

        network1.determineAllShortestTimes();

    }
}
