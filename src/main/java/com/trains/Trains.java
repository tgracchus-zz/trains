package com.trains;

import com.trains.fixtures.AllPathsFixture;
import com.trains.fixtures.ShortestPathFixture;
import com.trains.fixtures.TraverseFixture;
import com.trains.graph.Graph;
import com.trains.exception.NoSuchPathException;
import com.trains.graph.allpaths.AllPaths;
import com.trains.graph.allpaths.BFSAllPaths;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;

import java.util.ArrayList;
import java.util.List;

public class Trains {

    private final TraverseFixture traverseFixture;
    private final AllPathsFixture allPathsFixture;
    private final ShortestPathFixture shortestPathFixture;
    private final GraphBuilder graphBuilder;

    public Trains(TraverseFixture traverseFixture, AllPathsFixture allPathsFixture, ShortestPathFixture shortestPathFixture, GraphBuilder graphBuilder) {
        this.traverseFixture = traverseFixture;
        this.allPathsFixture = allPathsFixture;
        this.shortestPathFixture = shortestPathFixture;
        this.graphBuilder = graphBuilder;
    }

    public List<String> run(String graphString) {
        List<String> result = new ArrayList<>();
        //Build Graph
        Graph graph = graphBuilder.newAdjacencyListGraph(graphString);

        try {
            int res = traverseFixture.test1DistanceOfRouteABC(graph);
            result.add("Output #1: " + res);
        } catch (NoSuchPathException e) {
            result.add("Output #1: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test2DistanceOfRouteAD(graph);
            result.add("Output #2: " + res);
        } catch (NoSuchPathException e) {
            result.add("Output #2: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test3DistanceOfRouteADC(graph);
            result.add("Output #3: " + res);
        } catch (NoSuchPathException e) {
            result.add("Output #3: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test4DistanceOfRouteAEBCD(graph);
            result.add("Output #4: " + res);
        } catch (NoSuchPathException e) {
            result.add("Output #4: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test5DistanceOfRouteAED(graph);
            result.add("Output #5: " + res);
        } catch (NoSuchPathException e) {
            result.add("Output #5: NO SUCH ROUTE");
        }

        result.add("Output #6: " + allPathsFixture.test6CountAllTripsCCMax3(graph));

        result.add("Output #7: " + allPathsFixture.test7CountAllTripsAEEquals4(graph));

        result.add("Output #8: " + shortestPathFixture.test8ShortestPathAC(graph));

        result.add("Output #9: " + shortestPathFixture.test9ShortestPathBB(graph));

        result.add("Output #10: " + allPathsFixture.test10CountAllTripsCCLessThan30(graph));

        return result;
    }

    public static Trains newDefaultTrains() {
        AllPaths allPaths = new BFSAllPaths();
        ShortestPath shortestPath = new Dijkstra();
        Traverse traverse = new DefaultTraverse();
        ShortestPathFixture shortestPathFixture = new ShortestPathFixture(shortestPath);
        TraverseFixture traverseFixture = new TraverseFixture(traverse);
        AllPathsFixture allPathsFixture = new AllPathsFixture(allPaths);
        GraphBuilder graphBuilder = new GraphBuilder();
        return new Trains(traverseFixture, allPathsFixture, shortestPathFixture, graphBuilder);
    }

}
