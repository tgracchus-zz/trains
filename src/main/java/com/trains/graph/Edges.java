package com.trains.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class Edges implements List<Edge> {
    private final List<Edge> edges;

    public Edges() {
        this.edges = new ArrayList<>();
    }

    public void putIfAbsent(Edge edge) {
        Objects.requireNonNull(edge);
        int index = edges.indexOf(edge);
        if (index < 0) {
            edges.add(edge);
        } else {
            edges.set(index, edge);
        }
    }

    public Optional<Edge> traverseTo(Vertex vertex) {
        for (Edge edge : edges) {
            if (edge.isTarget(vertex)) {
                return Optional.of(edge);
            }
        }
        return Optional.empty();
    }


    @Override
    public int size() {
        return edges.size();
    }

    @Override
    public boolean isEmpty() {
        return edges.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return edges.contains(o);
    }

    @Override
    public Iterator<Edge> iterator() {
        return edges.iterator();
    }

    @Override
    public Object[] toArray() {
        return edges.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return edges.toArray(a);
    }

    @Override
    public boolean add(Edge edge) {
        return edges.add(edge);
    }


    @Override
    public boolean remove(Object o) {
        return edges.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return edges.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Edge> c) {
        return edges.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Edge> c) {
        return edges.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return edges.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return edges.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<Edge> operator) {
        edges.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Edge> c) {
        edges.sort(c);
    }

    @Override
    public void clear() {
        edges.clear();
    }

    @Override
    public boolean equals(Object o) {
        return edges.equals(o);
    }

    @Override
    public int hashCode() {
        return edges.hashCode();
    }

    @Override
    public Edge get(int index) {
        return edges.get(index);
    }

    @Override
    public Edge set(int index, Edge element) {
        return edges.set(index, element);
    }

    @Override
    public void add(int index, Edge element) {
        edges.add(index, element);
    }

    @Override
    public Edge remove(int index) {
        return edges.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return edges.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return edges.lastIndexOf(o);
    }

    @Override
    public ListIterator<Edge> listIterator() {
        return edges.listIterator();
    }

    @Override
    public ListIterator<Edge> listIterator(int index) {
        return edges.listIterator(index);
    }

    @Override
    public List<Edge> subList(int fromIndex, int toIndex) {
        return edges.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<Edge> spliterator() {
        return edges.spliterator();
    }


}
