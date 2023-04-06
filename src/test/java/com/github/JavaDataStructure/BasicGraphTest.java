package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class BasicGraphTest {
    @Test
    public void TestConstructor() {     // Test of constructor and basic functions of Graph
        BasicGraph<String> test = new BasicGraph<>();
        assertThat(test.getSize(), is(equalTo(0)));
        assertThat(test.getNodeList(), is(equalTo(new HashSet<>())));
        assertThat(test.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void TestAddNode() {     // Test of constructor and basic functions of Graph
        BasicGraph<String> test = new BasicGraph<>();
        test.addNode("ABC");
        assertThat(test.getSize(), is(equalTo(1)));
        assertThat(test.isEmpty(), is(equalTo(false)));
        Set<String> testnode = new HashSet<>();
        testnode.add("ABC");
        assertThat(test.getNodeList(), is(equalTo(testnode)));      // Successfully to add a new node
        assertThat(test.checkNodeexist("ABC"), is(equalTo(true)));
        assertThat(test.checkNodeexist("A"), is(equalTo(false)));
        try {
            test.addNode("ABC");    // Error message when duplicated node is added
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph already contains this node, duplicated content of nodes is not allowed.")));     // Testing invalid node content
        }
        assertThat(test.getSize(), is(equalTo(1)));
        test.addNode("AB");     // Repeatedly adding new node (duplicated checking is for exact match only)
        test.addNode("A");
        assertThat(test.getSize(), is(equalTo(3)));
    }

    @Test
    public void TestRemoveNode() {
        BasicGraph<String> test = new BasicGraph<>();
        try {
            test.removeNode("ABC");    // Testing invalid egde cases
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("This is an empty Graph.")));
        }
        test.addNode("ABC");
        test.addNode("DEF");
        test.addNode("GHI");
        try {
            test.removeNode("A");    // Error message when invalid node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph does not contains this node.")));     // Testing invalid egde cases
        }
        assertThat(test.getSize(), is(equalTo(3)));
        test.removeNode("ABC");
        assertThat(test.getSize(), is(equalTo(2)));
        test.removeNode("DEF");
        assertThat(test.getSize(), is(equalTo(1)));
        test.removeNode("GHI");
        assertThat(test.getSize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        try {
            test.removeNode("ABC");    // Error message when invalid node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("This is an empty Graph.")));     // Testing invalid egde cases
        }
    }

    @Test
    public void TestgetEdge() {
        BasicGraph<String> test = new BasicGraph<>();
        test.addNode("ABC");
        assertThat(test.getEdge("ABC"), is(equalTo(new HashSet<>())));
        try {
            test.getEdge("DEF");    // Error message when invalid node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph does not contains this node.")));     // Testing invalid egde cases
        }
    }

    @Test
    public void TestaddEdge() {
        BasicGraph<String> test = new BasicGraph<>();
        test.addNode("ABC");
        test.addNode("DEF");
        try {
            test.addEdge("XYZ", "ABC");    // Error message when invalid "from" node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph does not contain node XYZ")));     // Testing invalid egde cases
        }
        try {
            test.addEdge("ABC", "CBA");    // Error message when invalid "to" node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph does not contain node CBA")));     // Testing invalid egde cases
        }
        test.addEdge("ABC", "DEF");
        Set<String> testedge = new HashSet<>();
        testedge.add("DEF");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));      // Successfully to add a new edge
        assertThat(test.getEdge("DEF"), is(equalTo(new HashSet<>())));      // It is a directed Graph
        test.addEdge("ABC", "DEF");     // Adding duplicated edge has no effect
        test.addEdge("ABC", "ABC");
        testedge.add("ABC");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));      // Self edge is allowed
    }

    @Test
    public void TestremoveEdge() {
        BasicGraph<String> test = new BasicGraph<>();
        test.addNode("ABC");
        test.addNode("DEF");
        test.addNode("GHI");
        test.addEdge("ABC", "DEF");
        test.addEdge("ABC", "GHI");
        test.addEdge("DEF", "GHI");
        try {
            test.removeEdge("XYZ", "ABC");    // Error message when invalid "from" node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("Graph does not contain node XYZ")));     // Testing invalid egde cases
        }
        try {
            test.removeEdge("DEF", "ABC");    // Error message when invalid "from" node content input
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(equalTo("No edges exists between node DEF and node ABC")));     // Testing invalid egde cases
        }
        Set<String> testedge = new HashSet<>();
        testedge.add("DEF");
        testedge.add("GHI");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));
        test.removeEdge("ABC", "DEF");
        testedge.remove("DEF");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));
        test.removeEdge("ABC", "GHI");
        assertThat(test.getEdge("ABC"), is(equalTo(new HashSet<>())));
    }
    @Test
    public void TestclearGraph(){
        BasicGraph<String> test = new BasicGraph<>();
        test.addNode("ABC");
        test.addNode("DEF");
        test.addNode("GHI");
        test.addEdge("ABC", "DEF");
        test.addEdge("ABC", "GHI");
        test.addEdge("DEF", "GHI");
        test.clearGraph();
        assertThat(test.getSize(), is(equalTo(0)));
        assertThat(test.getNodeList(), is(equalTo(new HashSet<>())));
        assertThat(test.isEmpty(), is(equalTo(true)));

    }
}