package com.newrelic.trains.graph;

public class AdjacentNode {

    private final Node adjacent;
    private final int weight;

    private AdjacentNode(Node adjacent, int weight) {
        this.adjacent = adjacent;
        this.weight = weight;
    }

    public Node getAdjacent() {
        return adjacent;
    }

    public int getWeight() {
        return weight;
    }

    public static AdjacentNode newAdjacent(Node target, int weight) {
        return new AdjacentNode(target, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdjacentNode that = (AdjacentNode) o;

        return adjacent != null ? adjacent.equals(that.adjacent) : that.adjacent == null;
    }

    @Override
    public int hashCode() {
        return adjacent != null ? adjacent.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AdjacentNode{" +
                "adjacent=" + adjacent +
                ", weight=" + weight +
                '}';
    }
}
