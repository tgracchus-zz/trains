package com.trains.graph.traverse;


import com.trains.graph.NoSuchPathException;
import com.trains.graph.Path;
import com.trains.graph.TestGraph;
import com.trains.graph.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraverseTest {

    private TraverseTestFixture traverseTestFixture;
    private TestGraph testGraph;
    private Traverse traverse;

    @Before
    public void setUp() {
        testGraph = new TestGraph();
        traverse = new DefaultTraverse();
        traverseTestFixture = new TraverseTestFixture();
    }

    @Test
    public void checkABCTraverse() throws NoSuchPathException {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.B(), testGraph.C());
        Path path = traverse.traverse(ABCTraverse, testGraph);
        traverseTestFixture.checkValidTraverse(path, ABCTraverse, 3, 9);
    }

    @Test
    public void checkADTraverse() throws NoSuchPathException {
        List<Vertex> ADTTraverse = Arrays.asList(testGraph.A(), testGraph.D());
        Path path = traverse.traverse(ADTTraverse, testGraph);
        traverseTestFixture.checkValidTraverse(path, ADTTraverse, 2, 5);
    }

    @Test
    public void checkADCTraverse() throws NoSuchPathException {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.D(), testGraph.C());
        Path path = traverse.traverse(ABCTraverse, testGraph);
        traverseTestFixture.checkValidTraverse(path, ABCTraverse, 3, 13);
    }

    @Test(expected = NoSuchPathException.class)
    public void checkAEDTraverse() throws NoSuchPathException {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A(), testGraph.E(), testGraph.D());
        this.traverse.traverse(ABCTraverse, testGraph);
    }

    @Test(expected = NoSuchPathException.class)
    public void checkEmptyTraverse() throws NoSuchPathException {
        List<Vertex> ABCTraverse = new ArrayList<>();
        this.traverse.traverse(ABCTraverse, testGraph);
    }

    @Test(expected = NoSuchPathException.class)
    public void checkOnlyOneElementTraverse() throws NoSuchPathException {
        List<Vertex> ABCTraverse = Arrays.asList(testGraph.A());
        this.traverse.traverse(ABCTraverse, testGraph);
    }
}
