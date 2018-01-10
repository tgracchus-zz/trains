package com.trains.graph.traverse;

import com.trains.graph.Graph;
import com.trains.graph.Vertex;
import com.trains.graph.Path;

import java.util.List;
import java.util.Optional;

public interface Traverse {
    Optional<Path> traverse(List<Vertex> traversePath, Graph graph);
}
