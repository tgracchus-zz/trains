package com.trains.graph.fixture;

import com.trains.graph.AdjacencyListGraph;
import com.trains.graph.Graph;
import com.trains.graph.Vertex;

public class TestGraph extends AdjacencyListGraph {

    private final Vertex A;
    private final Vertex B;
    private final Vertex C;
    private final Vertex D;
    private final Vertex E;
    private final Graph testGraph;


    public TestGraph() {
        A = Vertex.newVertex("A");
        B = Vertex.newVertex("B");
        C = Vertex.newVertex("C");
        D = Vertex.newVertex("D");
        E = Vertex.newVertex("E");
        testGraph = new AdjacencyListGraph();
        testGraph.addEdge(A, B, 5);
        testGraph.addEdge(B, C, 4);
        testGraph.addEdge(C, D, 8);
        testGraph.addEdge(D, C, 8);
        testGraph.addEdge(D, E, 6);
        testGraph.addEdge(A, D, 5);
        testGraph.addEdge(C, E, 2);
        testGraph.addEdge(E, B, 3);
        testGraph.addEdge(A, E, 7);
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
