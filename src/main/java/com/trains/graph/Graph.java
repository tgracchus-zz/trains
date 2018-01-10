package com.trains.graph;


public interface Graph {

    void addEdge(Vertex source, Vertex target, int weight);

    Edges edges(Vertex a);

}
