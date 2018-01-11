package com.trains.graph;

import com.trains.graph.adjancency.AdjacencyListGraph;

public class TestGraph extends AdjacencyListGraph {

    private final Vertex A;
    private final Vertex B;
    private final Vertex C;
    private final Vertex D;
    private final Vertex E;

    public TestGraph() {
        A = Vertex.newVertex("A");
        B = Vertex.newVertex("B");
        C = Vertex.newVertex("C");
        D = Vertex.newVertex("D");
        E = Vertex.newVertex("E");
        addEdge(A, B, 5);
        addEdge(B, C, 4);
        addEdge(C, D, 8);
        addEdge(D, C, 8);
        addEdge(D, E, 6);
        addEdge(A, D, 5);
        addEdge(C, E, 2);
        addEdge(E, B, 3);
        addEdge(A, E, 7);
    }

    public Vertex A() {
        return A;
    }

    public Vertex B() {
        return B;
    }

    public Vertex C() {
        return C;
    }

    public Vertex D() {
        return D;
    }

    public Vertex E() {
        return E;
    }
}
