package com.trains.fixtures;

import com.trains.graph.Graph;
import com.trains.graph.Vertex;
import com.trains.graph.shortpath.ShortestPath;

import java.util.Arrays;
import java.util.List;

public class ShortestPathFixture {

    private final ShortestPath shortestPath;

    public ShortestPathFixture(ShortestPath shortestPath) {
        this.shortestPath = shortestPath;
    }


    public int test8ShortestPathAC(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "C"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).weight();
    }

    public int test9ShortestPathBB(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("B", "B"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).weight();
    }

}
