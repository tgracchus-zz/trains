package com.trains.graph.shortpath;

import com.trains.graph.Edge;
import com.trains.graph.Graph;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra implements ShortestPath {

    @Override
    public Path shortestPath(Vertex source, Vertex target, Graph graph) {
        DijkstraVertexMap dijkstraVertexMap = initSingleSource(source, graph);
        List<DijkstraVertex> q = new ArrayList<>(dijkstraVertexMap.vertexMap.values());

        while (!q.isEmpty()) {
            Collections.sort(q);//Find min, can be improved
            DijkstraVertex u = q.remove(0);
            for (Edge ve : graph.edges(u.vertex)) {
                DijkstraVertex v = dijkstraVertexMap.get(ve.getTarget());
                relax(u, v, ve.getWeight());
            }
        }

        DijkstraVertex sourceV = dijkstraVertexMap.get(source);
        DijkstraVertex targetV = dijkstraVertexMap.get(target);
        return new Path(buildPath(sourceV, targetV), targetV.weight);
    }


    private DijkstraVertexMap initSingleSource(Vertex source, Graph graph) {
        DijkstraVertexMap dijkstraVertexMap = new DijkstraVertexMap();
        for (Vertex vertex : graph.vertices()) {
            //Improvement: Use a mark for infinite instead of Integer.MAX_VALUE / 2
            DijkstraVertex dijkstraVertex = new DijkstraVertex(vertex, Integer.MAX_VALUE / 2, null);
            dijkstraVertexMap.put(dijkstraVertex);
        }

        //DijkstraVertex dijkstraVertex = new DijkstraVertex(source, 0, null);
       // dijkstraVertexMap.put(dijkstraVertex);
        return dijkstraVertexMap;
    }

    private void relax(DijkstraVertex u, DijkstraVertex v, int weight) {
        if (v.weight > u.weight + weight) {
            v.weight = u.weight + weight;
            v.p = u;
        }
    }

    private List<Vertex> buildPath(DijkstraVertex s, DijkstraVertex v) {
        List<Vertex> path = new ArrayList<>();
        path.add(s.vertex);
        if (s.vertex.equals(v.vertex)) {
            return path;
        } else if (v.p == null) {
            return null;
        } else {
            path = buildPath(s, v.p);
            path.add(v.vertex);
        }
        return path;
    }

    private class DijkstraVertexMap {
        private final Map<Vertex, DijkstraVertex> vertexMap;

        public DijkstraVertexMap() {
            this.vertexMap = new HashMap<>();
        }

        public void put(DijkstraVertex dijkstraVertex) {
            vertexMap.put(dijkstraVertex.vertex, dijkstraVertex);
        }

        public DijkstraVertex get(Vertex target) {
            return vertexMap.get(target);
        }
    }

    private class DijkstraVertex implements Comparable<DijkstraVertex> {
        private Vertex vertex;
        private Integer weight;
        private DijkstraVertex p;

        public DijkstraVertex(Vertex vertex, Integer weight, DijkstraVertex p) {
            this.vertex = vertex;
            this.weight = weight;
            this.p = p;
        }

        @Override
        public int compareTo(DijkstraVertex dijkstraVertex) {
            return Integer.compare(weight, dijkstraVertex.weight);
        }

        @Override
        public String toString() {
            return "DijkstraVertex{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    ", p=" + p +
                    '}';
        }
    }


}
