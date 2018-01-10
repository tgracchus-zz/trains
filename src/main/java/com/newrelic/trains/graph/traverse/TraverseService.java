package com.newrelic.trains.graph.traverse;

import com.newrelic.trains.graph.Graph;
import com.newrelic.trains.graph.NoSuchRouteException;
import com.newrelic.trains.graph.Node;

import java.util.List;

public interface TraverseService {
    Traverse traverse(List<Node> traversePath, Graph graph) throws NoSuchRouteException;
}
