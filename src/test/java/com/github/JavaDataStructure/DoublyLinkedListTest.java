package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class DoublyLinkedListTest {
    @Test
    public void TestEmptyConstructor(){
        DoublyLinkedList<String> test = new DoublyLinkedList<>();
        assertThat(test.getsize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        assertThat(test.getHead(), nullValue());
        assertThat(test.getTail(), nullValue());
    }
    @Test
    public void ConstructorContainer(){
        DoublyLinkedList<String> TestStr = new DoublyLinkedList<>("ABC");     // Testing of functions in a non-empty list
        assertThat(TestStr.getHead().getContent(), instanceOf(String.class));
        assertThat(TestStr.getTail().getContent(), instanceOf(String.class));
        assertThat(TestStr.getsize(), is(equalTo(1)));
        assertThat(TestStr.getHead(), is(equalTo(TestStr.getTail())));
        assertThat(TestStr.isEmpty(), is(equalTo(false)));

        TestStr.getHead().setContent("XYZ");    // Test to show functions in class SimpleNode were inherited in class Doubly linked list
        assertThat(TestStr.getHead().getContent(), is(equalTo("XYZ")));
        TestStr.getHead().setContent();
        assertThat(TestStr.getHead().getContent(), nullValue());

        DoublyLinkedList<Character> TestChar = new DoublyLinkedList<>('X');     // Container test for other data types
        assertThat(TestChar.getHead().getContent(), instanceOf(Character.class));
        DoublyLinkedList<Integer> TestInt = new DoublyLinkedList<>(100);
        assertThat(TestInt.getHead().getContent(), instanceOf(Integer.class));
        DoublyLinkedList<Double> TestDouble = new DoublyLinkedList<>(1.2345);
        assertThat(TestDouble.getHead().getContent(), instanceOf(Double.class));
        DoublyLinkedList<Boolean> TestBool = new DoublyLinkedList<>(true);
        assertThat(TestBool.getHead().getContent(), instanceOf(Boolean.class));
    }
    @Test
    public void AppendElement(){
        DoublyLinkedList<String> test = new DoublyLinkedList<>("AAA");
        test.append("BBBB");
        test.append("CCC");
        test.append("DDDD");
        assertThat(test.getHead().getContent(), is(equalTo("AAA")));
        assertThat(test.getTail().getContent(), is(equalTo("DDDD")));
        assertThat(test.getsize(), is(equalTo(4)));

    }
    @Test
    public void PrintList(){
        DoublyLinkedList<Integer> test = new DoublyLinkedList<>(192);
        test.append(168);
        test.append(0);
        test.append(1);
        ByteArrayOutputStream printout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printout));
        test.printList();
        assertThat(printout.toString(), is("[192, 168, 0, 1]\r\n"));
    }
    @Test
    public void PrependElement(){
        DoublyLinkedList<Double> test = new DoublyLinkedList<>(1.2345);
        test.prepend(2.3456);
        test.prepend(3.4567);
        assertThat(test.getHead().getContent(), is(equalTo(3.4567)));
        assertThat(test.getTail().getContent(), is(equalTo(1.2345)));
        assertThat(test.getsize(), is(equalTo(3)));
    }
    @Test
    public void InsertElement(){
        DoublyLinkedList<Character> test = new DoublyLinkedList<>('W');
        test.append('X');
        test.prepend('Y');
        test.append('Z');
        try {
            test.insert('A', 10);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is(equalTo("Invalid index input")));     // Testing invalid index
        }
        test.insert('A', 2);
        assertThat(test.getsize(), is(equalTo(5)));
        ByteArrayOutputStream printout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printout));
        test.printList();
        assertThat(printout.toString(), is("[Y, W, A, X, Z]\r\n"));
    }
    @Test
    public void DeleteElement(){
        DoublyLinkedList<Float> test = new DoublyLinkedList<>(1.111f);
        test.prepend(2.222f);
        test.append(3.333f);
        test.prepend(4.444f);
        test.append(5.555f);
        try {
            test.delete(20);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is(equalTo("Invalid index input")));     // Testing invalid index
        }
        test.delete(3);
        assertThat(test.getsize(), is(equalTo(4)));
        ByteArrayOutputStream printout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printout));
        test.printList();
        assertThat(printout.toString(), is("[4.444, 2.222, 1.111, 5.555]\r\n"));
    }
    @Test
    public void ClearList(){
        DoublyLinkedList<String> test = new DoublyLinkedList<>("A");
        test.append("BB");
        test.append("CCC");
        test.append("DDDD");
        assertThat(test.getsize(), is(equalTo(4)));
        test.clear();
        assertThat(test.getsize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        assertThat(test.getHead(), nullValue());
        assertThat(test.getTail(), nullValue());
    }
}
