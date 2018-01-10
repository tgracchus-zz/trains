package com.trains.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph implements Graph {

    private final Map<Vertex, Edges> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public Edges edges(Vertex a) {
        return createOrGetNodeEdges(a);
    }


    @Override
    public void addEdge(Vertex source, Vertex target, int weight) {
        createOrGetNodeEdges(source).putIfAbsent(Edge.newEdge(source, target, weight));
    }


    private Edges createOrGetNodeEdges(Vertex vertex) {
        return adjacencyList.computeIfAbsent(vertex, addingNode -> new Edges());
    }

    @Override
    public List<Vertex> vertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }
}
