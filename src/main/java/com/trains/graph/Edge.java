package com.trains.graph;

import java.util.Objects;

public class Edge {

    private final Vertex source;
    private final Vertex target;
    private final int weight;

    private Edge(Vertex source, Vertex target, int weight) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public boolean isSource(Vertex target) {
        return this.target.equals(target);
    }

    public boolean isTarget(Vertex target) {
        return this.target.equals(target);
    }


    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    public static Edge newEdge(Vertex source, Vertex target, int weight) {
        return new Edge(source, target, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(target, edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
