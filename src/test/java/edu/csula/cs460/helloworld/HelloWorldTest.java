package edu.csula.cs460.helloworld;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void sayHelloAI() {
        HelloWorld hello = new HelloWorld();

        assertEquals(
            "Test case 1 - `Hello, AI`",
            "Hello, AI",
            hello.saySomething("AI")
        );
    }
}
