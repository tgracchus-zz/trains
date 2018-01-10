package com.trains.graph.traverse;

import com.trains.graph.Edge;
import com.trains.graph.Edges;
import com.trains.graph.Graph;
import com.trains.graph.NoSuchPathException;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.List;
import java.util.Optional;

public class DefaultTraverse implements Traverse {

    public DefaultTraverse() {

    }

    @Override
    public Path traverse(List<Vertex> traversePath, Graph graph) throws NoSuchPathException {
        if (traversePath.size() > 1) {
            Vertex actualVertex = traversePath.get(0);
            Path path = new Path(actualVertex);
            for (int i = 1; i < traversePath.size(); i++) {
                Vertex nextVertex = traversePath.get(i);
                Edges edges = graph.edges(actualVertex);
                Optional<Edge> adjacentNodeOpt = edges.traverseTo(nextVertex);
                if (adjacentNodeOpt.isPresent()) {
                    Edge edge = adjacentNodeOpt.get();
                    path = new Path(path, nextVertex, edge.getWeight());
                } else {
                    throw new NoSuchPathException(traversePath);
                }
                actualVertex = nextVertex;
            }

            return path;
        } else {
            throw new NoSuchPathException(traversePath);
        }
    }
}
