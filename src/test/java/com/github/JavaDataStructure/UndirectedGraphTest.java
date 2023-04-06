package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UndirectedGraphTest {
    /*
    Undirected graph is basically as same as Directed Graph, only checking addEdge function
     */
    @Test
    public void TestaddEdge() {
        UndirectedGraph<String> test = new UndirectedGraph<>();
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
        Set<String> testrevedge = new HashSet<>();
        testrevedge.add("ABC");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));      // Successfully to add a new edge
        assertThat(test.getEdge("DEF"), is(equalTo(testrevedge)));      // Reversed edge are also added
        test.addEdge("ABC", "DEF");     // Adding duplicated edge has no effect
        test.addEdge("ABC", "ABC");
        testedge.add("ABC");
        assertThat(test.getEdge("ABC"), is(equalTo(testedge)));      // Self edge is allowed
    }
}