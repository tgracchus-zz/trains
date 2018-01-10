package com.trains.graph;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphFixture {


    public void checkValidEdges(Edges edges, List<EdgeCheck> checks) {
        assertEquals(checks.size(), edges.size());
        int i = 0;
        for (EdgeCheck check : checks) {
            Optional<Edge> edgeOpt = edges.traverseTo(check.expectedTargetVertex);
            assertTrue(edgeOpt.isPresent());
            Edge edge = edgeOpt.get();
            assertEquals(check.expectedWeight, edge.getWeight());
        }
    }


    public static class EdgeCheck {
        private final Vertex expectedTargetVertex;
        private final int expectedWeight;

        private EdgeCheck(Vertex expectedTargetVertex, int expectedWeight) {
            this.expectedTargetVertex = expectedTargetVertex;
            this.expectedWeight = expectedWeight;
        }

        public static EdgeCheck newEdgeCheck(Vertex expectedTargetVertex, int expectedWeight) {
            return new EdgeCheck(expectedTargetVertex, expectedWeight);
        }
    }
}
