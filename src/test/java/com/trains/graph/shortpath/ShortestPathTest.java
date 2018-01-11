package com.trains.graph.shortpath;

import com.trains.graph.Path;
import com.trains.graph.TestGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ShortestPathTest {

    private ShortestPath shortestPath;
    private ShortestPathTestFixture shortestPathTestFixture;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        shortestPath = new Dijkstra();
        shortestPathTestFixture = new ShortestPathTestFixture();
        testGraph = new TestGraph();
    }

    @Test
    public void shortestPathAC() {
        Path ac = shortestPath.shortestPath(testGraph.A(), testGraph.C(), testGraph);
        shortestPathTestFixture.checkValidPath(ac, new Path(Arrays.asList(testGraph.A(), testGraph.B(), testGraph.C()), 9));
    }

    @Test
    public void shortestPathBB() {
        Path bb = shortestPath.shortestPath(testGraph.B(), testGraph.B(), testGraph);
        shortestPathTestFixture.checkValidPath(bb, new Path(Collections.singletonList(testGraph.B()), 0));
    }
}
