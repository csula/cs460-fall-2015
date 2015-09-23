package edu.csula.cs460.helloworld;

public class HelloWorld extends Hello {
    // simply return `Hello, {message}` as simple show case of how unit test works
    public String saySomething(String message) {
        return "Hello, " + message;
    }
}
