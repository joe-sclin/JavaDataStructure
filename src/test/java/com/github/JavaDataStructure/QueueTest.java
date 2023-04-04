package com.github.JavaDataStructure;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class QueueTest {
    @Test
    public void TestEmptyConstructor(){     // Test of empty constructor and basic functions of Queue
        Queue<String> test = new Queue<>();
        assertThat(test.getsize(), is(equalTo(0)));
        assertThat(test.isEmpty(), is(equalTo(true)));
        assertThat(test.peek(), nullValue());
    }
    @Test
    public void ConstructorContainer(){     // Test of constructors for datatypes and basic functions of Queue
        Queue<String> TestStr = new Queue<>("ABC");
        assertThat(TestStr.getsize(), is(equalTo(1)));
        assertThat(TestStr.isEmpty(), is(equalTo(false)));
        assertThat(TestStr.peek().getContent(), instanceOf(String.class));

        Queue<Character> TestChar = new Queue<>('X');
        assertThat(TestChar.peek().getContent(), instanceOf(Character.class));
        Queue<Integer> TestInt = new Queue<>(100);
        assertThat(TestInt.peek().getContent(), instanceOf(Integer.class));
        Queue<Double> TestDouble = new Queue<>(1.2345);
        assertThat(TestDouble.peek().getContent(), instanceOf(Double.class));
        Queue<Boolean> TestBool = new Queue<>(true);
        assertThat(TestBool.peek().getContent(), instanceOf(Boolean.class));
    }

    @Test
    public void Add(){
        Queue<Integer> TestInt = new Queue<>();    // Push function starts with empty Queue
        TestInt.add(192);
        TestInt.add(168);
        TestInt.add(0);
        TestInt.add(1);
        assertThat(TestInt.getsize(), is(equalTo(4)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(192)));

        Queue<String> TestStr = new Queue<>("WWWW");
        TestStr.add("XXX");
        TestStr.add("YY");
        assertThat(TestStr.getsize(), is(equalTo(3)));
        assertThat(TestStr.isEmpty(), is(equalTo(false)));
        assertThat(TestStr.peek().getContent(), is(equalTo("WWWW")));
        assertThat(TestStr.peek().getSuccessor().getContent(), is(equalTo("XXX")));
    }
    @Test
    public void Remove(){
        Queue<Integer> TestInt = new Queue<>(192);
        TestInt.add(168);
        TestInt.add(0);
        TestInt.add(1);
        assertThat(TestInt.getsize(), is(equalTo(4)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(192)));
        TestInt.remove();
        assertThat(TestInt.getsize(), is(equalTo(3)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(168)));
        TestInt.remove();
        assertThat(TestInt.getsize(), is(equalTo(2)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(0)));
        TestInt.remove();
        assertThat(TestInt.getsize(), is(equalTo(1)));
        assertThat(TestInt.isEmpty(), is(equalTo(false)));
        assertThat(TestInt.peek().getContent(), is(equalTo(1)));
        TestInt.remove();
        assertThat(TestInt.getsize(), is(equalTo(0)));
        assertThat(TestInt.isEmpty(), is(equalTo(true)));
        assertThat(TestInt.peek(), nullValue());
        try {
            TestInt.remove();
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is(equalTo("This is an empty Queue.")));     // Testing exception
        }
    }
}