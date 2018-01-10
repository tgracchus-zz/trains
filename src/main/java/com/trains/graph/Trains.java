package com.trains.graph;

import com.trains.graph.allpaths.Paths;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.Traverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Trains {

    private final Paths paths;
    private final ShortestPath shortestPath;
    private final Traverse traverse;

    public Trains(Paths paths, ShortestPath shortestPath, Traverse traverse) {
        this.paths = paths;
        this.shortestPath = shortestPath;
        this.traverse = traverse;
    }


    public int distanceOfRouteABC(Graph graph) throws NoSuchPathException {
        List<String> abcTraverse = Arrays.asList("A", "B", "C");
        List<Vertex> traversePath = graph.findVertices(abcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.longitud();
    }

    public int distanceOfRouteAD(Graph graph) throws NoSuchPathException {
        List<String> adTraverse = Arrays.asList("A", "D");
        List<Vertex> traversePath = graph.findVertices(adTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.longitud();
    }

    public int distanceOfRouteADC(Graph graph) throws NoSuchPathException {
        List<String> adcTraverse = Arrays.asList("A", "D", "C");
        List<Vertex> traversePath = graph.findVertices(adcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.longitud();
    }

    public int distanceOfRouteAEBCD(Graph graph) throws NoSuchPathException {
        List<String> aebcdTraverse = Arrays.asList("A", "E", "B", "C", "D");
        List<Vertex> traversePath = graph.findVertices(aebcdTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.longitud();
    }

    public int distanceOfRouteAED(Graph graph) throws NoSuchPathException {
        List<String> aedTraverse = Arrays.asList("A", "E", "D");
        List<Vertex> traversePath = graph.findVertices(aedTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.longitud();
    }

    public int countAllTripsCCMax3(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return paths.AllPathsUpTo(3, vertices.get(0), vertices.get(0), graph).size();
    }

    public int countAllTripsAEEquals4(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "E"));
        return paths.AllPathsEqualsTo(4, vertices.get(0), vertices.get(1), graph).size();
    }

    public int shortestPathAC(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "C"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).longitud();
    }

    public int shortestPathBB(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("B", "B"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).longitud();
    }

    public int countAllTripsCCLessThan30(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return paths.AllPathsWeightLessThan(30, vertices.get(0), vertices.get(0), graph).size();
    }


}
