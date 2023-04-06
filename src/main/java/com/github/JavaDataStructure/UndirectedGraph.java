package com.github.JavaDataStructure;

public class UndirectedGraph<T> extends DirectedGraph<T> {
    @Override
    public void addEdge(T from, T to) {
        if (!checkNodeexist(from)) {
            throw new IllegalArgumentException("Graph does not contain node " + from);
        } else if (!checkNodeexist(to)) {
            throw new IllegalArgumentException("Graph does not contain node " + to);
        } else {
            if (!checkEdgeexist(from, to)) {
                getNode(from).setSuccessor(getNode(to));
                getNode(to).setSuccessor(getNode(from));    // Adding reversed edge for undirected graph
            }
        }
    }
}
