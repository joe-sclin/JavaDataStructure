package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoublyLinkedListTest {
    @Test
    public void TestEmptyConstructor(){
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        SimpleNode<String> head = test.getHead();
        SimpleNode<String> tail = test.getTail();
        assertThat(test.getsize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        assertThat(test.getHead(), is(nullValue()));
        assertThat(test.getTail(), is(nullValue()));
    }
    @Test
    public void ConstructorContainer(){
        DoublyLinkedList<String> test = new DoublyLinkedList<String>("A");
        assertThat(test.getHead().getContent(), is(equalTo("A")));
        assertThat(test.getTail().getContent(), is(equalTo("A")));
        assertThat(test.getsize(), is(equalTo(1)));
        assertThat(test.getHead(), is(equalTo(test.getTail())));
    }
}
