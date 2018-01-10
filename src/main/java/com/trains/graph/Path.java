package com.trains.graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Vertex> vertices;
    private int weight;

    public Path(Vertex firstVertex) {
        vertices = new ArrayList<>();
        vertices.add(firstVertex);
        weight = 0;
    }

    public Path(Path path, Vertex nextVertex, int weight) {
        this.vertices = new ArrayList<>(path.vertices);
        this.vertices.add(nextVertex);
        this.weight = path.weight + weight;
    }

    public Path(List<Vertex> vertices, Integer weight) {
        this.vertices =  new ArrayList<>(vertices);
        this.weight = weight;
    }

    public int longitud() {
        return vertices.size();
    }

    public int weight() {
        return weight;
    }

    public Vertex get(int i) {
        return vertices.get(i);
    }

    public boolean endsWith(Vertex vertex) {
        if (vertices.isEmpty()) {
            return false;
        } else {
            Vertex lastVertex = vertices.get(vertices.size() - 1);
            return vertex.equals(lastVertex);
        }
    }

}
