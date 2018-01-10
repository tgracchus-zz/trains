package com.trains.graph;

import java.util.Objects;

public class Vertex {
    private final String label;

    private Vertex(String label) {
        Objects.requireNonNull(label);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return label != null ? label.equals(vertex.label) : vertex.label == null;
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }

    public static Vertex newVertex(String label) {
        return new Vertex(label);

    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
