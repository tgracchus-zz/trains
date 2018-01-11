package com.trains.graph.traverse;

import com.trains.exception.NoSuchPathException;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TraverseTestFixture {

    public void checkValidTraverse(Path path, List<Vertex> traversal, int expectedLength, int expectedtedWeight) throws NoSuchPathException {
        assertEquals(expectedLength, path.size());
        for (int i = 0; i < traversal.size(); i++) {
            Vertex traversalVertex = traversal.get(i);
            assertEquals(path.get(i), traversalVertex);
            assertEquals(expectedtedWeight, path.weight());
        }
    }
}
