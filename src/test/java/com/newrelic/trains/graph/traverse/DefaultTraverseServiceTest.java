package com.newrelic.trains.graph.traverse;


import com.newrelic.trains.graph.Graph;
import com.newrelic.trains.graph.NoSuchRouteException;
import com.newrelic.trains.graph.Node;
import com.newrelic.trains.graph.alist.AdjacencyListGraph;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultTraverseServiceTest {

    private static final Node A = Node.newNode("A");
    private static final Node B = Node.newNode("B");
    private static final Node C = Node.newNode("C");
    private static final Node D = Node.newNode("D");
    private static final Node E = Node.newNode("E");
    private static final Graph testGraph = new AdjacencyListGraph();
    private static final TraverseService traverseService = new DefaultTraverseService();

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
    public void checkABCTraverse() throws Exception {
        List<Node> ABCTraverse = Arrays.asList(A, B, C);
        Traverse traverse = traverseService.traverse(ABCTraverse, testGraph);
        assertEquals(3, traverse.longitud());
        assertEquals(traverse.get(0), A);
        assertEquals(traverse.get(1), B);
        assertEquals(traverse.get(2), C);
        assertEquals(9, traverse.weight());
    }

    @Test
    public void checkADTraverse() throws Exception {
        List<Node> ADTraverse = Arrays.asList(A, D);
        Traverse traverse = traverseService.traverse(ADTraverse, testGraph);
        assertEquals(2, traverse.longitud());
        assertEquals(traverse.get(0), A);
        assertEquals(traverse.get(1), D);
        assertEquals(5, traverse.weight());
    }

    @Test
    public void checkADCTraverse() throws Exception {
        List<Node> ADCTraverse = Arrays.asList(A, D, C);
        Traverse traverse = traverseService.traverse(ADCTraverse, testGraph);
        assertEquals(3, traverse.longitud());
        assertEquals(traverse.get(0), A);
        assertEquals(traverse.get(1), D);
        assertEquals(traverse.get(2), C);
        assertEquals(13, traverse.weight());
    }

    @Test(expected = NoSuchRouteException.class)
    public void checkAEDTraverse() throws Exception {
        List<Node> AEDTraverse = Arrays.asList(A, E, D);
        traverseService.traverse(AEDTraverse, testGraph);
    }

    @Test(expected = NoSuchRouteException.class)
    public void checkEmptyTraverse() throws Exception {
        traverseService.traverse(new ArrayList<>(), testGraph);
    }

    @Test(expected = NoSuchRouteException.class)
    public void checkOnlyOneElementTraverse() throws Exception {
        traverseService.traverse(Collections.singletonList(A), testGraph);
    }
}
