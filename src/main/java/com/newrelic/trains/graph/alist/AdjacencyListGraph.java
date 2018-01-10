package com.newrelic.trains.graph.alist;

import com.newrelic.trains.graph.AdjacentNode;
import com.newrelic.trains.graph.Adjacents;
import com.newrelic.trains.graph.Graph;
import com.newrelic.trains.graph.Node;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyListGraph implements Graph {

    private final Map<Node, Adjacents> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public Adjacents adjacents(Node a) {
        return createOrGetNodeEdges(a);
    }


    @Override
    public void addEdge(Node source, Node target, int weight) {
        createOrGetNodeEdges(source).add(AdjacentNode.newAdjacent(target, weight));
    }


    private Adjacents createOrGetNodeEdges(Node node) {
        return adjacencyList.computeIfAbsent(node, addingNode -> new Adjacents());
    }


}
