package com.newrelic.trains.graph.traverse;

import com.newrelic.trains.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class Traverse {
    private final List<Node> nodes;
    private int weight;

    public Traverse(Node firstNode) {
        nodes = new ArrayList<>();
        nodes.add(firstNode);
        weight = 0;
    }

    public void addNode(Node node, int weight) {
        nodes.add(node);
        this.weight = this.weight + weight;
    }

    public int longitud() {
        return nodes.size();
    }

    public int weight() {
        return weight;
    }

    public Node get(int i) {
        return nodes.get(i);
    }


}
