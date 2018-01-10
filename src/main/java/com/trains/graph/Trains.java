package com.trains.graph;

import com.trains.OutputHandler;
import com.trains.graph.allpaths.Paths;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.Traverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Trains {

    private final Paths paths;
    private final ShortestPath shortestPath;
    private final Traverse traverse;

    public Trains(Paths paths, ShortestPath shortestPath, Traverse traverse) {
        this.paths = paths;
        this.shortestPath = shortestPath;
        this.traverse = traverse;
    }


    public void run(String graphInLine) {
        Scanner in = new Scanner(graphInLine);
        OutputHandler outputHandler = new OutputHandler();
        Graph graph = new AdjacencyListGraph();
        in.next();
        while (in.hasNext()) {
            String edge = in.next();
            Vertex target = Vertex.newVertex(edge.substring(0, 1));
            Vertex source = Vertex.newVertex(edge.substring(1, 2));
            Integer weight = Integer.parseInt(edge.substring(2, 3));
            graph.addEdge(target, source, weight);
        }

        try {
            int res = test1DistanceOfRouteABC(graph);
            outputHandler.printResult("Output #1: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #1: NO SUCH ROUTE");
        }

        try {
            int res = test2DistanceOfRouteAD(graph);
            outputHandler.printResult("Output #2: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #2: NO SUCH ROUTE");
        }

        try {
            int res = test3DistanceOfRouteADC(graph);
            outputHandler.printResult("Output #3: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #3: NO SUCH ROUTE");
        }

        try {
            int res = test4DistanceOfRouteAEBCD(graph);
            outputHandler.printResult("Output #4: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #4: NO SUCH ROUTE");
        }

        try {
            int res = test5DistanceOfRouteAED(graph);
            outputHandler.printResult("Output #5: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #5: NO SUCH ROUTE");
        }

        outputHandler.printResult("Output #6: " + test6CountAllTripsCCMax3(graph));

        outputHandler.printResult("Output #7: " + test7CountAllTripsAEEquals4(graph));

        outputHandler.printResult("Output #8: " + test8ShortestPathAC(graph));

        outputHandler.printResult("Output #9: " + test9ShortestPathBB(graph));

        outputHandler.printResult("Output #10: " + test10CountAllTripsCCLessThan30(graph));

    }


    private int test1DistanceOfRouteABC(Graph graph) throws NoSuchPathException {
        List<String> abcTraverse = Arrays.asList("A", "B", "C");
        List<Vertex> traversePath = graph.findVertices(abcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    private int test2DistanceOfRouteAD(Graph graph) throws NoSuchPathException {
        List<String> adTraverse = Arrays.asList("A", "D");
        List<Vertex> traversePath = graph.findVertices(adTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    private int test3DistanceOfRouteADC(Graph graph) throws NoSuchPathException {
        List<String> adcTraverse = Arrays.asList("A", "D", "C");
        List<Vertex> traversePath = graph.findVertices(adcTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    private int test4DistanceOfRouteAEBCD(Graph graph) throws NoSuchPathException {
        List<String> aebcdTraverse = Arrays.asList("A", "E", "B", "C", "D");
        List<Vertex> traversePath = graph.findVertices(aebcdTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    private int test5DistanceOfRouteAED(Graph graph) throws NoSuchPathException {
        List<String> aedTraverse = Arrays.asList("A", "E", "D");
        List<Vertex> traversePath = graph.findVertices(aedTraverse);
        Path path = traverse.traverse(traversePath, graph);
        return path.weight();
    }

    private int test6CountAllTripsCCMax3(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return paths.AllPathsUpTo(3, vertices.get(0), vertices.get(0), graph).size();
    }

    private int test7CountAllTripsAEEquals4(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "E"));
        return paths.AllPathsEqualsTo(4, vertices.get(0), vertices.get(1), graph).size();
    }

    private int test8ShortestPathAC(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("A", "C"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).weight();
    }

    private int test9ShortestPathBB(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Arrays.asList("B", "B"));
        return shortestPath.shortestPath(vertices.get(0), vertices.get(1), graph).weight();
    }

    private int test10CountAllTripsCCLessThan30(Graph graph) {
        List<Vertex> vertices = graph.findVertices(Collections.singletonList("C"));
        return paths.AllPathsWeightLessThan(30, vertices.get(0), vertices.get(0), graph).size();
    }


}
