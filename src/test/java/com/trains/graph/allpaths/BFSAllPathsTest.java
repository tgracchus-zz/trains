package com.trains.graph.allpaths;

import com.trains.graph.Path;
import com.trains.graph.fixture.TestGraph;
import com.trains.graph.fixture.TestGraphFixture;
import com.trains.graph.traverse.DefaultTraverse;
import com.trains.graph.traverse.Traverse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BFSAllPathsTest {

    private AllPaths allPaths;
    private TestGraphFixture testGraphFixture;
    private TestGraph testGraph;

    @Before
    public void setUp() {
        allPaths = new BFSAllPaths();
        testGraph = new TestGraph();
        Traverse traverse = new DefaultTraverse();
        testGraphFixture = new TestGraphFixture(testGraph, traverse);
    }


    @Test
    public void testAllPaths() {
        List<Path> paths = allPaths.paths(3, testGraph.A(), testGraph);
        Assert.assertFalse(paths.isEmpty());
    }
}
