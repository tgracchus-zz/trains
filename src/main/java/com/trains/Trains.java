package com.trains;

import com.trains.fixtures.AllPathsFixture;
import com.trains.fixtures.ShortestPathFixture;
import com.trains.fixtures.TraverseFixture;
import com.trains.graph.Graph;
import com.trains.graph.NoSuchPathException;
import com.trains.graph.allpaths.BFSAllPaths;
import com.trains.graph.allpaths.AllPaths;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;

public class Trains {

    private final TraverseFixture traverseFixture;
    private final AllPathsFixture allPathsFixture;
    private final ShortestPathFixture shortestPathFixture;
    private final OutputHandler outputHandler;
    private final GraphBuilder graphBuilder;

    public Trains(TraverseFixture traverseFixture, AllPathsFixture allPathsFixture, ShortestPathFixture shortestPathFixture, OutputHandler outputHandler, GraphBuilder graphBuilder) {
        this.traverseFixture = traverseFixture;
        this.allPathsFixture = allPathsFixture;
        this.shortestPathFixture = shortestPathFixture;
        this.outputHandler = outputHandler;
        this.graphBuilder = graphBuilder;
    }

    public void run(String graphString) {
        //Build Graph
        Graph graph = graphBuilder.newAdjacencyListGraph(graphString);

        try {
            int res = traverseFixture.test1DistanceOfRouteABC(graph);
            outputHandler.printResult("Output #1: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #1: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test2DistanceOfRouteAD(graph);
            outputHandler.printResult("Output #2: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #2: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test3DistanceOfRouteADC(graph);
            outputHandler.printResult("Output #3: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #3: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test4DistanceOfRouteAEBCD(graph);
            outputHandler.printResult("Output #4: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #4: NO SUCH ROUTE");
        }

        try {
            int res = traverseFixture.test5DistanceOfRouteAED(graph);
            outputHandler.printResult("Output #5: " + res);
        } catch (NoSuchPathException e) {
            outputHandler.printResult("Output #5: NO SUCH ROUTE");
        }

        outputHandler.printResult("Output #6: " + allPathsFixture.test6CountAllTripsCCMax3(graph));

        outputHandler.printResult("Output #7: " + allPathsFixture.test7CountAllTripsAEEquals4(graph));

        outputHandler.printResult("Output #8: " + shortestPathFixture.test8ShortestPathAC(graph));

        outputHandler.printResult("Output #9: " + shortestPathFixture.test9ShortestPathBB(graph));

        outputHandler.printResult("Output #10: " + allPathsFixture.test10CountAllTripsCCLessThan30(graph));

    }

    public static Trains newDefaultTrains() {
        AllPaths allPaths = new BFSAllPaths();
        ShortestPath shortestPath = new Dijkstra();
        Traverse traverse = new DefaultTraverse();
        ShortestPathFixture shortestPathFixture = new ShortestPathFixture(shortestPath);
        TraverseFixture traverseFixture = new TraverseFixture(traverse);
        AllPathsFixture allPathsFixture = new AllPathsFixture(allPaths);
        GraphBuilder graphBuilder = new GraphBuilder();
        OutputHandler outputHandler = new OutputHandler();
        return new Trains(traverseFixture, allPathsFixture, shortestPathFixture, outputHandler, graphBuilder);
    }

}
