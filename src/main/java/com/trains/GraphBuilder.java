package com.trains;

import com.trains.graph.adjancency.AdjacencyListGraph;
import com.trains.graph.Graph;
import com.trains.graph.Vertex;

import java.util.Scanner;

public class GraphBuilder {

    public GraphBuilder() {
    }

    public Graph newAdjacencyListGraph(String graphInLine) {
        Scanner in = new Scanner(graphInLine);
        Graph graph = new AdjacencyListGraph();
        in.next();
        while (in.hasNext()) {
            String edge = in.next();
            Vertex target = Vertex.newVertex(edge.substring(0, 1));
            Vertex source = Vertex.newVertex(edge.substring(1, 2));
            Integer weight = Integer.parseInt(edge.substring(2, 3));
            graph.addEdge(target, source, weight);
        }
        return graph;

    }
}