package com.trains.graph;


import java.util.List;

public interface Graph {

    void addEdge(Vertex source, Vertex target, int weight);

    Edges edges(Vertex a);

    List<Vertex> vertices();

}
