package edu.csula.cs460.helloworld;

public class HelloWorld extends Hello {
    @Override
    public String saySomething(String message) {
        return "Hello, " + message;
    }
}
