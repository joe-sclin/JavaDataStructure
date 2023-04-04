package com.github.JavaDataStructure;

public class Queue<T> extends LinearContainer<T> {  // Implementation of Stack is modified from Stack and DoublyLinkedList
    public Queue(){
        Top = null;
        size = 0;
    }
    public Queue(T InputData){
        SequentialNode<T> temp = new SequentialNode<>(InputData);
        size = 1;
        Top = temp;
        Bottom = temp;
    }
    public void add(T newData){
        SequentialNode<T> temp = new SequentialNode<>(newData);
        if (size > 0) {
            Bottom.setSuccessor(temp);
            temp.setPredecessor(Bottom);
        } else {    // Empty queue
            Top = temp;
        }
        Bottom = temp;
        size ++;
    }
    public void remove(){
        if (size == 0) {
            throw new RuntimeException("This is an empty Queue.");
        } else {
            Top = Top.getSuccessor();
            size --;
        }
    }
}
