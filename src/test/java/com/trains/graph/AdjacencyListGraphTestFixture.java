package com.trains.graph;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.trains.graph.GraphFixture.EdgeCheck;

public class AdjacencyListGraphTestFixture {

    private GraphFixture graphFixture;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        testGraph = new TestGraph();
        graphFixture = new GraphFixture();
    }

    @Test
    public void checkAEdges() {
        graphFixture.checkValidEdges(testGraph.edges(testGraph.A()),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.B(), 5),
                        EdgeCheck.newEdgeCheck(testGraph.D(), 5),
                        EdgeCheck.newEdgeCheck(testGraph.E(), 7)
                )
        );
    }

    @Test
    public void checBEEdges() {
        graphFixture.checkValidEdges(testGraph.edges(testGraph.B()),
                Collections.singletonList(
                        EdgeCheck.newEdgeCheck(testGraph.C(), 4)
                )
        );
    }

    @Test
    public void checkCEdges() {
        graphFixture.checkValidEdges(testGraph.edges(testGraph.C()),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.E(), 2),
                        EdgeCheck.newEdgeCheck(testGraph.D(), 8)
                )
        );
    }

    @Test
    public void checkDEdges() {
        graphFixture.checkValidEdges(testGraph.edges(testGraph.D()),
                Arrays.asList(
                        EdgeCheck.newEdgeCheck(testGraph.C(), 8),
                        EdgeCheck.newEdgeCheck(testGraph.E(), 6)
                )
        );
    }

    @Test
    public void checkEEdges() {
        graphFixture.checkValidEdges(testGraph.edges(testGraph.E()),
                Collections.singletonList(
                        EdgeCheck.newEdgeCheck(testGraph.B(), 3)
                )
        );
    }


}
