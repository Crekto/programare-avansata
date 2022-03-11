package com.company.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Network {
    private ArrayList<Node> nodes = new ArrayList<Node>();

    public Network(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public Network() {
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public boolean alreadyContainsNode(Node obj) {
        for (Node node : nodes)
            if (obj.getName() == node.getName()) return true;
        return false;
    }

    public void addNode(Node node) {
        if (alreadyContainsNode(node)) {
            System.err.println("The node with the name " + node.getName() + " is already added to the network");
        } else nodes.add(node);
    }

    @Override
    public String toString() {
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return "Network{" + "nodes=\n" + nodes + "}\n";
    }
}
