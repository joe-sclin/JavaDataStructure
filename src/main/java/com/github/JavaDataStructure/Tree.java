package com.github.JavaDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Tree<T> {
    // Tree is a specific form of directed graph, with no cyclic edges and self loop
    protected class TreeNode<T> extends SimpleNode<T> {     // Example to extend inner class inside subclass
        private int level;
        private Set<TreeNode<T>> successor;     // Each TreeNode has 1 parent, but have >= 1 child

        public int getLevel() {
            return level;
        }

        private void setLevel(int newlevel) {
            level = newlevel;
        }

        public Set<TreeNode<T>> getNodeSuccessor() {
            return successor;
        }

        public void setSuccessor(TreeNode<T> newNode) {
            successor.add(newNode);
        }
        public void removeSuccessor(TreeNode<T> removal) {
            successor.remove(removal);
        }

        public TreeNode(T input_data) {
            content = input_data;
            successor = new HashSet<>();
            level = 0;
        }
    }

    private HashMap<T, TreeNode<T>> nodeList;
    private TreeNode<T> root;

    public Tree(T input_data) {     // Constructor of tree must have the first node (Root)
        TreeNode<T> temp = new TreeNode<>(input_data);
        root = temp;
        nodeList = new HashMap<>();
        nodeList.put(input_data, temp);
    }

    public Boolean checkNodeexist(T input_data) {
        return (nodeList.containsKey(input_data));
    }

    private TreeNode<T> getNode(T input_data) {   // Internal function for adding and removing edges
        if (checkNodeexist(input_data)) {
            return this.nodeList.get(input_data);
        } else {
            throw new IllegalArgumentException("Graph does not contain this node.");
        }
    }

    public int getSize() {
        return nodeList.keySet().size();
    }

    public T getRoot() {
        return root.getContent();
    }
    public Set<T> getnodeList(){
        return nodeList.keySet();
    }
    public int getLevel(T input_data) {
        if (!checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Tree does not contain this node.");
        } else {
            return this.getNode(input_data).level;
        }
    }

    public void addNode(T input_data, T parent) {   // Node added to tree must be connected to a parent node
        if (checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Tree already contains this node, duplicated content of nodes is not allowed.");
        } else if (!checkNodeexist(parent)) {
            throw new IllegalArgumentException("Tree does not contain this parent node.");
        } else {    // Above if statement checking avoid self edge and duplicated edge (input_data not in Tree + parent in Tree)
            TreeNode<T> newNode = new TreeNode<>(input_data);
            nodeList.put(input_data, newNode);
            this.getNode(parent).setSuccessor(newNode);
            newNode.setPredecessor(this.getNode(parent));
            newNode.setLevel(this.getNode(parent).getLevel() + 1);
        }
    }
    public void removeNode(T input_data) {       // Recursive function to remove all child node of node input_data
        if (!checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Tree does not contain this node.");
        } else if (this.getRoot() == input_data) {
            throw new IllegalArgumentException("Cannot remove Root node.");
        } else {
            TreeNode<T> nodeToRemove = this.getNode(input_data);
            for (TreeNode<T> node : nodeToRemove.getNodeSuccessor()) {  // Recursive until reaching leave node (No successors)
                removeNode(node.getContent());
            }
            nodeList.remove(nodeToRemove.getContent());
        }
    }

    public HashSet<T> getChild(T input_data) {
        if (!checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Tree does not contain this node.");
        } else {
            HashSet<T> output = new HashSet<>();
            for (TreeNode<T> node : this.getNode(input_data).getNodeSuccessor()){
                output.add(node.content);
            }
            return output;
        }
    }
    public T getParent(T input_data){
        if (!checkNodeexist(input_data)) {
            throw new IllegalArgumentException("Tree does not contain this node.");
        } else {
            if (this.getNode(input_data).level == 0) {
                return null;
            } else {
                return this.getNode(input_data).getPredecessor().content;
            }
        }
    }
    public void printTree(T input_data){
        if (this.getNode(input_data) != null) {
            for (int i = 0; i < this.getNode(input_data).getLevel(); i++) {     // Line represented Tree structure
                if (i == this.getNode(input_data).getLevel() - 1) {
                    System.out.print("|---");   // length of --- equals to \t
                } else {
                    System.out.print("|\t");
                }
            }
            System.out.println(this.getNode(input_data).getContent());  // Node content
            for (TreeNode<T> ChildNode : this.getNode(input_data).getNodeSuccessor()) {
                if (checkNodeexist(ChildNode.getContent())) {
                    printTree(ChildNode.getContent());
                }
            }
        }
    }
}
