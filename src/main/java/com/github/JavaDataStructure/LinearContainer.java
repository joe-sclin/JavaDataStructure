package com.github.JavaDataStructure;

public class LinearContainer<T>{
    protected static class SequentialNode<T> extends BasicNode<T>{   // Demonstration of inner class for a functional Node (Abstract class cannot be initialised)
        @Override
        public T getContent() {
            return content;
        }
        @Override
        public SequentialNode<T> getSuccessor() {
            return (SequentialNode<T>) successor;
        }
        @Override
        public SequentialNode<T> getPredecessor() {
            return (SequentialNode<T>) predecessor;
        }
        public void setSuccessor(SequentialNode<T> newData){
            successor = newData;
        }
        public void setPredecessor(SequentialNode<T> newData){
            predecessor = newData;
        }
        public SequentialNode(){
            content = null;
        }
        public SequentialNode(T InputData){
            content = InputData;
        }
    }
    protected int size;
    protected SequentialNode<T> Top;
    protected SequentialNode<T> Bottom;
    public int getsize(){
        return size;
    }
    public SequentialNode<T> peek(){
        return Top;
    }
    public Boolean isEmpty(){
        return (size == 0);
    }
}
