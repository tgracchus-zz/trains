package com.trains.graph;


import java.util.List;
import java.util.Set;

public interface Graph {

    void addEdge(Vertex source, Vertex target, int weight);

    Edges edges(Vertex a);

    Set<Vertex> vertices();

    List<Vertex> findVertices(List<String> labels);

}
