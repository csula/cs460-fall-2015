package edu.csula.cs460.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class HelloWorldTest {
    private HelloWorld hello;

    @Before
    public void setUp() {
        HelloWorld hello = new HelloWorld();
    }

    @Test
    public void sayHelloAI() {
        assertEquals(
            "Test case 1 - `Hello, CS 460`",
            "Hello, CS 460",
            hello.saySomething("CS 460")
        );
    }

    @Test
    public void sayHelloAI() {
        assertEquals(
            "Test case 2 - `Hello, Artificial Intelligence`",
            "Hello, Artificial Intelligence",
            hello.saySomething("Artificial Intelligence")
        );
    }
}
