package com.trains.graph.traverse;


import com.trains.graph.Vertex;
import com.trains.graph.fixture.TestGraph;
import com.trains.graph.fixture.TestGraphFixture;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultTraverseTest {

    private TestGraphFixture testGraphFixture;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        testGraph = new TestGraph();
        Traverse traverse = new DefaultTraverse();
        testGraphFixture = new TestGraphFixture(testGraph, traverse);
    }

    @Test
    public void checkABCTraverse() {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.B(), testGraph.C());
        testGraphFixture.checkValidTraverse(ABCTraverse, 3, 9);
    }

    @Test
    public void checkADTraverse() {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.D());
        testGraphFixture.checkValidTraverse(ABCTraverse, 2, 5);
    }

    @Test
    public void checkADCTraverse() {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.D(), testGraph.C());
        testGraphFixture.checkValidTraverse(ABCTraverse, 3, 13);
    }

    @Test
    public void checkAEDTraverse() {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.E(), testGraph.D());
        testGraphFixture.checkInvalidTraverse(ABCTraverse);
    }

    @Test
    public void checkEmptyTraverse() {
        List<Vertex> ABCTraverse = new ArrayList<>();
        testGraphFixture.checkInvalidTraverse(ABCTraverse);
    }

    @Test
    public void checkOnlyOneElementTraverse() {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A());
        testGraphFixture.checkInvalidTraverse(ABCTraverse);
    }
}
