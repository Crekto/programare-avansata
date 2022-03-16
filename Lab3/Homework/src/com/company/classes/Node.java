package com.company.classes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Node {
    String name;
    String macAddress;
    String location;
    Map<Node, Integer> timeCosts = new LinkedHashMap<>();

    public Node(String name, String macAddress, String location) {
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<Node, Integer> getTimeCosts() {
        return timeCosts;
    }

    public void setTimeCosts(HashMap<Node, Integer> timeCosts) {
        this.timeCosts = timeCosts;
    }

    public void addCost(Node node, Integer cost) {
        this.timeCosts.put(node, cost);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Node{" + "\n     name='" + name + '\'' + "\n     macAddress='" + macAddress + '\'' + "\n     location='" + location + '\'');
        return getString(result);
    }

    protected String getString(StringBuilder result) {
        if (timeCosts.size() > 0) {
            result.append("\n     timeCosts=\n");
            for (Map.Entry<Node, Integer> mapElement : timeCosts.entrySet()) {
                result.append("         to: ").append(mapElement.getKey().getName()).append(" - cost: ").append(mapElement.getValue()).append('\n');
            }
            result.append("}");
        } else {
            result.append("\n}");
        }

        return result.toString();
    }
}
