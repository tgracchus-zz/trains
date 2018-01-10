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
import java.util.function.Function;

public class BFSAllPaths implements AllPaths {

    @Override
    public List<Path> pathsUpTo(int k, Vertex source, Vertex target, Graph graph) {
        List<Path> allpaths = paths(source, graph, new KEqualOrLess(k));
        List<Path> finalPaths = new ArrayList<>();
        for (Path path : allpaths) {
            if (path.endsWith(target)) {
                finalPaths.add(path);
            }
        }
        return finalPaths;
    }

    @Override
    public List<Path> pathsEqualsTo(int k, Vertex source, Vertex target, Graph graph) {
        List<Path> allpaths = paths(source, graph, new KEqualOrLess(k));
        List<Path> finalPaths = new ArrayList<>();
        for (Path path : allpaths) {
            if (path.longitud() == k && path.endsWith(target)) {
                finalPaths.add(path);
            }
        }
        return finalPaths;
    }

    private List<Path> paths(Vertex source, Graph graph, KComparation kcompare) {
        List<Path> paths = new ArrayList<>();
        Queue<VertexWithPath> pending = new LinkedList<>();
        pending.offer(new VertexWithPath(source));
        int edgesNumber = 0;
        while (!pending.isEmpty()) {
            VertexWithPath u = pending.poll();
            Edges edges = graph.edges(u.vertex);
            edgesNumber = edgesNumber + 1;
            for (Edge edge : edges) {
                Path currentPath = new Path(u.path, edge.getTarget(), edge.getWeight());
                paths.add(currentPath);
                if (kcompare.apply(edgesNumber)) {
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


    private interface KComparation extends Function<Integer, Boolean> {
    }

    private static class KEqual implements KComparation {

        private final int k;

        public KEqual(int k) {
            this.k = k;
        }

        @Override
        public Boolean apply(Integer kth) {
            return kth < k;
        }
    }

    private static class KEqualOrLess implements KComparation {

        private final int k;

        public KEqualOrLess(int k) {
            this.k = k;
        }

        @Override
        public Boolean apply(Integer kth) {
            return kth <= k;
        }
    }

}
