package com.trains.graph.allpaths;

import com.trains.graph.Path;
import com.trains.graph.TestGraph;
import com.trains.graph.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllPathsTest {

    private AllPathsTestFixture allPathsTestFixture;
    private TestGraph testGraph;
    private AllPaths allPaths;

    @Before
    public void setUp() {
        testGraph = new TestGraph();
        allPaths = new BFSAllPaths();
        allPathsTestFixture = new AllPathsTestFixture();
    }

    @Test
    public void test6CountAllTripsCCMax3() {
        List<Vertex> vertices = testGraph.findVertices(Collections.singletonList("C"));
        List<Path> paths = allPaths.AllPathsUpTo(3, vertices.get(0), vertices.get(0), testGraph);

        Assert.assertEquals(2, paths.size());

        Path cdc = new Path(Arrays.asList(testGraph.C(), testGraph.D(), testGraph.C()), 16);
        allPathsTestFixture.checkValidPath(paths, cdc, 2);

        Path cebc = new Path(Arrays.asList(testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C()), 9);
        allPathsTestFixture.checkValidPath(paths, cebc, 3);

    }

    @Test
    public void test7CountAllTripsAEEquals4() {
        List<Vertex> vertices = testGraph.findVertices(Arrays.asList("A", "C"));
        List<Path> paths = allPaths.AllPathsEqualsTo(4, vertices.get(0), vertices.get(1), testGraph);
        Assert.assertEquals(3, paths.size());

        Path abcdc = new Path(Arrays.asList(testGraph.A(), testGraph.B(), testGraph.C(), testGraph.D(), testGraph.C()), 25);
        allPathsTestFixture.checkValidPath(paths, abcdc, 4);

        Path adcdc = new Path(Arrays.asList(testGraph.A(), testGraph.D(), testGraph.C(), testGraph.D(), testGraph.C()), 29);
        allPathsTestFixture.checkValidPath(paths, adcdc, 4);

        Path adebc = new Path(Arrays.asList(testGraph.A(), testGraph.D(), testGraph.E(), testGraph.B(), testGraph.C()), 18);
        allPathsTestFixture.checkValidPath(paths, adebc, 4);
    }

    @Test
    public void test10CountAllTripsCCLessThan30() {
        List<Vertex> vertices = testGraph.findVertices(Collections.singletonList("C"));
        List<Path> paths = allPaths.AllPathsWeightLessThan(30, vertices.get(0), vertices.get(0), testGraph);

        Assert.assertEquals(7, paths.size());

        Path cdc = new Path(Arrays.asList(testGraph.C(), testGraph.D(), testGraph.C()), 16);
        allPathsTestFixture.checkValidPath(paths, cdc, 2);

        Path cebc = new Path(Arrays.asList(testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C()), 9);
        allPathsTestFixture.checkValidPath(paths, cebc, 3);

        Path cebcdc = new Path(Arrays.asList(testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C(), testGraph.D(), testGraph.C()), 25);
        allPathsTestFixture.checkValidPath(paths, cebcdc, 5);

        Path cdcebc = new Path(Arrays.asList(testGraph.C(), testGraph.D(), testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C()), 25);
        allPathsTestFixture.checkValidPath(paths, cdcebc, 5);

        Path cdebc = new Path(Arrays.asList(testGraph.C(), testGraph.D(), testGraph.E(), testGraph.B(), testGraph.C()), 21);
        allPathsTestFixture.checkValidPath(paths, cdebc, 4);

        Path cebcebc = new Path(Arrays.asList(testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C()), 18);
        allPathsTestFixture.checkValidPath(paths, cebcebc, 6);

        Path cebcebcebc = new Path(Arrays.asList(testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C(), testGraph.E(), testGraph.B(), testGraph.C()), 27);
        allPathsTestFixture.checkValidPath(paths, cebcebcebc, 9);
    }
}
