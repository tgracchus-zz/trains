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
        List<Path> allpaths = paths(source, graph, new AlwaysAdd(), new PathLengthEqualOrLess(k));
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
        List<Path> allpaths = paths(source, graph, new AlwaysAdd(), new PathLengthEqualOrLess(k));
        List<Path> finalPaths = new ArrayList<>();
        for (Path path : allpaths) {
            if (path.longitud() == k && path.endsWith(target)) {
                finalPaths.add(path);
            }
        }
        return finalPaths;
    }

    @Override
    public List<Path> pathsWeightEqualsTo(int weight, Vertex source, Vertex target, Graph graph) {
        List<Path> allpaths = paths(source, graph, new AddIfWeightEqualOrLess(weight), new AddIfWeightEqualOrLess(weight));
        List<Path> finalPaths = new ArrayList<>();
        for (Path path : allpaths) {
            if (path.endsWith(target)) {
                finalPaths.add(path);
            }
        }
        return finalPaths;
    }

    private List<Path> paths(Vertex source, Graph graph, PathFunction addFunction, PathFunction continueFunction) {
        List<Path> paths = new ArrayList<>();
        Queue<VertexWithPath> pending = new LinkedList<>();
        pending.offer(new VertexWithPath(source));
        while (!pending.isEmpty()) {
            VertexWithPath u = pending.poll();
            Edges edges = graph.edges(u.vertex);
            for (Edge edge : edges) {
                Path currentPath = new Path(u.path, edge.getTarget(), edge.getWeight());
                if (addFunction.apply(currentPath)) {
                    paths.add(currentPath);
                }
                if (continueFunction.apply(currentPath)) {
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


    private interface PathFunction extends Function<Path, Boolean> {
    }

    private static class AlwaysAdd implements PathFunction {

        @Override
        public Boolean apply(Path currentPath) {
            return true;
        }
    }


    private static class PathLengthEqualOrLess implements PathFunction {

        private final int k;

        public PathLengthEqualOrLess(int k) {
            this.k = k;
        }

        @Override
        public Boolean apply(Path currentPath) {
            return currentPath.longitud() <= k;
        }
    }

    private static class AddIfWeightEqualOrLess implements PathFunction {

        private final int maxWeight;

        public AddIfWeightEqualOrLess(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        @Override
        public Boolean apply(Path currentPath) {
            return currentPath.weight() < maxWeight;
        }
    }

}
