package com.company.classes;

import com.company.interfaces.Identifiable;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(ArrayList<Node> nodes) {
        nodes.sort(Comparator.comparing(Node::getName));

        this.nodes = nodes;
    }

    public Network() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public boolean alreadyContainsNode(Node obj) {
        for (Node node : nodes)
            if (Objects.equals(obj.getName(), node.getName())) return true;
        return false;
    }

    public void addNode(Node node) {
        if (alreadyContainsNode(node)) {
            System.err.println("The node with the name " + node.getName() + " is already added to the network");
        } else nodes.add(node);

        nodes.sort(Comparator.comparing(Node::getName));
    }

    public void displayIdentifiable() {
        List<Identifiable> auxNodes = new ArrayList<>();

        for (Node node : nodes) {
            if (node instanceof Identifiable) {
                auxNodes.add((Identifiable) node);
            }
        }
        auxNodes.sort((o1, o2) -> {
            String[] ip1 = o1.getIpAddress().split("\\.");
            String ipFormatted1 = String.format("%3s.%3s.%3s.%3s", ip1[0], ip1[1], ip1[2], ip1[3]);
            String[] ip2 = o2.getIpAddress().split("\\.");
            String ipFormatted2 = String.format("%3s.%3s.%3s.%3s", ip2[0], ip2[1], ip2[2], ip2[3]);
            return ipFormatted1.compareTo(ipFormatted2);
        });
        for (Identifiable node : auxNodes) {
            System.out.println(node.getIpAddress());
        }
    }


    public void determineShortestTimes(Node source) {
        Map<Node, Integer> shortestTimes = new LinkedHashMap<>();
        for (Node node : nodes)
            shortestTimes.put(node, Integer.MAX_VALUE);
        shortestTimes.put(source, 0);

        List<Node> visitedNodes = new ArrayList<>();
        List<Node> unvisitedNodes = new ArrayList<>();
        unvisitedNodes.add(source);

        while (unvisitedNodes.size() != 0) {
            Node currentNode = null;
            int shortestTime = Integer.MAX_VALUE;
            for (Node node : unvisitedNodes) {
                int currentTime = shortestTimes.get(node);
                if (currentTime < shortestTime) {
                    shortestTime = currentTime;
                    currentNode = node;
                }
            }
            unvisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> mapElement : currentNode.getTimeCosts().entrySet()) {
                Node adjacentNode = mapElement.getKey();
                Integer travelTime = mapElement.getValue();
                if (!visitedNodes.contains(adjacentNode)) {
                    Integer currentTime = shortestTimes.get(currentNode);
                    if (currentTime + travelTime < shortestTimes.get(adjacentNode)) {
                        shortestTimes.put(adjacentNode, currentTime + travelTime);
                    }
                    unvisitedNodes.add(adjacentNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        StringBuilder aux = new StringBuilder("Source = " + source.getName() + '\n');
        for (Map.Entry<Node, Integer> mapElement : shortestTimes.entrySet()) {
            aux.append("    ").append(mapElement.getKey().getName()).append(" - ").append(mapElement.getValue()).append('\n');
        }
        System.out.println(aux);
    }

    public void determineAllShortestTimes() {
        for (Node source : nodes) {
            determineShortestTimes(source);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Network:\n");
        for (Node node : nodes) {
            for (Map.Entry<Node, Integer> mapElement : node.getTimeCosts().entrySet()) {
                result.append(node.getName()).append("--").append(mapElement.getKey().getName()).append(" - cost: ").append(mapElement.getValue()).append('\n');
            }
        }
        return result.toString();
    }

}
