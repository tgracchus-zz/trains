package com.newrelic.trains.graph.traverse;

import com.newrelic.trains.graph.AdjacentNode;
import com.newrelic.trains.graph.Adjacents;
import com.newrelic.trains.graph.Graph;
import com.newrelic.trains.graph.NoSuchRouteException;
import com.newrelic.trains.graph.Node;

import java.util.List;
import java.util.Optional;

public class DefaultTraverseService implements TraverseService {

    public DefaultTraverseService() {

    }
    @Override
    public Traverse traverse(List<Node> traversePath, Graph graph) throws NoSuchRouteException {
        if (traversePath.size() > 1) {
            Node actualNode = traversePath.get(0);
            Traverse traverse = new Traverse(actualNode);
            for (int i = 1; i < traversePath.size(); i++) {
                Node nextNode = traversePath.get(i);
                Adjacents adjacents = graph.adjacents(actualNode);
                Optional<AdjacentNode> adjacentNodeOpt = adjacents.findNode(nextNode);
                if (adjacentNodeOpt.isPresent()) {
                    AdjacentNode adjacentNode = adjacentNodeOpt.get();
                    traverse.addNode(nextNode, adjacentNode.getWeight());
                } else {
                    throw new NoSuchRouteException();
                }
                actualNode = nextNode;
            }

            return traverse;
        } else {
            throw new NoSuchRouteException();
        }
    }
}
