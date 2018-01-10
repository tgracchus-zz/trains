package com.trains.graph.com.trains.graph.shortpath;

import com.trains.graph.Path;
import com.trains.graph.fixture.TestGraph;
import com.trains.graph.shortpath.Dijkstra;
import com.trains.graph.shortpath.ShortestPath;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {

    private ShortestPath shortestPath;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        shortestPath = new Dijkstra();
        testGraph = new TestGraph();
        Traverse traverse = new DefaultTraverse();
    }

    @Test
    public void shortestPathAC() {
        Path a = shortestPath.shortestPath(testGraph.A(), testGraph.C(), testGraph);
        Assert.assertTrue(a.longitud() >= 1);
    }

    @Test
    public void shortestPathBB() {
        Path a = shortestPath.shortestPath(testGraph.B(), testGraph.B(), testGraph);
        Assert.assertTrue(a.longitud() >= 1);
    }
}
