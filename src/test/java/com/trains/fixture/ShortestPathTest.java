package com.trains.fixture;

import com.trains.graph.Path;
import com.trains.graph.TestGraph;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortestPathTest {

    private ShortestPath shortestPath;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        shortestPath = new Dijkstra();
        testGraph = new TestGraph();
    }

    @Test
    public void shortestPathAC() {
        Path a = shortestPath.shortestPath(testGraph.A(), testGraph.C(), testGraph);
        Assert.assertTrue(a.size() >= 1);
    }

    @Test
    public void shortestPathBB() {
        Path a = shortestPath.shortestPath(testGraph.B(), testGraph.B(), testGraph);
        Assert.assertTrue(a.size() >= 1);
    }
}
