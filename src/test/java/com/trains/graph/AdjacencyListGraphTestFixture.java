package com.trains.graph;


import com.trains.graph.fixture.TestGraph;
import com.trains.graph.fixture.TestGraphFixture;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.trains.graph.fixture.TestGraphFixture.EdgeCheck;

public class AdjacencyListGraphTestFixture {

    private TestGraphFixture testGraphFixture;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        testGraph = new TestGraph();
        Traverse traverse = new DefaultTraverse();
        testGraphFixture = new TestGraphFixture(testGraph, traverse);
    }

    @Test
    public void checkAEdges() {
        testGraphFixture.checkValidEdges(testGraph.A(),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.B(), 5),
                        EdgeCheck.newEdgeCheck(testGraph.D(), 5),
                        EdgeCheck.newEdgeCheck(testGraph.E(), 7)
                )
        );
    }

    @Test
    public void checBEEdges() {
        testGraphFixture.checkValidEdges(testGraph.B(),
                Collections.singletonList(
                        EdgeCheck.newEdgeCheck(testGraph.C(), 4)
                )
        );
    }

    @Test
    public void checkCEdges() {
        testGraphFixture.checkValidEdges(testGraph.C(),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.E(), 2),
                        EdgeCheck.newEdgeCheck(testGraph.D(), 8)
                )
        );
    }

    @Test
    public void checkDEdges() {
        testGraphFixture.checkValidEdges(testGraph.D(),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.C(), 8),
                        EdgeCheck.newEdgeCheck(testGraph.E(), 6)
                )
        );
    }

    @Test
    public void checkEEdges() {
        testGraphFixture.checkValidEdges(testGraph.E(),
                Collections.singletonList(
                        EdgeCheck.newEdgeCheck(testGraph.B(), 3)
                )
        );
    }


}
