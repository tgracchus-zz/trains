package com.trains.fixtures;

import com.trains.graph.Graph;
import com.trains.graph.Vertex;
import com.trains.graph.allpaths.AllPaths;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPathsFixture {

    private final AllPaths allPaths;

    public AllPathsFixture(AllPaths allPaths) {
        this.allPaths = allPaths;
    }

    public int test6CountAllTripsCCMax3(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return allPaths.AllPathsUpTo(3, vertices.get(0), vertices.get(0), graph).size();
    }

    public int test7CountAllTripsAEEquals4(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "C"));
        return allPaths.AllPathsEqualsTo(4, vertices.get(0), vertices.get(1), graph).size();
    }


    public int test10CountAllTripsCCLessThan30(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return allPaths.AllPathsWeightLessThan(30, vertices.get(0), vertices.get(0), graph).size();
    }
}
