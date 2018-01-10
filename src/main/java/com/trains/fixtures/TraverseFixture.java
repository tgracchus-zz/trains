package com.trains.fixtures;

import com.trains.graph.Graph;
import com.trains.graph.NoSuchPathException;
import com.trains.graph.Path;
import com.trains.graph.Vertex;
import com.trains.graph.traverse.Traverse;

import java.util.Arrays;
import java.util.List;

public class TraverseFixture {

    private final Traverse traverse;

    public TraverseFixture(Traverse traverse) {
        this.traverse = traverse;
    }

    public int test1DistanceOfRouteABC(Graph graph) throws NoSuchPathException {
        List<String> abcTraverse = Arrays.asList("A", "B", "C");
        List<Vertex> traversePath = graph.findVertices(abcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    public int test2DistanceOfRouteAD(Graph graph) throws NoSuchPathException {
        List<String> adTraverse = Arrays.asList("A", "D");
        List<Vertex> traversePath = graph.findVertices(adTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    public int test3DistanceOfRouteADC(Graph graph) throws NoSuchPathException {
        List<String> adcTraverse = Arrays.asList("A", "D", "C");
        List<Vertex> traversePath = graph.findVertices(adcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    public int test4DistanceOfRouteAEBCD(Graph graph) throws NoSuchPathException {
        List<String> aebcdTraverse = Arrays.asList("A", "E", "B", "C", "D");
        List<Vertex> traversePath = graph.findVertices(aebcdTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    public int test5DistanceOfRouteAED(Graph graph) throws NoSuchPathException {
        List<String> aedTraverse = Arrays.asList("A", "E", "D");
        List<Vertex> traversePath = graph.findVertices(aedTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

}
