package com.trains.graph.traverse;

import com.trains.graph.Graph;
import com.trains.graph.NoSuchPathException;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.List;

public interface Traverse {
    Path traverse(List<Vertex> traversePath, Graph graph) throws NoSuchPathException;
}
