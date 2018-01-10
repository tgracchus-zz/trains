package com.trains.graph.fixture;

import com.trains.graph.AdjacencyListGraph;
import com.trains.graph.Edges;
import com.trains.graph.Graph;
import com.trains.graph.Vertex;

import java.util.Set;

public class TestGraph implements Graph {

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

    @Override
    public Set<Vertex> vertices() {
        return testGraph.vertices();
    }

    @Override
    public Set<Vertex> findVertices(Set<String> labels) {
        return testGraph.findVertices(labels);
    }

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

    public String A() {
        return A.getLabel();
    }

    public String B() {
        return B.getLabel();
    }

    public String C() {
        return C.getLabel();
    }

    public String D() {
        return D.getLabel();
    }

    public String E() {
        return E.getLabel();
    }
}
