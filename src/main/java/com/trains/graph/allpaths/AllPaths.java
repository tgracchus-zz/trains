package com.trains.graph.allpaths;

import com.trains.graph.Graph;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.List;

public interface AllPaths {

    List<Path> pathsUpTo(int k, Vertex source, Vertex target, Graph graph);

    List<Path> pathsEqualsTo(int k, Vertex source, Vertex target, Graph graph);
}
