package com.github.JavaDataStructure;

public class Stack<T> extends LinearContainer<T> {
    public Stack(){
        Top = null;
        size = 0;
}
    public Stack(T InputData){
        SequentialNode<T> temp = new SequentialNode<>(InputData);
        size = 1;
        Top = temp;
    }
    public void push(T newData){
        SequentialNode<T> temp = new SequentialNode<>(newData);
        if (size > 0) {
            Top.setSuccessor(temp);
            temp.setPredecessor(Top);
        }
        Top = temp;
        size ++;
    }
    public void pop(){
        if (size == 0) {
            throw new RuntimeException("This is an empty stack.");
        } else {
            Top = Top.getPredecessor();
            size --;
        }
    }
}