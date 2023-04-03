package com.github.JavaDataStructure;

public class SimpleNode<T> {
    private T content;
    private SimpleNode<T> successor;
    private SimpleNode<T> predecessor;
    public T getContent() {
        return content;
    }
    public void setContent(T content){
        if (content == null){
            throw new IllegalArgumentException("Input content is null.");
        }
        this.content = content;
    }
    public void setContent(){
        this.content = null;
    }
    public SimpleNode<T> getSuccessor() {
        return successor;
    }
    public void setSuccessor(SimpleNode<T> successor){
        if (successor == null){
            throw new IllegalArgumentException("Input successor node is null.");
        }
        successor.predecessor = this;
        this.successor = successor;
    }
    public void setSuccessor(){
        this.successor = null;
    }
    public SimpleNode<T> getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(SimpleNode<T> predecessor){
        if (predecessor == null){
            throw new IllegalArgumentException("Input predecessor node is null.");
        }
        predecessor.successor = this;
        this.predecessor = predecessor;
    }
    public void setPredecessor(){
        this.predecessor = null;
    }
    public SimpleNode() {   // Empty constructor
        content = null;
        successor = null;
        predecessor = null;
    }
    public SimpleNode(T input_data) {   // General constructor
        content = input_data;
        successor = null;
        predecessor = null;
    }
}
