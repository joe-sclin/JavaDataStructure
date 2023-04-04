package com.github.JavaDataStructure;

public class SimpleNode<T> extends BasicNode<T> {
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
    @Override
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
    @Override
    public SimpleNode<T> getSuccessor() {
        return (SimpleNode<T>) successor;
    }
    public void setSuccessor(SimpleNode<T> successor){
        if (successor == null){
            throw new IllegalArgumentException("Input successor node is null.");
        }
        successor.predecessor = this;
        this.successor = successor;
    }
    @Override
    public SimpleNode<T> getPredecessor() {
        return (SimpleNode<T>) predecessor;
    }
    public void setPredecessor(SimpleNode<T> predecessor){
        if (predecessor == null){
            throw new IllegalArgumentException("Input predecessor node is null.");
        }
        predecessor.successor = this;
        this.predecessor = predecessor;
    }
}
