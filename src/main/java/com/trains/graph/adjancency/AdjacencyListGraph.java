package com.trains.graph.adjancency;

import com.trains.graph.Edge;
import com.trains.graph.Edges;
import com.trains.graph.Graph;
import com.trains.graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public Set<Vertex> vertices() {
        return adjacencyList.keySet();
    }

    @Override
    public List<Vertex> findVertices(List<String> labels) {
        List<Vertex> vertices = new ArrayList<>();
        for (String label : labels) {
            Vertex vertex = Vertex.newVertex(label);
            if (adjacencyList.containsKey(vertex)) {
                vertices.add(vertex);
            }
        }
        return vertices;
    }
}
