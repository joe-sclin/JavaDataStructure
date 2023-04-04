package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class StackTest {
    @Test
    public void TestEmptyConstructor(){     // Test of empty constructor and basic functions of Stack
        Stack<String> test = new Stack<>();
        assertThat(test.getsize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        assertThat(test.peek(), nullValue());
    }
    @Test
    public void ConstructorContainer(){     // Test of constructors for datatypes and basic functions of Stack
        Stack<String> TestStr = new Stack<>("ABC");
        assertThat(TestStr.getsize(), is(equalTo(1)));
        assertThat(TestStr.isEmpty(), is(equalTo(false)));
        assertThat(TestStr.peek().getContent(), instanceOf(String.class));

        Stack<Character> TestChar = new Stack<>('X');
        assertThat(TestChar.peek().getContent(), instanceOf(Character.class));
        Stack<Integer> TestInt = new Stack<>(100);
        assertThat(TestInt.peek().getContent(), instanceOf(Integer.class));
        Stack<Double> TestDouble = new Stack<>(1.2345);
        assertThat(TestDouble.peek().getContent(), instanceOf(Double.class));
        Stack<Boolean> TestBool = new Stack<>(true);
        assertThat(TestBool.peek().getContent(), instanceOf(Boolean.class));
    }

    @Test
    public void Push(){
        Stack<Integer> TestInt = new Stack<>();    // Push function starts with empty Stack
        TestInt.push(192);
        TestInt.push(168);
        TestInt.push(0);
        TestInt.push(1);
        assertThat(TestInt.getsize(), is(equalTo(4)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(1)));

        Stack<String> TestStr = new Stack<>("WWWW");
        TestStr.push("XXX");
        TestStr.push("YY");
        assertThat(TestStr.getsize(), is(equalTo(3)));
        assertThat(TestStr.isEmpty(), is(equalTo(false)));
        assertThat(TestStr.peek().getContent(), is(equalTo("YY")));
        assertThat(TestStr.peek().getPredecessor().getContent(), is(equalTo("XXX")));
    }
    @Test
    public void Pop(){
        Stack<Integer> TestInt = new Stack<>(192);
        TestInt.push(168);
        TestInt.push(0);
        TestInt.push(1);
        assertThat(TestInt.getsize(), is(equalTo(4)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(1)));
        TestInt.pop();
        assertThat(TestInt.getsize(), is(equalTo(3)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(0)));
        TestInt.pop();
        assertThat(TestInt.getsize(), is(equalTo(2)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(168)));
        TestInt.pop();
        assertThat(TestInt.getsize(), is(equalTo(1)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(192)));
        TestInt.pop();
        assertThat(TestInt.getsize(), is(equalTo(0)));
        assertThat(TestInt.isEmpty(), is(equalTo(true)));
        assertThat(TestInt.peek(), nullValue());
        try {
            TestInt.pop();
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is(equalTo("This is an empty stack.")));     // Testing exception
        }
    }
}