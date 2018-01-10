package com.newrelic.trains.graph;


public interface Graph {

    void addEdge(Node source, Node target, int weight);

    Adjacents adjacents(Node a);

}
