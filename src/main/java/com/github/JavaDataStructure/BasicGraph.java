package com.github.JavaDataStructure;
//import java.util.ArrayList;
import java.util.*;

public class BasicGraph<T> {
    private static class GraphNode<T> extends BasicNode<T> {
        /*
        Extends BasicNode class to create GraphNode is not the best choice for implementation in practical
        It is only a demonstration of implementing an abstract class, and Polymorphism
        Implement from scratch using ArrayList is more simple
         */
        private Set<GraphNode<T>> successor;    // Polymorphism: successor with different datatype in GraphNode class

        public GraphNode(T inputData) {
            content = inputData;
            successor = new HashSet<>();
        }

        @Override
        public T getContent() {
            return content;
        }

        @Override
        public BasicNode<T> getSuccessor() {
            return null;
        }   // Not useful in Data structure Graph

        @Override
        public BasicNode<T> getPredecessor() {
            return null;
        }   // Not useful in Data structure Graph

        public Set<GraphNode<T>> getNodeSuccessor() {
            return successor;
        }

        public void setSuccessor(GraphNode<T> newNode) {
            successor.add(newNode);
        }
    }

    private HashMap<T, GraphNode<T>> nodeList;  // Map to store node (key = content of node, value = GraphNode object)

    public BasicGraph() {        // Constructor to create an empty graph
        nodeList = new HashMap<>();
    }

    public Set<T> getNodeList() {
        return nodeList.keySet();
    }

    public int getSize() {
        return nodeList.keySet().size();
    }
    public Boolean isEmpty(){
        return (this.getSize() == 0);
    }
    public void clearGraph(){
        this.nodeList.clear();
    }

    public void addNode(T input_data) {
        if (checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Graph already contains this node, duplicated content of nodes is not allowed.");
        } else {
            GraphNode<T> newNode = new GraphNode<>(input_data);
            nodeList.put(input_data, newNode);
        }
    }

    public void removeNode(T input_data) {
        if (this.getSize() == 0) {
            throw new IllegalArgumentException("This is an empty Graph.");
        } else {
            if (checkNodeexist(input_data)) {
                nodeList.remove(input_data);
            } else {
                throw new IllegalArgumentException("Graph does not contains this node.");
            }
        }
    }

    public Boolean checkNodeexist(T input_data) {
        return (nodeList.containsKey(input_data));
    }

    private GraphNode<T> getNode(T input_data) {   // Internal function for adding and removing edges
        if (checkNodeexist(input_data)) {
            return this.nodeList.get(input_data);
        } else {
            throw new IllegalArgumentException("Graph does not contains this node.");
        }
    }

    public Set<T> getEdge(T input_data) {
        if (!checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Graph does not contains this node.");
        } else {
            Set<T> output = new HashSet<>();
            for (GraphNode<T> target : getNode(input_data).getNodeSuccessor()) {
                output.add(target.getContent());
            }
            return output;
        }
    }

    public void addEdge(T from, T to) {
        if (!checkNodeexist(from)) {
            throw new IllegalArgumentException("Graph does not contain node " + from);
        } else if (!checkNodeexist(to)) {
            throw new IllegalArgumentException("Graph does not contain node " + to);
        } else {
            if (!checkEdgeexist(from, to)) {  // Not adding duplicated edges (But not an error)
                getNode(from).setSuccessor(getNode(to));
            }
        }
    }

    public Boolean checkEdgeexist(T from, T to) {
        if (!checkNodeexist(from)) {
            throw new IllegalArgumentException("Graph does not contain node " + from);
        } else if (!checkNodeexist(to)) {
            throw new IllegalArgumentException("Graph does not contain node " + to);
        } else {
            return getNode(from).getNodeSuccessor().contains(getNode(to));
        }
    }
    public void removeEdge(T from, T to) {
        if (!checkNodeexist(from)) {
            throw new IllegalArgumentException("Graph does not contain node " + from);
        } else if (!checkNodeexist(to)) {
            throw new IllegalArgumentException("Graph does not contain node " + to);
        } else if (!checkEdgeexist(from, to)) {
            throw new IllegalArgumentException("No edges exists between node " + from + " and node " + to);
        } else {
            getNode(from).getNodeSuccessor().remove(getNode(to));
        }
    }
}