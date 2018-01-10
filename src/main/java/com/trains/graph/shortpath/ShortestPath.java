package com.trains.graph.shortpath;

import com.trains.graph.Graph;
import com.trains.graph.Path;
import com.trains.graph.Vertex;


public interface ShortestPath {
    Path shortestPath(Vertex source, Vertex target, Graph graph);
}
