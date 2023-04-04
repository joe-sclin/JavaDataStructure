package com.github.JavaDataStructure;

public class DoublyLinkedList<T> extends SimpleNode<T> {    // inherit simple node class -> linked list
    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;
    public DoublyLinkedList() {     // Empty constructor
        size = 0;
        head = null;
        tail = null;
    }
    public DoublyLinkedList(T input_data) {     // constructor with first node
        SimpleNode<T> temp = new SimpleNode<>(input_data);
        size = 1;
        head = temp;
        tail = temp;
    }
    public SimpleNode<T> getHead(){
        return head;
    }
    public SimpleNode<T> getTail(){
        return tail;
    }
    public int getsize(){
        return size;
    }
    public boolean isEmpty(){   // Check empty list (For append / prepend)
        return head == null;
    }
    public void clear(){   // Remove all nodes
        head = null;
        tail = null;
        size = 0;
    }
    public void append(T input){
        SimpleNode<T> new_node = new SimpleNode<>(input);
        if (isEmpty()){
            head = new_node;
        } else {
            tail.setSuccessor(new_node);
        }
        tail = new_node;
        size ++;
    }
    public void prepend(T input){
        SimpleNode<T> new_node = new SimpleNode<>(input);
        if (isEmpty()){
            head = new_node;
            tail = new_node;
        } else {
            head.setPredecessor(new_node);
            head = new_node;
        }
        size ++;
    }
    public void printList() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            SimpleNode<T> current_node = head;  // First node
            while (current_node != tail) {
                System.out.print(current_node.getContent());
                current_node = current_node.getSuccessor();
                System.out.print(", ");
            }
            System.out.println(current_node.getContent() + "]");  // Last node
        }
    }
    public void insert(T input_data, int index){     // index starts at 0, index of new node after insertion = index
        if ((index > size) || (index < 0)){
            throw new IndexOutOfBoundsException("Invalid index input");
        } else {
            if (index == 0) {
                prepend(input_data);
            } else if (index == size) {
                append(input_data);
            } else {
                SimpleNode<T> pre_insert_node = head;
                for (int i = 0; i < index - 1; i++) {
                    pre_insert_node = pre_insert_node.getSuccessor();
                }
                SimpleNode<T> post_insert_node = pre_insert_node.getSuccessor();
                SimpleNode<T> new_node = new SimpleNode<>(input_data);
                new_node.setPredecessor(pre_insert_node);
                new_node.setSuccessor(post_insert_node);
            }
            size ++;
        }
    }
    public void delete(int index) {
        if ((index > size - 1) || (index < 0)) {
            throw new IndexOutOfBoundsException("Invalid index input");
        } else {
            if (index == 0) {
                head = head.getSuccessor();
            } else if (index == size - 1) {
                tail = tail.getPredecessor();
            } else {
                SimpleNode<T> pre_delete_node = head;
                for (int i = 0; i < index - 1; i++) {
                    pre_delete_node = pre_delete_node.getSuccessor();
                }
                pre_delete_node.setSuccessor(pre_delete_node.getSuccessor().getSuccessor());
            }
            size --;
        }
    }
}