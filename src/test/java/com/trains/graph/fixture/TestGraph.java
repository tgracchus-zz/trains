package com.trains.graph.fixture;

import com.trains.graph.AdjacencyListGraph;
import com.trains.graph.Edges;
import com.trains.graph.Graph;
import com.trains.graph.Vertex;

public class TestGraph implements Graph{

    private final Vertex A;
    private final Vertex B;
    private final Vertex C;
    private final Vertex D;
    private final Vertex E;
    private final Graph testGraph;

    @Override
    public void addEdge(Vertex source, Vertex target, int weight) {
        testGraph.addEdge(source, target, weight);
    }

    @Override
    public Edges edges(Vertex a) {
        return testGraph.edges(a);
    }

    public TestGraph() {
        A = Vertex.newNode("A");
        B = Vertex.newNode("B");
        C = Vertex.newNode("C");
        D = Vertex.newNode("D");
        E = Vertex.newNode("E");
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
