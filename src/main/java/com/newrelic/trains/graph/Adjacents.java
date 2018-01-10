package com.newrelic.trains.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Adjacents {
    private final List<AdjacentNode> aAdjacents;

    public Adjacents() {
        this.aAdjacents = new ArrayList<>();
    }

    public int size() {
        return aAdjacents.size();
    }

    public boolean add(AdjacentNode adjacentNode) {
        return aAdjacents.add(adjacentNode);
    }


    public Optional<AdjacentNode> findNode(Node node) {
        for (AdjacentNode adjacentNode : aAdjacents) {
            if (adjacentNode.getAdjacent().equals(node)) {
                return Optional.of(adjacentNode);
            }
        }
        return Optional.empty();
    }

}
