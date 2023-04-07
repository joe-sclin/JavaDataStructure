package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class TreeTest {
    @Test
    public void TestConstructor() {     // Test of constructor and basic functions of Graph
        Tree<String> test = new Tree<>("A");
        assertThat(test.getSize(), is(equalTo(1)));
        assertThat(test.getLevel("A"), is(equalTo(0)));
        assertThat(test.checkNodeexist("AB"), is(equalTo(false)));
        assertThat(test.checkNodeexist("A"), is(equalTo(true)));
        assertThat(test.getRoot(), is(equalTo("A")));
    }
    @Test
    public void TestaddNode(){
        Tree<Integer> test = new Tree<>(1);
        test.addNode(2,1);
        test.addNode(3,1);
        test.addNode(4,2);
        assertThat(test.getLevel(1), is(equalTo(0)));
        assertThat(test.getLevel(2), is(equalTo(1)));
        assertThat(test.getLevel(3), is(equalTo(1)));
        assertThat(test.getLevel(4), is(equalTo(2)));
        assertThat(test.getSize(), is(equalTo(4)));
        Set<Integer> testnode = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        assertThat(test.getnodeList(), is(equalTo(testnode)));
        try {
            test.addNode(2, 4);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Tree already contains this node, duplicated content of nodes is not allowed.")));     // Testing invalid egde cases
        }
        try {
            test.addNode(5, 6);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Tree does not contain this parent node.")));     // Testing invalid egde cases
        }
    }
    @Test
    public void TestgetChild(){
        Tree<Integer> test = new Tree<>(1);
        test.addNode(2,1);
        test.addNode(3,1);
        test.addNode(4,2);
        Set<Integer> testchild = new HashSet<>();
        assertThat(test.getChild(4), is(equalTo(testchild)));   // Leave node has no child
        testchild.add(2);
        testchild.add(3);
        assertThat(test.getChild(1), is(equalTo(testchild)));
        try {
            test.getChild(5);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Tree does not contain this node.")));     // Testing invalid egde cases
        }
    }
    @Test
    public void TestgetParent(){
        Tree<Integer> test = new Tree<>(1);
        test.addNode(2,1);
        test.addNode(3,1);
        test.addNode(4,2);
        assertThat(test.getParent(1), is(nullValue()));
        assertThat(test.getParent(2), is(equalTo(1)));
        assertThat(test.getParent(3), is(equalTo(1)));
        assertThat(test.getParent(4), is(equalTo(2)));
        try {
            test.getParent(5);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Tree does not contain this node.")));     // Testing invalid egde cases
        }
    }
    @Test
    public void TestRemoveNode(){
        Tree<Integer> test = new Tree<>(1);
        test.addNode(2,1);
        test.addNode(3,1);
        test.addNode(4,1);
        test.addNode(5,1);
        test.addNode(6,2);
        test.addNode(7,2);
        test.addNode(14,7);
        test.addNode(8,3);
        test.addNode(9,3);
        test.addNode(10,3);
        test.addNode(11,5);
        test.addNode(12,5);
        test.addNode(13,5);
        assertThat(test.getSize(), is(equalTo(14)));
        try {
            test.removeNode(15);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Tree does not contain this node.")));     // Testing invalid egde cases
        }
        try {
            test.getParent(1);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Cannot remove Root node.")));     // Testing invalid egde cases
        }
        test.removeNode(14);
        assertThat(test.getSize(), is(equalTo(13)));
        test.removeNode(3);
        assertThat(test.getSize(), is(equalTo(9)));
        assertThat(test.checkNodeexist(8), is(equalTo(false)));     // Child of a removed node are absent in Tree
        assertThat(test.checkNodeexist(2), is(equalTo(true)));  // Other nodes are not affected
        test.removeNode(5);     // Remove more child node to make Tree simpler for printTree test
        ByteArrayOutputStream printout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printout));
        test.printTree(test.getRoot());
        assertThat(printout.toString(), is("1\r\n|---4\r\n|---2\r\n|\t|---6\r\n|\t|---7\r\n"));
    }
}