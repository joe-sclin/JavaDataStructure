package com.github.JavaDataStructure;

public abstract class BasicNode<T> {
    protected T content;
    protected BasicNode<T> successor;
    protected BasicNode<T> predecessor;
    public abstract T getContent();
    public abstract BasicNode<T> getSuccessor();
    public abstract BasicNode<T> getPredecessor();
}
