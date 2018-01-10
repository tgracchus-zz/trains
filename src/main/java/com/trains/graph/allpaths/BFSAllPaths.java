package com.trains.graph.allpaths;

import com.trains.graph.Edge;
import com.trains.graph.Edges;
import com.trains.graph.Graph;
import com.trains.graph.Path;
import com.trains.graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAllPaths implements AllPaths {

    @Override
    public List<Path> paths(int nodes, Vertex source, Graph graph) {
        List<Path> paths = new ArrayList<>();
        Queue<VertexWithPath> pending = new LinkedList<>();
        pending.offer(new VertexWithPath(source));
        int node = 0;
        while (!pending.isEmpty()) {
            VertexWithPath u = pending.poll();
            Edges edges = graph.edges(u.vertex);
            node = node + 1;
            if (node <= nodes) {
                for (Edge edge : edges) {
                    Path currentPath = new Path(u.path, edge.getTarget(), edge.getWeight());
                    paths.add(currentPath);
                    pending.offer(new VertexWithPath(edge.getTarget(), currentPath));
                }
            }
        }
        return paths;
    }

    private static class VertexWithPath {
        private final Vertex vertex;
        private final Path path;

        public VertexWithPath(Vertex vertex) {
            this.vertex = vertex;
            this.path = new Path(vertex);
        }

        public VertexWithPath(Vertex vertex, Path path) {
            this.vertex = vertex;
            this.path = path;
        }
    }

}
