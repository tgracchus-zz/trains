package com.trains.graph;

import java.util.List;

public class NoSuchPathException extends Exception {

    private final List<Vertex> path;

    public NoSuchPathException(List<Vertex> path) {
        this.path = path;
    }

    public List<Vertex> getPath() {
        return path;
    }
}
