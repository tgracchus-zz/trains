package com.trains.graph.allpaths;

import com.trains.graph.Graph;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.List;

public interface Paths {

    List<Path> AllPathsUpTo(int k, Vertex source, Vertex target, Graph graph);

    List<Path> AllPathsEqualsTo(int k, Vertex source, Vertex target, Graph graph);

    List<Path> AllPathsWeightLessThan(int weight, Vertex source, Vertex target, Graph graph);
}
