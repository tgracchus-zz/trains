package com.newrelic.trains.graph;


import com.newrelic.trains.graph.alist.AdjacencyListGraph;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacencyListGraphTest {

    private static final Node A = Node.newNode("A");
    private static final Node B = Node.newNode("B");
    private static final Node C = Node.newNode("C");
    private static final Node D = Node.newNode("D");
    private static final Node E = Node.newNode("E");
    private static final Graph testGraph = new AdjacencyListGraph();


    @BeforeClass
    public static void setUp() throws Exception {
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

    @Test
    public void checkAdjacents() throws Exception {
        Adjacents aAdjacents = testGraph.adjacents(A);
        assertEquals(3, aAdjacents.size());
        assertEquals(5, aAdjacents.findNode(B).get().getWeight());
        assertEquals(5, aAdjacents.findNode(D).get().getWeight());
        assertEquals(7, aAdjacents.findNode(E).get().getWeight());

        Adjacents bAdjacents = testGraph.adjacents(B);
        assertEquals(1, bAdjacents.size());
        assertEquals(4, bAdjacents.findNode(C).get().getWeight());

        Adjacents cAdjacents = testGraph.adjacents(C);
        assertEquals(2, cAdjacents.size());
        assertEquals(2, cAdjacents.findNode(E).get().getWeight());
        assertEquals(8, cAdjacents.findNode(D).get().getWeight());

        Adjacents dAdjacents = testGraph.adjacents(D);
        assertEquals(2, dAdjacents.size());
        assertEquals(8, dAdjacents.findNode(C).get().getWeight());
        assertEquals(6, dAdjacents.findNode(E).get().getWeight());


        Adjacents eAdjacents = testGraph.adjacents(E);
        assertEquals(1, eAdjacents.size());
        assertEquals(3, eAdjacents.findNode(B).get().getWeight());
    }

}
